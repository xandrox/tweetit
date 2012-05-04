
package de.adorsys.tweetitgui.tweeter;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.presenter.PresenterInterface;
import com.mvp4g.client.view.ReverseViewInterface;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.model.TweetDTO;

public interface TweeterView extends IsWidget, ReverseViewInterface<TweeterView.TweeterPresenter> {
	
	public interface TweeterPresenter extends PresenterInterface<TweeterView, TweetitguiEventBus> {

		void postTweet(TweetDTO tweet);
		
	}

}
