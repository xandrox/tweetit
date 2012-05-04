package de.adorsys.tweetitgui.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import de.adorsys.tweetitgui.model.TweetDTO;

@Path("/tweetit.server/rest/tweets")
public interface TweetService extends RestService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createTweet(TweetDTO tweet, MethodCallback<TweetDTO> response);
}
