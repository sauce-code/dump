package compiler.utility;

public class InformationLexem extends Information {

	protected String lexem;

	public InformationLexem(String lexem) {
		super(TokenType.IDENTIFIER);
		this.lexem = lexem;
	}

	public InformationLexem(String lexem, TokenType tokenType) {
		super(tokenType);
		this.lexem = lexem;
	}

	public String getLexem() {
		return lexem;
	}

}
