package it.comment.repository;

import it.comment.model.Comment;

public class DBCommentRepository implements CommentRepository {
	
//	Variabili di connessione al db
	
	public void saveComment(Comment comment) {
//		codice che salva il commento nel db, ora sostituito da:
		System.out.println("Saving comment \"" + comment.getComment() + "\" in DB...");
	}

}
