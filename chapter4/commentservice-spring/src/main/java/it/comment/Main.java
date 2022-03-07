package it.comment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.comment.model.Comment;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		Comment comment = new Comment("This task is too ambiguous");
		CommentService service =context.getBean(CommentService.class);
		service.publishComment(comment);
		context.close();
	}

}
