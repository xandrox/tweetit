
package de.adorsys.tweetitgui.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import de.adorsys.tweetitgui.application.ApplicationView.ApplicationPresenter;
import de.adorsys.tweetitgui.followings.FollowingsViewImpl;
import de.adorsys.tweetitgui.Messages;
import de.adorsys.tweetitgui.ReverseCompositeView;

public class ApplicationViewImpl extends ReverseCompositeView<ApplicationPresenter> implements ApplicationView {

    private static RootViewUiBinder uiBinder = GWT.create( RootViewUiBinder.class );
    
    @UiField
    FollowingsViewImpl followings;

    interface RootViewUiBinder extends UiBinder<Widget, ApplicationViewImpl> {
    }
    
    @UiField
    DivElement output;

    @Inject
    public ApplicationViewImpl(Messages messages) {
        initWidget( uiBinder.createAndBindUi( this ) );
        output.setInnerText(messages.testMessage("hallo"));
    }

}