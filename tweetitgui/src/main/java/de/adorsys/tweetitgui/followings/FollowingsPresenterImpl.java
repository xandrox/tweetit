
package de.adorsys.tweetitgui.followings;

import java.util.Arrays;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import service.UserService;

import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.followings.FollowingsView.FollowingsPresenter;
import de.adorsys.tweetitgui.model.FollowingUser;

@Presenter( view = FollowingsViewImpl.class )
public class FollowingsPresenterImpl extends BasePresenter<FollowingsView, TweetitguiEventBus> implements FollowingsPresenter {

	@Inject
	private UserService userService;
	
	public void onStart() {
		List<FollowingUser> users = Arrays.asList(new FollowingUser("sso@adorsys.de", "Sandro", false));
		userService.listUsers(new MethodCallback<List<FollowingUser>>() {
			
			@Override
			public void onSuccess(Method method, List<FollowingUser> response) {
				getView().setValue(response);
				
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
}