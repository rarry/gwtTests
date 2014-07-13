package pl.macjankowski.get.client.filter2;

import pl.macjankowski.get.client.filter2.ComplexFilterPanel.ComplexFilterPanelActions2;
import pl.macjankowski.get.client.filter2.SimpleFilterPanel.SingleFilterPanel2Actions;
import pl.perfectsource.swing.common.search.ExtendedWorkField;
import pl.perfectsource.swing.common.search.tree.ComplexFilter;
import pl.perfectsource.swing.common.search.tree.Expression;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 * 
 */
public class SwapPanel extends VerticalPanel implements SingleFilterPanel2Actions, ComplexFilterPanelActions2 {

	private final static int MAX_DEPTH = 4;

	private SimpleFilterPanel simplePanel;
	private ComplexFilterPanel complexPanel;

	private final int depth;

	public SwapPanel(FilterState simplePanelState, int depth) {
		this.depth = depth;
		if (simplePanelState != null) {
			simplePanel = new SimpleFilterPanel(this, simplePanelState);
		}
		add(simplePanel);
	}

	private ComplexFilterPanel getComplexPanel() {
		if (this.complexPanel == null) {
			if (depth < MAX_DEPTH) {
				complexPanel = new ComplexFilterPanel(this, depth + 1);
				complexPanel.setVisible(false);
				add(complexPanel);
			}
		}
		return this.complexPanel;
	}

	@Override
	public void onExpand() {
		if (depth < MAX_DEPTH) {
			simplePanel.setVisible(false);
			
			Expression<ExtendedWorkField> upperState = new ComplexFilter.Builder<ExtendedWorkField>()
			.setLeftFilter(simplePanel.getFilter())
			.build();

			ComplexFilterPanel panel = getComplexPanel();
			panel.setVisible(true);
			panel.setFilter(upperState);
		}
	}

	@Override
	public void onCollapse() {
		if (depth < MAX_DEPTH) {
			simplePanel.setVisible(true);
			this.complexPanel.setVisible(false);
		}
	}

	public Expression<ExtendedWorkField> getFilter() {
		if (simplePanel.isVisible()) {
			return simplePanel.getFilter();
		} else if (complexPanel.isVisible()) {
			return complexPanel.getFilter();
		} else {
			throw new RuntimeException("Unexpected error");
		}
	}

	public void setFilter(Expression<ExtendedWorkField> leftFilter) {
		switch(leftFilter.getType()){
		case SIMPLE:
			
		}
	}
}
