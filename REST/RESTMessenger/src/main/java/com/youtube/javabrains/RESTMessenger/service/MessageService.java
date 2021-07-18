package com.youtube.javabrains.RESTMessenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youtube.javabrains.RESTMessenger.database.DatabaseClass;
import com.youtube.javabrains.RESTMessenger.exception.DataNotFoundException;
import com.youtube.javabrains.RESTMessenger.model.Comment;
import com.youtube.javabrains.RESTMessenger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	static {
		Message message1 = new Message(1L, "happy birthday yoong", new Date(84, 6, 28), "cli");
		Message message2 = new Message(2L, "happy birthday guan", new Date(87, 3, 15), "cli");
		Message message3 = new Message(3L, "happy birthday peng", new Date(87, 7, 9), "cli");
		Message message4 = new Message(4L, "happy birthday fui yee", new Date(89, 8, 16), "cli");
		
		//add comments for messages1
		Comment message1comment1 = new Comment(1L, "thank you", new Date(84, 6, 28), "csy");
		Comment message1comment2 = new Comment(2L, "hello world", new Date(84, 6, 28), "csy");
		Map<Long, Comment> commentsMap = new HashMap<>();
		commentsMap.put(1L, message1comment1);
		commentsMap.put(2L, message1comment2);
		message1.setComments(commentsMap);
		
		messages.put(1L, message1);
		messages.put(2L, message2);
		messages.put(3L, message3);
		messages.put(4L, message4);
	}

	public MessageService() {

	}

	public List<Message> getAllMessages() {
		Message message1 = new Message(1L, "happy birthday yoong", new Date(84, 6, 28), "cli");
		Message message2 = new Message(2L, "happy birthday guan", new Date(87, 3, 15), "cli");
		Message message3 = new Message(3L, "happy birthday peng", new Date(87, 7, 9), "cli");
		Message message4 = new Message(4L, "happy birthday fui yee", new Date(89, 8, 16), "cli");
		List<Message> list = new ArrayList<>();
		list.add(message1);
		list.add(message2);
		list.add(message3);
		list.add(message4);
		return list;
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message message: messages.values()) {
			calendar.setTime(message.getCreated());
			if (calendar.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;	
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if (start + size > list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start + size);
	}

	public List<Message> getAllMessagesEnhance1() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("message with Id:" + id + " not found");
		}
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
