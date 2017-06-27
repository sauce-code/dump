package compiler.tokenbuilder;

import compiler.utility.Token;

public class TokenBuilder {

	protected char[] buffer;

	protected int currChar;

	protected int line;

	protected int column;

	public TokenBuilder(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public void put(char c) {
		
	}
	
	public Token build() {
		return null;
	}

}
