package com.youtube.javabrains.RESTMessenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youtube.javabrains.RESTMessenger.database.DatabaseClass;
import com.youtube.javabrains.RESTMessenger.model.Message;
import com.youtube.javabrains.RESTMessenger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	static {
		Profile profile = new Profile(1L, "john", "john", "doe", new Date());
		profiles.put(profile.getProfileName(), profile);
	}

	public ProfileService() {

	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}	
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
