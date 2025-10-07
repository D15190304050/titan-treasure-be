package stark.coderaider.titan.treasure.core.domain.dtos.requests;

import lombok.Data;

@Data
public class GetPresignedUrlForUploadRequest
{
    private String fileName;
}
