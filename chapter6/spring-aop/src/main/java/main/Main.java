package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.ProjectConfiguration;
import model.Comment;
import services.CommentService;

public class Main {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		Comment comment = new Comment("Task too ambiguous", "Alessandro Briggi");
		CommentService service = context.getBean(CommentService.class);
		service.publishComment(comment);
		context.close();
	}

}
