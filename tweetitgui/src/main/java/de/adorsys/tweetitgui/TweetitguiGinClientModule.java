
package de.adorsys.tweetitgui;

import javax.validation.Validation;
import javax.validation.Validator;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class TweetitguiGinClientModule extends AbstractGinModule {
	public static class ValidationProvider implements Provider<Validator> {

		@Override
		public Validator get() {
			return Validation.buildDefaultValidatorFactory().getValidator();
		}
		
	}
	
	protected void configure() {
		bind(Validator.class).toProvider(ValidationProvider.class).in(Singleton.class);
	}
}