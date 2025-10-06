package stark.coderaider.titan.treasure.core.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import stark.coderaider.titan.gate.api.IAuthenticationService;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@Service
@DubboService
public class UserProfileService
{
    @DubboReference(url = "${dubbo.service.titan-gate-be.url}")
    private IAuthenticationService authenticationService;

    public ServiceResponse<Boolean> userRegister()
    {


        return ServiceResponse.buildSuccessResponse(true);
    }
}
