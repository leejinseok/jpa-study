package com.example.jpa.config.property;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.jpa")
@Getter
@Setter
public class JpaProperties {

    private String databasePlatform;
    private boolean openInView;
    private boolean showSql;
    private Map<String, Object> properties = new HashMap<>();

}
