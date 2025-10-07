package stark.coderaider.titan.treasure.core.services;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import stark.coderaider.titan.treasure.core.config.AliyunOssClientConfiguration;
import stark.coderaider.titan.treasure.core.domain.dtos.requests.GetPresignedUrlForUploadRequest;
import stark.coderaider.titan.treasure.core.domain.dtos.responses.GetPresignedUrlForUploadResponse;
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
    public static final String PATTERN_AVATAR_URL = "https://%s.%s/%s";

    public static final List<String> ALLOWED_FILE_EXTENSIONS = List.of("png", "jpg", "jpeg");

    @Value("${oss.bucket-name-avatars}")
    private String bucketNameAvatars;

    @Autowired
    private OSS ossClient;

    public ServiceResponse<GetPresignedUrlForUploadResponse> getPresignedUrlForUpload(GetPresignedUrlForUploadRequest request)
    {
        String fileName = request.getFileName();

        // Validate file extension.
        int lastIndexOfDot = fileName.lastIndexOf(".");
        String fileExtension = fileName.substring(lastIndexOfDot + 1);
        if (!ALLOWED_FILE_EXTENSIONS.contains(fileExtension))
            return ServiceResponse.buildErrorResponse(-23, "File extension " + fileExtension + " is not allowed. Allowed file extensions: " + ALLOWED_FILE_EXTENSIONS);

        // Expires in 10 minutes, unit: milliseconds.
        GeneratePresignedUrlRequest generatePresignedUrlRequest = prepareGeneratePresignedUrlRequest(fileName, fileExtension);
        // 通过HTTP PUT请求生成预签名URL。
        URL signedUrl = ossClient.generatePresignedUrl(generatePresignedUrlRequest);

        GetPresignedUrlForUploadResponse response = new GetPresignedUrlForUploadResponse();
        response.setUploadUrl(signedUrl.toString());
        response.setObjectUrl(getAvatarUrl(fileName));

        return ServiceResponse.buildSuccessResponse(response);
    }

    private GeneratePresignedUrlRequest prepareGeneratePresignedUrlRequest(String fileName, String fileExtension)
    {
        Date expiration = new Date(new Date().getTime() + 10 * 60 * 1000);

        // 生成预签名URL。
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketNameAvatars, fileName, HttpMethod.PUT);

        // Determine Content-Type based on file extension
        String contentType = getContentType(fileExtension);
        generatePresignedUrlRequest.addHeader("Content-Type", contentType);

        // 设置过期时间。
        generatePresignedUrlRequest.setExpiration(expiration);
        return generatePresignedUrlRequest;
    }

    private static String getContentType(String fileExtension)
    {
        String contentType = switch (fileExtension)
        {
            case "png" -> "image/png";
            case "jpg", "jpeg" -> "image/jpeg";
            default -> "application/octet-stream";
        };
        return contentType;
    }

    private String getAvatarUrl(String fileName)
    {
        // https://examplebucket.oss-cn-hangzhou.aliyuncs.com/example.txt
//        return "https://" + bucketNameAvatars + ".oss-cn-hangzhou.aliyuncs.com/" + fileName;
        return String.format(PATTERN_AVATAR_URL, bucketNameAvatars, AliyunOssClientConfiguration.ENDPOINT, fileName);
    }
}
