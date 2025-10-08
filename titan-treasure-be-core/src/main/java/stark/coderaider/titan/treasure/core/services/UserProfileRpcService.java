package stark.coderaider.titan.treasure.core.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stark.coderaider.titan.treasure.api.IUserProfileRpcService;
import stark.coderaider.titan.treasure.api.dtos.responses.UserProfileInfo;
import stark.coderaider.titan.treasure.core.dao.UserProfileMapper;
import stark.coderaider.titan.treasure.core.domain.entities.mysql.UserProfile;
import stark.dataworks.boot.autoconfig.web.LogArgumentsAndResponse;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@DubboService
@Service
@LogArgumentsAndResponse
public class UserProfileRpcService implements IUserProfileRpcService
{
    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public ServiceResponse<UserProfileInfo> getUserProfileInfo(long userId)
    {
        UserProfile userProfile = userProfileMapper.getUserProfileByUserId(userId);
        if (userProfile == null)
            return ServiceResponse.buildErrorResponse(-2, "There is no user with ID: " + userId);

        UserProfileInfo userProfileInfo = new UserProfileInfo();
        BeanUtils.copyProperties(userProfile, userProfileInfo);
        return ServiceResponse.buildSuccessResponse(userProfileInfo);
    }
}
