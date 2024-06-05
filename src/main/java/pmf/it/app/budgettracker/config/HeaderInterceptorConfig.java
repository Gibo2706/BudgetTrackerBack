package pmf.it.app.budgettracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pmf.it.app.budgettracker.interceptor.TokenInterceptor;

@Configuration
public class HeaderInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenInterceptor());
	}
	
	@Bean
	TokenInterceptor tokenInterceptor() {
		return new TokenInterceptor();
	}
}
