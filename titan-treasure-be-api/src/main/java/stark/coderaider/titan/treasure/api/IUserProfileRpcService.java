package stark.coderaider.titan.treasure.api;

import stark.coderaider.titan.treasure.api.dtos.responses.UserProfileInfo;
import stark.dataworks.boot.dubbo.ValidateArgs;
import stark.dataworks.boot.web.ServiceResponse;

@ValidateArgs
public interface IUserProfileRpcService
{
    ServiceResponse<UserProfileInfo> getUserProfileInfo(long userId);
}
