package de.adorsys.tweetitgui.widgets;

import java.util.ArrayList;
import java.util.List;

import de.adorsys.tweetitgui.model.User;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class UserTableWidget extends Composite implements
		LeafValueEditor<List<User>> {

	private static final UserListUiBinder UI_BINDER = GWT
			.create(UserListUiBinder.class);

	interface UserListUiBinder extends UiBinder<Widget, UserTableWidget> {
	}

	private ListDataProvider<User> dataProvider = new ListDataProvider<User>();

	@Override
	public void setValue(List<User> value) {
		dataProvider.setList(value);
	}

	@Override
	public List<User> getValue() {
		dataProvider.flush();
		return new ArrayList<User>(dataProvider.getList());
	}

	@UiField
	CellTable<User> table;

	@UiField(provided = true)
	SimplePager pager = new SimplePager(TextLocation.CENTER,
			(SimplePager.Resources) GWT.create(SimplePager.Resources.class),
			false, 0, true);

	public UserTableWidget() {
		initWidget(UI_BINDER.createAndBindUi(this));
		table.addColumn(new Column<User, String>(new EditTextCell()) {
			{
				setFieldUpdater(new FieldUpdater<User, String>() {
					@Override
					public void update(int index, User object, String value) {
						object.setUserId(String.valueOf(value));
					}
				});
			}

			@Override
			public String getValue(User object) {
				return String.valueOf(object.getUserId());
			}

		}, "UserId");
		table.addColumn(new Column<User, String>(new EditTextCell()) {
			{
				setFieldUpdater(new FieldUpdater<User, String>() {
					@Override
					public void update(int index, User object, String value) {
						object.setNickname(String.valueOf(value));
					}
				});
			}

			@Override
			public String getValue(User object) {
				return String.valueOf(object.getNickname());
			}

		}, "Nickname");
		table.addColumn(new Column<User, String>(new EditTextCell()) {
			{
				setFieldUpdater(new FieldUpdater<User, String>() {
					@Override
					public void update(int index, User object, String value) {
						object.setFollowUser(Boolean.valueOf(value));
					}
				});
			}

			@Override
			public String getValue(User object) {
				return String.valueOf(object.getFollowUser());
			}

		}, "FollowUser");

		dataProvider.addDataDisplay(table);
		pager.setDisplay(table);
	}

}
