package it.comment.repository;

import org.springframework.stereotype.Repository;

import it.comment.model.Comment;

@Repository
public class DBCommentRepository implements CommentRepository {
	
//	Variabili di connessione al db
	
	public void saveComment(Comment comment) {
//		codice che salva il commento nel db, ora sostituito da:
		System.out.println("Saving comment \"" + comment.getComment() + "\" in DB...");
	}

}
