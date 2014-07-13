package pl.macjankowski.get.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 *
 */
public interface GreetingServiceAsync {

	/**
	 * 
	 * @see pl.macjankowski.get.client.GreetingService#greetServer(java.lang.String)
	 */
	void greetServer(String name, AsyncCallback<String> callback);

}
