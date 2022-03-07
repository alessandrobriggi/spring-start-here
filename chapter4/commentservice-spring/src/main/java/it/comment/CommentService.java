package it.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.comment.model.Comment;
import it.comment.notification.CommentNotificationProxy;
import it.comment.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository repository;
	private CommentNotificationProxy notificationProxy;

	@Autowired
	public CommentService(CommentRepository repository, CommentNotificationProxy notificationProxy) {
		this.setRepository(repository);
		this.setNotificationProxy(notificationProxy);
	}

	public void publishComment(Comment comment) {
//		codice che pubblica il commento ora sostituito da:
		System.out.println("Publishing comment \"" + comment.getComment() + "\"...");
		
		repository.saveComment(comment);
		notificationProxy.sendNotification(comment);
	}

	public CommentRepository getRepository() {
		return repository;
	}

	public void setRepository(CommentRepository repository) {
		this.repository = repository;
	}

	public CommentNotificationProxy getNotificationProxy() {
		return notificationProxy;
	}

	public void setNotificationProxy(CommentNotificationProxy notificationProxy) {
		this.notificationProxy = notificationProxy;
	}

}
