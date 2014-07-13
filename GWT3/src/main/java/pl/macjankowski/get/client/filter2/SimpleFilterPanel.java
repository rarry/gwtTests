package pl.macjankowski.get.client.filter2;

import pl.perfectsource.swing.common.search.ExtendedWorkField;
import pl.perfectsource.swing.common.search.Filter;
import pl.perfectsource.swing.common.search.tree.Expression;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 * 
 */
public class SimpleFilterPanel extends Composite {

	private static SingleFilterUiBinder uiBinder = GWT.create(SingleFilterUiBinder.class);

	interface SingleFilterUiBinder extends UiBinder<Widget, SimpleFilterPanel> {
	}

	@UiField
	TextBox valueBox;
	@UiField
	Button button;
	@UiField
	ListBox fieldListBox;
	@UiField
	ListBox opListBox;

	private final SingleFilterPanel2Actions parent;
	
	public SimpleFilterPanel(SingleFilterPanel2Actions parent) {
		this(parent, null);
	}
	
	public SimpleFilterPanel(SingleFilterPanel2Actions parent, FilterState state) {
		initWidget(uiBinder.createAndBindUi(this));
		
		if(state != null){
			fieldListBox.setSelectedIndex(state.getFieldListBoxIndex());
			opListBox.setSelectedIndex(state.getOpListBoxIndex());
			valueBox.setText(state.getValue());
		}
		
		this.parent = parent;
		this.button.setText("Expand");
	}

	public interface SingleFilterPanel2Actions {
		public void onExpand();
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		parent.onExpand(getFilterState());
	}
	
	private FilterState getFilterState(){
		return new FilterState.Builder()
		.setFieldListBoxIndex( fieldListBox.getSelectedIndex())
		.setOpListBoxIndex(opListBox.getSelectedIndex())
		.setValue(valueBox.getText())
		.build();
	}

	public Expression<ExtendedWorkField> getFilter() {
		Filter<ExtendedWorkField> filter = new Filter<ExtendedWorkField>();
		filter.setValue(valueBox.getText());
		return filter;
	}
}
