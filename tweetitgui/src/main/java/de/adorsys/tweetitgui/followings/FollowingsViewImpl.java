
package de.adorsys.tweetitgui.followings;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

import de.adorsys.tweetitgui.ReverseCompositeView;
import de.adorsys.tweetitgui.followings.FollowingsView.FollowingsPresenter;
import de.adorsys.tweetitgui.model.FollowingUser;
import de.adorsys.tweetitgui.widgets.FollowingUserTableWidget;

@Singleton
public class FollowingsViewImpl extends ReverseCompositeView<FollowingsPresenter> implements FollowingsView {

    private static RootViewUiBinder uiBinder = GWT.create( RootViewUiBinder.class );
    
    @UiField
    FollowingUserTableWidget userTableWidget;

    interface RootViewUiBinder extends UiBinder<Widget, FollowingsViewImpl> {
    }

    public FollowingsViewImpl() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }
    
    public void setValue(List<FollowingUser> users) {
    	userTableWidget.setValue(users);
    }

}