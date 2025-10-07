package stark.coderaider.titan.treasure.core.domain.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetPresignedUrlForUploadRequest
{
    @NotBlank(message = "File name cannot be blank.")
    private String fileName;
}
