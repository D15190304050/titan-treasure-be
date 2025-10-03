package stark.coderaider.titan.treasure.core.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import stark.coderaider.titan.treasure.api.IConnectionTestService;

@Slf4j
@DubboService
public class ConnectionTestService implements IConnectionTestService
{
    @Override
    public String sayHello(String name)
    {
        log.info("Enter sayHello(), name = {}", name);
        return "Hello, " + name;
    }
}
