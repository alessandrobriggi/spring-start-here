package it.comment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.comment.model.Comment;

@Configuration
@ComponentScan(basePackages = { "it.comment" })
public class ProjectConfiguration {
	
	@Bean
	public Comment comment() {
		return new Comment("This task is too ambiguous...");
	}

}
