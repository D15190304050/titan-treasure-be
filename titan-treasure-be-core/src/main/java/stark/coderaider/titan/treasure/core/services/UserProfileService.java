package stark.coderaider.titan.treasure.core.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import stark.coderaider.titan.gate.api.IAuthenticationService;
import stark.coderaider.titan.treasure.core.domain.dtos.requests.UserRegisterRequest;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@Service
public class UserProfileService
{
    @Lazy
    @DubboReference(url = "${dubbo.service.titan-gate-be.url}", check = false)
    private IAuthenticationService authenticationService;



    public ServiceResponse<Boolean> userRegister(UserRegisterRequest request)
    {



//        authenticationService.registerAuthentication(request);

        return ServiceResponse.buildSuccessResponse(true);
    }
}
