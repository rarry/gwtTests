package pl.macjankowski.get.client.filter2;

import pl.macjankowski.get.client.filter2.ComplexFilterPanel.ComplexFilterPanelActions2;
import pl.macjankowski.get.client.filter2.SimpleFilterPanel.SingleFilterPanel2Actions;

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

	public SwapPanel(int depth) {
		this.depth = depth;
		simplePanel = new SimpleFilterPanel(this);
		add(simplePanel);
	}

	public SwapPanel(FilterState simplePanelState, int depth) {
		this.depth = depth;
		if (simplePanelState != null) {
			simplePanel = new SimpleFilterPanel(this, simplePanelState);
		}
		add(simplePanel);
	}

	private ComplexFilterPanel getComplexPanel(FilterState simplePanelState) {
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
	public void onExpand(FilterState state) {
		if (depth < MAX_DEPTH) {
			simplePanel.setVisible(false);
			getComplexPanel(state).setVisible(true);
		}
	}

	@Override
	public void onCollapse() {
		if (depth < MAX_DEPTH) {
			simplePanel.setVisible(true);
			this.complexPanel.setVisible(false);
		}
	}
}
