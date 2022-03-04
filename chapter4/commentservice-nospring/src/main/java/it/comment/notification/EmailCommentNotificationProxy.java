package it.comment.notification;

import it.comment.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {
	
//	Variabili per inviare le email

	@Override
	public void sendNotification(Comment comment) {
//		codice per inviare mail ora sostituito da:
		System.out.println("Sending email notification for comment \"" + comment.getComment() + "\"...");
	}

}
