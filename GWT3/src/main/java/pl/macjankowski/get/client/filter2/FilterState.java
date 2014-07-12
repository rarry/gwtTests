package pl.macjankowski.get.client.filter2;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 * 
 */
public class FilterState {

	private int fieldListBoxIndex;
	private int opListBoxIndex;
	private String value;

	public FilterState(int fieldListBoxIndex, int opListBoxIndex, String value) {
		super();
		this.fieldListBoxIndex = fieldListBoxIndex;
		this.opListBoxIndex = opListBoxIndex;
		this.value = value;
	}

	public int getFieldListBoxIndex() {
		return fieldListBoxIndex;
	}

	public int getOpListBoxIndex() {
		return opListBoxIndex;
	}

	public String getValue() {
		return value;
	}

}
