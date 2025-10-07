package stark.coderaider.titan.treasure.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stark.coderaider.titan.treasure.core.domain.dtos.requests.GetPresignedUrlForUploadRequest;
import stark.coderaider.titan.treasure.core.services.AvatarService;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@RestController
@RequestMapping("/avatar")
public class AvatarController
{
    @Autowired
    private AvatarService avatarService;

    @GetMapping("/upload-url")
    public ServiceResponse<String> getPresignedUrlForUpload(@ModelAttribute GetPresignedUrlForUploadRequest request)
    {
        return avatarService.getPresignedUrlForUpload(request);
    }
}
