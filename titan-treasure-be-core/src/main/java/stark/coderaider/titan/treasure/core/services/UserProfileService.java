package stark.coderaider.titan.treasure.core.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@Service
@DubboService
public class UserProfileService
{
    public ServiceResponse<Boolean> register()
    {


        return ServiceResponse.buildSuccessResponse(true);
    }
}
