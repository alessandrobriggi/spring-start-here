package it.comment.repository;

import it.comment.model.Comment;

public interface CommentRepository {

	void saveComment(Comment comment);
}
