package com.youtube.javabrains.RESTMessenger.database;

import java.util.HashMap;
import java.util.Map;

import com.youtube.javabrains.RESTMessenger.model.Message;
import com.youtube.javabrains.RESTMessenger.model.Profile;

//this is just a fake DB, is not thread safe, cannot write like this in production
public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
