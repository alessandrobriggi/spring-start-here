package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspects.LoggingAspect;

@Configuration
@ComponentScan(basePackages = { "services" })
@EnableAspectJAutoProxy
public class ProjectConfiguration {
	
	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}

}
