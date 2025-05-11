package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})

public interface TestConfig extends Config {
    @Key("baseUrl")
    String getBaseUrl();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();
}
