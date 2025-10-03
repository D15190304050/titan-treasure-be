package stark.coderaider.titan.treasure.core.domain.entities.mysql.schemas;

import stark.coderaider.fluentschema.commons.schemas.SchemaSnapshotBase;
import java.util.List;

public class SchemaSnapshot extends SchemaSnapshotBase {
    @Override
    public void buildSchema() {
        schemaBuilder.table("user_location", builder -> {
            builder.column().name("user_id").type("BIGINT").nullable(false).unique(true).comment("IAM user ID.");
            builder.column().name("province").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("Province of the location.");
            builder.column().name("city").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("City of the location.");
            builder.column().name("district").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("District of the location.");
            builder.column().name("street").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("Street of the location.");
            builder.column().name("building_number").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("Building number of the location.");
            builder.column().name("latitude").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("Latitude of the location.");
            builder.column().name("longitude").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("Longitude of the location.");
            builder.column().name("id").type("BIGINT").nullable(false).unique(false).autoIncrement(1);
            builder.column().name("creator_id").type("BIGINT").nullable(false).unique(false);
            builder.column().name("creation_time").type("DATETIME").nullable(true).unique(false).defaultValue("NOW()");
            builder.column().name("modifier_id").type("BIGINT").nullable(false).unique(false);
            builder.column().name("modification_time").type("DATETIME").nullable(true).unique(false)
                    .defaultValue("NOW()").onUpdate("NOW()");
            builder.primaryKey().columnName("id");
            builder.engine("InnoDB");
            builder.comment("Location information of users.");
        });
        schemaBuilder.table("user_profile", builder -> {
            builder.column().name("user_id").type("BIGINT").nullable(false).unique(true).comment("IAM user ID.");
            builder.column().name("nickname").type("VARCHAR(50)").nullable(false).unique(false)
                    .comment("Nickname of the user.");
            builder.column().name("avatar_url").type("VARCHAR(255)").nullable(true).unique(false)
                    .comment("Avatar URL.");
            builder.column().name("bio").type("VARCHAR(255)").nullable(true).unique(false).comment("Bio.");
            builder.column().name("birthday").type("DATETIME").nullable(true).unique(false)
                    .comment("Birthday of the user.");
            builder.column().name("gender").type("INT").nullable(false).unique(false)
                    .comment("Gender of the user: 0 - Unknown; 1 - Male; 2 - Female.");
            builder.column().name("id").type("BIGINT").nullable(false).unique(false).autoIncrement(1);
            builder.column().name("creator_id").type("BIGINT").nullable(false).unique(false);
            builder.column().name("creation_time").type("DATETIME").nullable(true).unique(false).defaultValue("NOW()");
            builder.column().name("modifier_id").type("BIGINT").nullable(false).unique(false);
            builder.column().name("modification_time").type("DATETIME").nullable(true).unique(false)
                    .defaultValue("NOW()").onUpdate("NOW()");
            builder.primaryKey().columnName("id");
            builder.engine("InnoDB");
            builder.comment("Profile of users.");
        });
        schemaBuilder.table("user_system_preference", builder -> {
            builder.column().name("user_id").type("BIGINT").nullable(false).unique(true).comment("IAM user ID.");
            builder.column().name("preferred_language_code").type("VARCHAR(50)").nullable(true).unique(false)
                    .comment("Code of the preferred language.");
            builder.column().name("app_theme").type("VARCHAR(50)").nullable(true).unique(false)
                    .comment("Theme of the App.");
            builder.column().name("email_notification").type("BOOL").nullable(false).unique(false)
                    .comment("Whether to receive email notifications.");
            builder.column().name("sms_notification").type("BOOL").nullable(false).unique(false)
                    .comment("Whether to receive SMS notifications.");
            builder.column().name("id").type("BIGINT").nullable(false).unique(false).autoIncrement(1);
            builder.column().name("creator_id").type("BIGINT").nullable(false).unique(false);
            builder.column().name("creation_time").type("DATETIME").nullable(true).unique(false).defaultValue("NOW()");
            builder.column().name("modifier_id").type("BIGINT").nullable(false).unique(false);
            builder.column().name("modification_time").type("DATETIME").nullable(true).unique(false)
                    .defaultValue("NOW()").onUpdate("NOW()");
            builder.primaryKey().columnName("id");
            builder.engine("InnoDB");
            builder.comment("System preferences of users.");
        });
    }
}