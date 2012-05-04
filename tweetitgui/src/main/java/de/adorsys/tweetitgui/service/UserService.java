package de.adorsys.tweetitgui.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import de.adorsys.tweetitgui.model.User;

@Path("/tweetit.server/rest/users")
public interface UserService extends RestService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void listUsers(MethodCallback<List<User>> users);

}
