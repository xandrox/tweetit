
package de.adorsys.tweetitgui.followings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;


import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.followings.FollowingsView.FollowingsPresenter;
import de.adorsys.tweetitgui.model.FollowingUser;
import de.adorsys.tweetitgui.model.User;
import de.adorsys.tweetitgui.service.UserService;

@Presenter( view = FollowingsViewImpl.class )
public class FollowingsPresenterImpl extends BasePresenter<FollowingsView, TweetitguiEventBus> implements FollowingsPresenter {

	@Inject
	private UserService userService;
	
	public void onStart() {
		List<FollowingUser> users = Arrays.asList(new FollowingUser("sso@adorsys.de", "Sandro", false));
		userService.listUsers(new MethodCallback<List<User>>() {
			
			@Override
			public void onSuccess(Method method, List<User> response) {
				ArrayList<FollowingUser> followingUsers = new ArrayList<FollowingUser>();
				for (User user : response) {
					followingUsers.add(new FollowingUser(user.getUserId(), user.getNickname(), false));
				}
				getView().setValue(followingUsers);
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				
			}
		});
		
		
	}
	
}