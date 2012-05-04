
package de.adorsys.tweetitgui.followings;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.presenter.PresenterInterface;
import com.mvp4g.client.view.ReverseViewInterface;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.model.FollowingUser;

public interface FollowingsView extends IsWidget, ReverseViewInterface<FollowingsView.FollowingsPresenter> {
	
	public interface FollowingsPresenter extends PresenterInterface<FollowingsView, TweetitguiEventBus> {
		
	}

	void setValue(List<FollowingUser> users);

}
