
package de.adorsys.tweetitgui.tweeter;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import de.adorsys.tweetitgui.model.TweetDTO;
import de.adorsys.tweetitgui.tweeter.TweeterView.TweeterPresenter;
import de.adorsys.tweetitgui.widgets.TweetDTOWidget;
import de.adorsys.tweetitgui.ReverseCompositeView;

public class TweeterViewImpl extends ReverseCompositeView<TweeterPresenter> implements TweeterView {

    private static RootViewUiBinder uiBinder = GWT.create( RootViewUiBinder.class );

    interface RootViewUiBinder extends UiBinder<Widget, TweeterViewImpl> {
    }
    
    @UiField
    TweetDTOWidget tweetWidget;
    
    @Inject
    Validator validator;

    public TweeterViewImpl() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }
    
    @UiHandler("postMsg")
    public void post(ClickEvent e) {
    	TweetDTO tweet = tweetWidget.getEditorDriver().flush();
    	Set<ConstraintViolation<TweetDTO>> errors = validator.validate(tweet);
    	if (!errors.isEmpty()) {
    		tweetWidget.getEditorDriver().setConstraintViolations(new ArrayList<ConstraintViolation<?>>(errors));
    	} else {
    		getPresenter().postTweet(tweet);
    	}
    }

}