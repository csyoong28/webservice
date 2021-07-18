package com.youtube.javabrains.RESTMessenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.youtube.javabrains.RESTMessenger.database.DatabaseClass;
import com.youtube.javabrains.RESTMessenger.model.Comment;
import com.youtube.javabrains.RESTMessenger.model.ErrorMessage;
import com.youtube.javabrains.RESTMessenger.model.Message;

public class CommentService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	/*static {
		Message message1 = new Message(1L, "happy birthday guan", new Date(87, 3, 15), "cli");
		Message message2 = new Message(2L, "happy birthday yoong", new Date(84, 6, 28), "cli");
		Message message3 = new Message(3L, "happy birthday peng", new Date(87, 7, 9), "cli");
		Message message4 = new Message(4L, "happy birthday fui yee", new Date(89, 8, 16), "cli");
		messages.put(1L, message1);
		messages.put(2L, message2);
		messages.put(3L, message3);
		messages.put(4L, message4);
	}*/

	public CommentService() {

	}

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		Message message = messages.get(messageId);
		ErrorMessage errorMessage = new ErrorMessage("not found", 001, "http://RESTMessenger/doc.com");
		Response response= Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(errorMessage).build();
		
		if (message == null) {
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		if (comment == null) {
			throw new NotFoundException(response);
		}
		
		return comment;
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
