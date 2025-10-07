package stark.coderaider.titan.treasure.core.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stark.coderaider.titan.treasure.core.domain.dtos.requests.UserRegisterRequest;
import stark.coderaider.titan.treasure.core.services.UserProfileService;
import stark.dataworks.boot.web.ServiceResponse;

@Slf4j
@RestController
@RequestMapping("/profile")
public class UserProfileController
{
    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/register")
    public ServiceResponse<Boolean> userRegister(@RequestBody @Valid UserRegisterRequest request)
    {
        return userProfileService.userRegister(request);
    }
}
