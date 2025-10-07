package stark.coderaider.titan.treasure.core.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stark.coderaider.titan.gate.api.IAuthenticationService;
import stark.coderaider.titan.gate.api.dtos.requests.RegisterAuthenticationRequest;
import stark.coderaider.titan.treasure.core.dao.UserProfileMapper;
import stark.coderaider.titan.treasure.core.domain.dtos.requests.UserRegisterRequest;
import stark.coderaider.titan.treasure.core.domain.entities.mysql.UserProfile;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@Service
public class UserProfileService
{
    @Autowired
    private UserProfileMapper userProfileMapper;

    @DubboReference(url = "${dubbo.service.titan-gate-be.url}", check = false)
    private IAuthenticationService authenticationService;

    public ServiceResponse<Boolean> userRegister(UserRegisterRequest request)
    {
        ServiceResponse<Long> registerAuthenticationResponse = registerAuthentication(request);
        if (!registerAuthenticationResponse.isSuccess())
            return ServiceResponse.buildErrorResponse(registerAuthenticationResponse.getCode(), registerAuthenticationResponse.getMessage());

        insertUserProfile(request, registerAuthenticationResponse);

        return ServiceResponse.buildSuccessResponse(true);
    }

    private void insertUserProfile(UserRegisterRequest request, ServiceResponse<Long> registerAuthenticationResponse)
    {
        Long userId = registerAuthenticationResponse.getData();
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(userId);
        userProfile.setNickname(request.getNickname());
        userProfile.setAvatarUrl(request.getAvatarUrl());
        userProfile.setBio(request.getBio());
        userProfile.setGender(request.getGender());
        userProfile.setBirthday(request.getBirthday());
        userProfile.setCreatorId(userId);
        userProfile.setModifierId(userId);

        userProfileMapper.insert(userProfile);
    }

    private ServiceResponse<Long> registerAuthentication(UserRegisterRequest request)
    {
        RegisterAuthenticationRequest registerAuthenticationRequest = new RegisterAuthenticationRequest();
        registerAuthenticationRequest.setUsername(request.getUsername());
        registerAuthenticationRequest.setPassword(request.getPassword());
        registerAuthenticationRequest.setEmail(request.getEmail());
        registerAuthenticationRequest.setPhoneNumberCountryCode("+86");
        registerAuthenticationRequest.setPhoneNumber(request.getPhoneNumber());
        return authenticationService.registerAuthentication(registerAuthenticationRequest);
    }
}
