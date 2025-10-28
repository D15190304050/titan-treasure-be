package stark.coderaider.titan.treasure.core.domain.dtos.responses;

import lombok.Data;

import java.util.Date;

@Data
public class FullUserProfileInfo
{
    /**
     * IAM 用户ID（外键）
     */
    private long id;

    /**
     * 昵称，展示用，不要求唯一
     */
    private String nickname;

    /**
     * 头像地址（OSS/CDN存储的链接）
     */
    private String avatarUrl;

    /**
     * 简介/签名
     */
    private String bio;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别：0=未知，1=男，2=女
     */
    private int gender;

    /**
     * Creation time of the account.
     */
    private Date creationTime;

    // From IAM.
    private String username;
    private String email;
    private String phoneNumberCountryCode;
    private String phoneNumber;
}
