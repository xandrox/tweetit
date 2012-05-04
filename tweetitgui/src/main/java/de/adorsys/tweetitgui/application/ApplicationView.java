
package de.adorsys.tweetitgui.application;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.mvp4g.client.presenter.PresenterInterface;
import com.mvp4g.client.view.ReverseViewInterface;

import de.adorsys.tweetitgui.Messages;
import de.adorsys.tweetitgui.TweetitguiEventBus;

public interface ApplicationView extends IsWidget, ReverseViewInterface<ApplicationView.ApplicationPresenter> {
	
	public interface ApplicationPresenter extends PresenterInterface<ApplicationView, TweetitguiEventBus> {

		
	}

	SimplePanel getBody();

}
