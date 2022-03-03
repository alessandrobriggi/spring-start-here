package it.componentannotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "it.componentannotation.model" })
public class ProjectConfiguration {

}
