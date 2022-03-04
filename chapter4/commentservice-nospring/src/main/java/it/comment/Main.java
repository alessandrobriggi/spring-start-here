package it.comment;

import it.comment.model.Comment;
import it.comment.notification.EmailCommentNotificationProxy;
import it.comment.repository.DBCommentRepository;

public class Main {

	public static void main(String[] args) {
		Comment comment = new Comment("This task is too ambiguous");
		CommentService service = new CommentService(new DBCommentRepository(), new EmailCommentNotificationProxy());
		service.publishComment(comment);
	}

}
