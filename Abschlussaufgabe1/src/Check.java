/**
 * Klasse zum Ueberpruefen von Eingabebefehlen auf deren korrekte Schreibung.
 * @author Torben Christopher Kr&uuml;ger
 *
 */
public class Check {
	
	
	/**
	 * Ueberprueft, ob der gegebene String eine vorhandene Referenz darstellt.
	 * @param param zu ueberpruefender String
	 * @return Ergebnis der Ueberpruefung
	 */
	private static boolean isCorrectRef(String param) {
		char[] c = param.toCharArray();
		boolean ret = true;
		if (c.length >= 2 && c[0] == '#') {
			for (int i = 1; i < c.length; i++) {
				if (!isADigit(c[i])) {
					ret = false;
				}
			}
			if (ret != false) {
				String substring = param.substring(1);
				int refNumber =  Integer.parseInt(substring);
				if(Formulas.formulaList.size() <= refNumber) {
					ret = false;
				}
			}
		} else {
			ret = false;
		}
		return ret;
	}

	
	/**
	 * Ueberprueft, ob der gegebene String eine Variable darstellt.
	 * @param param zu ueberpruefender String
	 * @return Ergebnis der Ueberpruefung
	 */
	private static boolean isCorrectVar(String param) {
		char[] c = param.toCharArray();
		boolean ret = true;
		if (c.length >= 2 && c[0] == 'v') {
			for (int i = 1; i < c.length; i++) {
				if (!isADigit(c[i])) {
					ret = false;
				}
			}
		} else {
			ret = false;
		}
		return ret;
	}
	
	
	/**
	 * Ueberprueft, ob der gegebene Char eine Ziffer darstellt.
	 * @param c zu ueberpruefender Char
	 * @return Ergebnis der Ueberpruefung
	 */
	private static boolean isADigit(char c) {
		boolean ret;
		if (c == '0' | c == '1' | c == '2' | c == '3' | c == '4' |
			c == '5' | c == '6' | c == '7' | c == '8' | c == '9' ) {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	
	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten not-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean not(String[] command) {
		boolean ret = false;
		if (command.length == 2) {
			if (isCorrectVar(command[1]) || isCorrectRef(command[1])
			  || command[1].equals("true") || command[1].equals("false")) {
				ret = true;
			}
		}
		return ret;
	}


	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten or-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean or(String[] command) {
		boolean ret = false;
		if (command.length == 3) {
			if ((isCorrectVar(command[1]) || isCorrectRef(command[1])
			  || command[1].equals("true") || command[1].equals("false"))
			  && (isCorrectVar(command[2]) || isCorrectRef(command[2])
		      || command[2].equals("true") || command[2].equals("false"))) {
				ret = true;
			}
		}
		return ret;
	}
	
	
	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten and-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean and(String[] command) {
		boolean ret = false;
		if (command.length == 3) {
			if ((isCorrectVar(command[1]) || isCorrectRef(command[1])
			  || command[1].equals("true") || command[1].equals("false"))
			  && (isCorrectVar(command[2]) || isCorrectRef(command[2])
			  || command[2].equals("true") || command[2].equals("false"))) {
				ret = true;
			}
		}
		return ret;
	}
	
	
	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten show-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean show(String[] command) {
		boolean ret = false;
		if (command.length == 2) {
			if (isCorrectRef(command[1])) {
				ret = true;
			}
		}
		return ret;
	}
	
	
	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten list-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean list(String[] command) {
		boolean ret = false;
		if (command.length == 1) {
			ret = true;
		}
		return ret;
	}
	
	
	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten subst-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean subst(String[] command) {
		boolean ret = false;
		if (command.length == 4) {
			if (isCorrectRef(command[1]) && isCorrectVar(command[2])
			  && ((isCorrectVar(command[3]) || isCorrectRef(command[3])
			  || command[3].equals("true") || command[3].equals("false")))) {
				ret = true;
			}
		}
		return ret;
	}
	
	
	/**
	 * Ueberprueft, das gegebene String-Array einen korrekten simplify-Eingabebefehl darstellt.
	 * @param command zu ueberpruefendes String-Array
	 * @return Ergebnis der Ueberpruefung
	 */
	public static boolean simplify(String[] command) {
		boolean ret = false;
		if (command.length == 2) {
			if (isCorrectRef(command[1])) {
				ret = true;
			}
		}
		return ret;
	}
	
	
}