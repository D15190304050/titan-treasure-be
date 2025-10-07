package stark.coderaider.titan.treasure.core;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"stark.coderaider.titan.treasure.core", "stark.dataworks.boot.autoconfig"})
@EnableTransactionManagement
@EnableDubbo
public class TitanTreasureMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(TitanTreasureMain.class);
    }
}
