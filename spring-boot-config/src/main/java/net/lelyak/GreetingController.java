package net.lelyak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nazar Lelyak.
 */
@RefreshScope
@RestController
public class GreetingController {

    @Value("static message with @Value annotation")
    private String staticMessage;

    @Value("${my.greeting: default message}")
    private String message;

    @Value("${my.list}")
    private List<String> list;

    @Autowired
    private DbSettings dbSettings;


    @GetMapping("/hello")
    public String hello() {
//        final String dbMessage = String.join("; ", dbSettings.getConnection(), dbSettings.getHost(), dbSettings.getPort() + "");
//        System.out.println(dbMessage);
        return String.format("1. %s\n2. %s\n3. %s\n4. %s\n", staticMessage, message, list, dbSettings);
    }

    @GetMapping("/greeting")
    public String greeting() {
        return String.format("my.grreting: %s db.connection: %s", message, dbSettings.getConnection());
    }
}
