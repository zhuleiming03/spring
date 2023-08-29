package demo.config;

import demo.api.FallbackApi;
import demo.domain.Contract;
import demo.domain.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig implements FallbackApi {

    @Override
    public User getFallBackUser(Integer id) {
        return new User(id, Contract.SERVICE_NAME + "common error");
    }
}
