package pl.macjankowski.get.client.filter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 * 
 */
public class SplitBranchPanel extends FilterPanel {

	private static SplitBranchPanelUiBinder uiBinder = GWT.create(SplitBranchPanelUiBinder.class);

	interface SplitBranchPanelUiBinder extends UiBinder<Widget, SplitBranchPanel> {
	}

	@UiField(provided = true)
	FilterPanel upperPanel = new SingleFilter();

	@UiField(provided = true)
	FilterPanel lowerPanel = new SingleFilter();

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 */
	public SplitBranchPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		setHeight("200px");

		Timer timer = new Timer() {
			public void run() {
				extendLowerPanel();
			}
		};

		timer.schedule(5 * 1000);
	}

	public void extendUpperPanel() {
		upperPanel = new SplitBranchPanel();
	}

	public void extendLowerPanel() {
		lowerPanel = new SplitBranchPanel();
	}

	public void collapseUpperPanel() {
		upperPanel = new SingleFilter();
	}

	public void collapseLowerPanel() {
		lowerPanel = new SingleFilter();
	}

}
