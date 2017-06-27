package compiler.utility;

public class InformationInt extends Information {

	protected int value;

	public InformationInt(int value) {
		super(TokenType.INTEGER);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
