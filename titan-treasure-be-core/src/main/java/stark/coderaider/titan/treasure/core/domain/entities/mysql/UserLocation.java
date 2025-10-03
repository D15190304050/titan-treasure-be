package stark.coderaider.titan.treasure.core.domain.entities.mysql;

import lombok.Data;
import lombok.EqualsAndHashCode;
import stark.coderaider.fluentschema.commons.EntityBase;
import stark.coderaider.fluentschema.commons.NamingConvention;
import stark.coderaider.fluentschema.commons.annotations.Column;
import stark.coderaider.fluentschema.commons.annotations.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(namingConvention = NamingConvention.LOWER_CASE_WITH_UNDERSCORE, comment = "Location information of users.")
public class UserLocation extends EntityBase
{
    @Column(unique = true, comment = "IAM user ID.")
    private long userId;           // IAM 用户ID（外键）

    @Column(nullable = false, type = "VARCHAR(50)", comment = "Province of the location.")
    private String province;

    @Column(nullable = false, type = "VARCHAR(50)", comment = "City of the location.")
    private String city;

    @Column(nullable = false, type = "VARCHAR(50)", comment = "District of the location.")
    private String district;

    @Column(nullable = false, type = "VARCHAR(50)", comment = "Street of the location.")
    private String street;

    @Column(nullable = false, type = "VARCHAR(50)", comment = "Building number of the location.")
    private String buildingNumber; // 门牌号

    @Column(nullable = false, type = "VARCHAR(50)", comment = "Latitude of the location.")
    private String latitude;

    @Column(nullable = false, type = "VARCHAR(50)", comment = "Longitude of the location.")
    private String longitude;
}
