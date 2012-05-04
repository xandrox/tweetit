package service;

import java.util.List;

import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import de.adorsys.tweetitgui.model.FollowingUser;

@Path("/tweetit.server/rest")
public interface UserService extends RestService {
	
	@Path("users")
	public void listUsers(MethodCallback<List<FollowingUser>> users);

}
