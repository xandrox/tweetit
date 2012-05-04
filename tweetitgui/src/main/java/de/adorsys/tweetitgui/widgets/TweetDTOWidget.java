package de.adorsys.tweetitgui.widgets;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;

import de.adorsys.tweetitgui.model.TweetDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class TweetDTOWidget extends Composite implements Editor<TweetDTO> {

	private static final TweetDTOUiBinder UI_BINDER = GWT
			.create(TweetDTOUiBinder.class);

	private final TweetDTOEditorDriver editorDriver = GWT
			.create(TweetDTOEditorDriver.class);

	interface TweetDTOUiBinder extends UiBinder<Widget, TweetDTOWidget> {
	}

	public interface TweetDTOEditorDriver extends
			SimpleBeanEditorDriver<TweetDTO, TweetDTOWidget> {
	}

	@UiField
	ValueBoxEditorDecorator<String> userId;
	@UiField
	ValueBoxEditorDecorator<String> message;

	public TweetDTOWidget() {
		this(new TweetDTO());
	}

	public TweetDTOWidget(TweetDTO dataObject) {
		initWidget(UI_BINDER.createAndBindUi(this));
		editorDriver.initialize(this);
		editorDriver.edit(dataObject);
	}

	public TweetDTOEditorDriver getEditorDriver() {
		return editorDriver;
	}

	public void showErrors(Set<ConstraintViolation<TweetDTO>> validate) {
		editorDriver
				.setConstraintViolations(new ArrayList<ConstraintViolation<?>>(
						validate));
	}

}