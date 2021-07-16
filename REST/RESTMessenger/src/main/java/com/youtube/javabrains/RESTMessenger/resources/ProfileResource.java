package com.youtube.javabrains.RESTMessenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.youtube.javabrains.RESTMessenger.model.Message;
import com.youtube.javabrains.RESTMessenger.model.Profile;
import com.youtube.javabrains.RESTMessenger.service.MessageService;
import com.youtube.javabrains.RESTMessenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam(value = "profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		/* send this in postman
		 * {
		    "created": "2021-07-17T03:00:32.986",
		    "firstName": "amy",
		    "lastName": "dammy",
		    "profileName": "amy"
		}*/
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam(value = "profileName") String profileName, Profile profile) {
		/* send this in postman
		 * {
		    "author": "mike",
		    "created": "2021-07-16T10:02:57.002",
		    "message": "change content"
		}*/
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteMessage(@PathParam(value = "profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
}
