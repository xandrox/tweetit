
package de.adorsys.tweetitgui;

import com.google.gwt.user.client.ui.SimplePanel;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

import de.adorsys.tweetitgui.application.ApplicationPresenterImpl;
import de.adorsys.tweetitgui.followings.FollowingsPresenterImpl;
import de.adorsys.tweetitgui.tweeter.TweeterPresenterImpl;

@Events(startPresenter=ApplicationPresenterImpl.class, ginModules=TweetitguiGinClientModule.class)
public interface TweetitguiEventBus extends EventBusWithLookup {
	
	@Start
	@Event(handlers={FollowingsPresenterImpl.class, ApplicationPresenterImpl.class})
	void start();
	
	@Event(handlers=TweeterPresenterImpl.class)
	void showTweeter(SimplePanel placeholder);
}