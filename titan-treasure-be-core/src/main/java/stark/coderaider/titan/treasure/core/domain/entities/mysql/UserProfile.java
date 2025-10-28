package stark.coderaider.titan.treasure.core.domain.entities.mysql;

import lombok.Data;
import lombok.EqualsAndHashCode;
import stark.coderaider.fluentschema.commons.EntityBase;
import stark.coderaider.fluentschema.commons.NamingConvention;
import stark.coderaider.fluentschema.commons.annotations.Column;
import stark.coderaider.fluentschema.commons.annotations.Table;

import java.util.Date;

// TODO: Add some columns of IAM.
@Data
@EqualsAndHashCode(callSuper = true)
@Table(namingConvention = NamingConvention.LOWER_CASE_WITH_UNDERSCORE, comment = "Profile of users.")
public class UserProfile extends EntityBase
{
    @Column(unique = true, comment = "IAM user ID.")
    private long userId;           // IAM 用户ID（外键）

    @Column(type = "VARCHAR(50)", nullable = false, comment = "Nickname of the user.")
    private String nickname;       // 昵称，展示用，不要求唯一

    @Column(type = "VARCHAR(255)", comment = "Avatar URL.")
    private String avatarUrl;      // 头像地址（OSS/CDN存储的链接）

    @Column(type = "VARCHAR(255)", comment = "Bio.")
    private String bio;            // 简介/签名

    @Column(comment = "Birthday of the user.")
    private Date birthday;         // 生日

    @Column(comment = "Gender of the user: 0 - Unknown; 1 - Male; 2 - Female.")
    private int gender;            // 性别：0=未知，1=男，2=女

//    @Column(type = "VARCHAR(255)", comment = "Username of the user.")
//    private String username;
//
//    @Column(type = "VARCHAR(64)", nullable = false, comment = "Email address of the user.")
//    private String email;
//
//    @Column(type = "VARCHAR(5)", nullable = false, comment = "Phone number country code.")
//    private String phoneNumberCountryCode;
//
//    @Column(type = "VARCHAR(16)", nullable = false, comment = "Phone number.")
//    private String phoneNumber;
}
