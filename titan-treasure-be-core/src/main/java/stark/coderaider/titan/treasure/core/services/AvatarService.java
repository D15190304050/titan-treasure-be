package stark.coderaider.titan.treasure.core.services;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import stark.coderaider.titan.treasure.core.domain.dtos.requests.GetPresignedUrlForUploadRequest;
import stark.dataworks.boot.autoconfig.web.LogArgumentsAndResponse;
import stark.dataworks.boot.web.ServiceResponse;

import java.net.URL;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@LogArgumentsAndResponse
public class AvatarService
{
    public static final List<String> ALLOWED_FILE_EXTENSIONS = List.of("png", "jpg", "jpeg");

    @Value("${oss.bucket-name-avatars}")
    private String bucketNameAvatars;

    @Autowired
    private OSS ossClient;

    public ServiceResponse<String> getPresignedUrlForUpload(GetPresignedUrlForUploadRequest request)
    {
        String fileName = request.getFileName();

        // Validate file extension.
        int lastIndexOfDot = fileName.lastIndexOf(".");
        String fileExtension = fileName.substring(lastIndexOfDot + 1);
        if (!ALLOWED_FILE_EXTENSIONS.contains(fileExtension))
            return ServiceResponse.buildErrorResponse(-23, "File extension " + fileExtension + " is not allowed. Allowed file extensions: " + ALLOWED_FILE_EXTENSIONS);

        // Expires in 10 minutes, unit: milliseconds.
        Date expiration = new Date(new Date().getTime() + 10 * 60 * 1000);

        // 生成预签名URL。
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketNameAvatars, fileName, HttpMethod.PUT);

        // Determine Content-Type based on file extension
        String contentType = switch (fileExtension)
        {
            case "png" -> "image/png";
            case "jpg", "jpeg" -> "image/jpeg";
            default -> "application/octet-stream";
        };
        generatePresignedUrlRequest.addHeader("Content-Type", contentType);

        // 设置过期时间。
        generatePresignedUrlRequest.setExpiration(expiration);
        // 通过HTTP PUT请求生成预签名URL。
        URL signedUrl = ossClient.generatePresignedUrl(generatePresignedUrlRequest);

        return ServiceResponse.buildSuccessResponse(signedUrl.toString());
    }


}
