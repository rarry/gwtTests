package pl.macjankowski.get.client.filter2;

/**
 * @author Maciej Jankowski <maciej.jankowski@perfectsource.pl>
 * 
 */
public class FilterState {

	private int fieldListBoxIndex;
	private int opListBoxIndex;
	private String value;

	// public FilterState(int fieldListBoxIndex, int opListBoxIndex, String
	// value) {
	// super();
	// this.fieldListBoxIndex = fieldListBoxIndex;
	// this.opListBoxIndex = opListBoxIndex;
	// this.value = value;
	// }

	private FilterState() {
	}

	public static class Builder {
		private FilterState state = new FilterState();

		public Builder setFieldListBoxIndex(int fieldListBoxIndex) {
			state.fieldListBoxIndex = fieldListBoxIndex;
			return this;
		}

		public Builder setValue(String value) {
			state.value = value;
			return this;
		}

		public Builder setOpListBoxIndex(int opListBoxIndex) {
			state.opListBoxIndex = opListBoxIndex;
			return this;
		}

		public FilterState build() {
			return state;
		}
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
