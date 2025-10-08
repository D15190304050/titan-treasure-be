package stark.coderaider.titan.treasure.api.dtos.responses;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserProfileInfo implements Serializable
{
    private long userId;           // IAM 用户ID（外键）
    private String nickname;       // 昵称，展示用，不要求唯一
    private String avatarUrl;      // 头像地址（OSS/CDN存储的链接）
    private String bio;            // 简介/签名
    private Date birthday;         // 生日
    private int gender;            // 性别：0=未知，1=男，2=女
}
