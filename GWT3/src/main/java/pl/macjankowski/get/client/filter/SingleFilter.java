package pl.macjankowski.get.client.filter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 *
 */
public class SingleFilter extends FilterPanel {

	private static SingleFilterUiBinder uiBinder = GWT.create(SingleFilterUiBinder.class);

	interface SingleFilterUiBinder extends UiBinder<Widget, SingleFilter> {
	}
	
	
	

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public SingleFilter() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox valueBox;
	

	public SingleFilter(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
	}


	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setText(String arg0) {
		// TODO Auto-generated method stub
		
	}

}
