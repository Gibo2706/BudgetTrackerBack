package pmf.it.app.budgettracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pmf.it.app.budgettracker.interceptor.TokenHolder;

@Configuration
public class WebConfig {
	
	
	@Bean
    @Scope()
    TokenHolder tokenHolder() {
		return new TokenHolder();
	}
}
