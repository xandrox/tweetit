
package de.adorsys.tweetitgui.application;

import javax.validation.Validator;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.adorsys.tweetitgui.Messages;
import de.adorsys.tweetitgui.TweetitguiEventBus;
import de.adorsys.tweetitgui.application.ApplicationView.ApplicationPresenter;

@Presenter( view = ApplicationViewImpl.class )
public class ApplicationPresenterImpl extends BasePresenter<ApplicationView, TweetitguiEventBus> implements ApplicationPresenter {
	

	
}