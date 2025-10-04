package stark.coderaider.titan.treasure.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/connection")
public class ConnectionTestController
{
    @GetMapping("/hello")
    public String sayHello(String name)
    {
        log.info("Enter sayHello(), name = {}", name);
        return "hello " + name;
    }
}
