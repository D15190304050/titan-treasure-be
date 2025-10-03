package stark.coderaider.titan.treasure.core.domain.entities.mysql;

import lombok.Data;
import lombok.EqualsAndHashCode;
import stark.coderaider.fluentschema.commons.EntityBase;
import stark.coderaider.fluentschema.commons.NamingConvention;
import stark.coderaider.fluentschema.commons.annotations.Column;
import stark.coderaider.fluentschema.commons.annotations.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(namingConvention = NamingConvention.LOWER_CASE_WITH_UNDERSCORE, comment = "System preferences of users.")
public class UserSystemPreference extends EntityBase
{
    @Column(unique = true, comment = "IAM user ID.")
    private long userId;           // IAM 用户ID（外键）

    @Column(type = "VARCHAR(50)", comment = "Code of the preferred language.")
    private String preferredLanguageCode;       // 偏好语言（例如 "en-US", "zh-CN"）

    @Column(type = "VARCHAR(50)", comment = "Theme of the App.")
    private String appTheme;          // 主题设置（light/dark）

    @Column(type = "BOOL", comment = "Whether to receive email notifications.")
    private boolean emailNotification;  // 是否接收邮件通知

    @Column(type = "BOOL", comment = "Whether to receive SMS notifications.")
    private boolean smsNotification;    // 是否接收短信通知
}
