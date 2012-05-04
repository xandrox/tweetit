
package de.adorsys.tweetitgui.followings;

import java.util.Arrays;
import java.util.List;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.followings.FollowingsView.FollowingsPresenter;
import de.adorsys.tweetitgui.model.User;

@Presenter( view = FollowingsViewImpl.class )
public class FollowingsPresenterImpl extends BasePresenter<FollowingsView, TweetitguiEventBus> implements FollowingsPresenter {

	public void onStart() {
		List<User> users = Arrays.asList(new User("sso@adorsys.de", "Sandro", false));
		getView().setValue(users);
	}
	
}