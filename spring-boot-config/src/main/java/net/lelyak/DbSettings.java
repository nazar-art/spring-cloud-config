package net.lelyak;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nazar Lelyak.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "db")
public class DbSettings {

    private String connection;
    private String host;
    private int port;

}
