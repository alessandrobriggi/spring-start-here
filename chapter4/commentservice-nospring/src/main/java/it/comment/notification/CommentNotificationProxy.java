package it.comment.notification;

import it.comment.model.Comment;

public interface CommentNotificationProxy {
	
	void sendNotification(Comment comment);

}
