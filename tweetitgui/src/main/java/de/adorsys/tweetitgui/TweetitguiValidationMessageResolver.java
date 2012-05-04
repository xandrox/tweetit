
package de.adorsys.tweetitgui;

import org.hibernate.validator.ValidationMessages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.validation.client.AbstractValidationMessageResolver;
import com.google.gwt.validation.client.ProviderValidationMessageResolver;

public class TweetitguiValidationMessageResolver extends
    AbstractValidationMessageResolver implements
    ProviderValidationMessageResolver {

  public TweetitguiValidationMessageResolver() {
    super((ConstantsWithLookup) GWT.create(ValidationMessages.class));
  }
}