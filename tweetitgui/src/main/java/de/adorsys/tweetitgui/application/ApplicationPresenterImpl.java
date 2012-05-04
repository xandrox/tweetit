
package de.adorsys.tweetitgui.application;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.application.ApplicationView.ApplicationPresenter;

@Presenter( view = ApplicationViewImpl.class )
public class ApplicationPresenterImpl extends BasePresenter<ApplicationView, TweetitguiEventBus> implements ApplicationPresenter {

	public void onStart() {
		getEventBus().showTweeter(getView().getBody());
	}
	
}