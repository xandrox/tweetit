
package de.adorsys.tweetitgui.tweeter;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.model.TweetDTO;
import de.adorsys.tweetitgui.service.TweetService;
import de.adorsys.tweetitgui.tweeter.TweeterView.TweeterPresenter;

@Presenter( view = TweeterViewImpl.class )
public class TweeterPresenterImpl extends BasePresenter<TweeterView, TweetitguiEventBus> implements TweeterPresenter {

	private static final Logger LOG = LoggerFactory.getLogger(TweeterPresenterImpl.class);
	
	@Inject
	private TweetService tweetService;
	
	public void onShowTweeter(SimplePanel placeholder) {
		placeholder.setWidget(getView());
	}

	@Override
	public void postTweet(TweetDTO tweet) {
		LOG.debug(tweet.toString());
		
		tweetService.createTweet(tweet, new MethodCallback<TweetDTO>() {
			
			@Override
			public void onSuccess(Method method, TweetDTO response) {
				Window.alert(response.toString());
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				Window.alert(exception.toString());
				
			}
		});
	}
	
}