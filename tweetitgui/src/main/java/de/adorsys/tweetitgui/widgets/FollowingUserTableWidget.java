package de.adorsys.tweetitgui.widgets;

import java.util.ArrayList;
import java.util.List;

import de.adorsys.tweetitgui.model.FollowingUser;

import com.google.gwt.cell.client.CheckboxCell;
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

public class FollowingUserTableWidget extends Composite implements
		LeafValueEditor<List<FollowingUser>> {

	private static final UserListUiBinder UI_BINDER = GWT
			.create(UserListUiBinder.class);

	interface UserListUiBinder extends UiBinder<Widget, FollowingUserTableWidget> {
	}

	private ListDataProvider<FollowingUser> dataProvider = new ListDataProvider<FollowingUser>();

	@Override
	public void setValue(List<FollowingUser> value) {
		dataProvider.setList(value);
		dataProvider.flush();
	}

	@Override
	public List<FollowingUser> getValue() {
		return new ArrayList<FollowingUser>(dataProvider.getList());
	}

	@UiField
	CellTable<FollowingUser> table;

	@UiField(provided = true)
	SimplePager pager = new SimplePager(TextLocation.CENTER,
			(SimplePager.Resources) GWT.create(SimplePager.Resources.class),
			false, 0, true);

	public FollowingUserTableWidget() {
		initWidget(UI_BINDER.createAndBindUi(this));
		table.addColumn(new Column<FollowingUser, String>(new EditTextCell()) {
			{
				setFieldUpdater(new FieldUpdater<FollowingUser, String>() {
					@Override
					public void update(int index, FollowingUser object, String value) {
						object.setUserId(String.valueOf(value));
					}
				});
			}

			@Override
			public String getValue(FollowingUser object) {
				return String.valueOf(object.getUserId());
			}

		}, "UserId");
		table.addColumn(new Column<FollowingUser, String>(new EditTextCell()) {
			{
				setFieldUpdater(new FieldUpdater<FollowingUser, String>() {
					@Override
					public void update(int index, FollowingUser object, String value) {
						object.setNickname(String.valueOf(value));
					}
				});
			}

			@Override
			public String getValue(FollowingUser object) {
				return String.valueOf(object.getNickname());
			}

		}, "Nickname");
		table.addColumn(new Column<FollowingUser, Boolean>(new CheckboxCell()) {
			{
				setFieldUpdater(new FieldUpdater<FollowingUser, Boolean>() {
					@Override
					public void update(int index, FollowingUser object, Boolean value) {
						object.setFollowUser(value);
					}
				});
			}

			@Override
			public Boolean getValue(FollowingUser object) {
				return object.getFollowUser();
			}

		}, "FollowUser");

		dataProvider.addDataDisplay(table);
		pager.setDisplay(table);
	}

}
