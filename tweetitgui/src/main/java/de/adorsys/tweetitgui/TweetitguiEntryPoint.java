
package de.adorsys.tweetitgui;

import org.fusesource.restygwt.client.Defaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 * Dieser Entrypoint setzt spezifische Einstellung die vor dem laden der
 * Anwendung durchgefuehrt werden muessen.
 * 
 * @author Sandro Sonntag
 */
public class TweetitguiEntryPoint implements EntryPoint {

	private static final String REST_HTTP_SERVER = "http://localhost:8080";
	private static final Logger LOG = LoggerFactory
			.getLogger(TweetitguiEntryPoint.class);

	public TweetitguiEntryPoint() {

	}

	private void initRestyGWT() {
		if (isLocalEnv()) {
			LOG.info("Use local server on: " + REST_HTTP_SERVER);
			Defaults.setServiceRoot(REST_HTTP_SERVER);
		} else {
			Defaults.setServiceRoot(getCurrentHost());
		}
		// Defaults.setDispatcher(XXXX.INSTANCE);
	}

	private String getCurrentHost() {
		return Window.Location.getProtocol() + "//"
				+ Window.Location.getHostName() + ":"
				+ Window.Location.getPort();
	}

	private void initMVP4G() {
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();
		RootPanel.get().add((Widget) module.getStartView());
	}

	private boolean isLocalEnv() {
		return "8888".equals(Window.Location.getPort());
	}

	@Override
	public void onModuleLoad() {
		initRestyGWT();
		initMVP4G();
	}

}
