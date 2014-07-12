package pl.macjankowski.get.client.filter2;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 * 
 */
public class ComplexFilterPanel extends Composite {

	private static ComplexFilterPanel2UiBinder uiBinder = GWT.create(ComplexFilterPanel2UiBinder.class);

	interface ComplexFilterPanel2UiBinder extends UiBinder<Widget, ComplexFilterPanel> {
	}

	public interface ComplexFilterPanelActions2 {
		public void onCollapse();
	}

	@UiField
	Button collapse;

	@UiField
	ListBox opListBox;

	@UiField(provided = true)
	final SwapPanel upperPanel;

	@UiField(provided = true)
	final SwapPanel lowerPanel;

	private final ComplexFilterPanelActions2 parent;


	public ComplexFilterPanel(ComplexFilterPanelActions2 parent, int depth) {
		this.parent = parent;
		this.upperPanel = new SwapPanel(depth);
		this.lowerPanel = new SwapPanel(depth);

		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void updateUpperPanelState(FilterState simplePanelState){
		
	}

	@UiHandler("collapse")
	void onClick(ClickEvent e) {
		parent.onCollapse();
	}

}
