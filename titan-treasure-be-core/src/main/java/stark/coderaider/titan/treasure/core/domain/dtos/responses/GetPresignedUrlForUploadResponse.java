package stark.coderaider.titan.treasure.core.domain.dtos.responses;

import lombok.Data;

@Data
public class GetPresignedUrlForUploadResponse
{
    private String uploadUrl;
    private String objectUrl;
}
