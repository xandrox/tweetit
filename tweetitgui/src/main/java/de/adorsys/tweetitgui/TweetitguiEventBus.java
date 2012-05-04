
package de.adorsys.tweetitgui;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

import de.adorsys.tweetitgui.application.ApplicationPresenterImpl;
import de.adorsys.tweetitgui.followings.FollowingsPresenterImpl;

@Events(startPresenter=ApplicationPresenterImpl.class, ginModules=TweetitguiGinClientModule.class)
public interface TweetitguiEventBus extends EventBusWithLookup {
	
	@Start
	@Event(handlers=FollowingsPresenterImpl.class)
	void start();
}