import java.util.ArrayList;
import java.util.List;


/**
 * Klasse zum erstellen, speichern und bearbeiten von Booleschen Formeln.
 * @author Torben Christopher Kr&uuml;ger
 *
 */
public class Formulas {
	
	
	/**
	 * Speichervariable fuer alle Booleschen Formeln, die während dem Programmablauf erstellt werden.
	 */
	public static List<List<String>> formulaList = new ArrayList<List<String>>();
	
	
	/**
	 * Gibt einen String fuer eine beliebige Formel aus.
	 * @param refNumber Nummer der Formel, fuer die der String erstellt werden soll
	 * @return geforderter String
	 */
	private static String formulaToString(int refNumber) {
		String ret = "#" + refNumber + " =";
		List<String> formula = formulaList.get(refNumber);
		for (int i = 0; i < formula.size(); i++) {
			ret += " " + formula.get(i);
		}
		return ret;
	}
	
	
	/**
	 * Befehl zum Erstellen einer neuen Booleschen Formel mittels Negation.
	 * Die neu errechnete Formel wird in der formulaList gespeichert.
	 * Desweiteren gibt die Methode dieselbe Formel in Form eines String zurück,
	 * damit diese fuer den Benutzer ausgegeben werden kann.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String not(String[] command) {
		List<String> newFormula = new ArrayList<String>();
		newFormula.add("(");
		newFormula.add(command[0]);
		char[] c = command[1].toCharArray();
		if (c[0] == '#') {
			String substring = command[1].substring(1);
			int refNumber =  Integer.parseInt(substring);
			List<String> oldFormula = formulaList.get(refNumber);
			for (int i = 0; i < oldFormula.size(); i++) {
				newFormula.add(oldFormula.get(i));
			}
		} else {
			newFormula.add(command[1]);
		}
		newFormula.add(")");
		formulaList.add(newFormula);
		return formulaToString(formulaList.size() - 1);
	}
	
	
	/**
	 * Befehl zum Erstellen einer neuen Booleschen Formel mittels Disjunktion.
	 * Die neu errechnete Formel wird in der formulaList gespeichert.
	 * Desweiteren gibt die Methode dieselbe Formel in Form eines String zurück,
	 * damit diese fuer den Benutzer ausgegeben werden kann.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String or(String[] command) {
		List<String> newFormula = new ArrayList<String>();
		newFormula.add("(");
		char[] c = command[1].toCharArray();
		if (c[0] == '#') {
			String substring = command[1].substring(1);
			int refNumber =  Integer.parseInt(substring);
			List<String> oldFormula = formulaList.get(refNumber);
			for (int i = 0; i < oldFormula.size(); i++) {
				newFormula.add(oldFormula.get(i));
			}
		} else {
			newFormula.add(command[1]);
		}
		newFormula.add("or");
		c = command[2].toCharArray();
		if (c[0] == '#') {
			String substring = command[2].substring(1);
			int refNumber =  Integer.parseInt(substring);
			List<String> oldFormula = formulaList.get(refNumber);
			for (int i = 0; i < oldFormula.size(); i++) {
				newFormula.add(oldFormula.get(i));
			}
		} else {
			newFormula.add(command[2]);
		}
		newFormula.add(")");
		formulaList.add(newFormula);
		return formulaToString(formulaList.size() - 1);
	}
	
	
	/**
	 * Befehl zum Erstellen einer neuen Booleschen Formel mittels Konjunktion.
	 * Die neu errechnete Formel wird in der formulaList gespeichert.
	 * Desweiteren gibt die Methode dieselbe Formel in Form eines String zurück,
	 * damit diese fuer den Benutzer ausgegeben werden kann.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String and(String[] command) {
		List<String> newFormula = new ArrayList<String>();
		newFormula.add("(");
		char[] c = command[1].toCharArray();
		if (c[0] == '#') {
			String substring = command[1].substring(1);
			int refNumber =  Integer.parseInt(substring);
			List<String> oldFormula = formulaList.get(refNumber);
			for (int i = 0; i < oldFormula.size(); i++) {
				newFormula.add(oldFormula.get(i));
			}
		} else {
			newFormula.add(command[1]);
		}
		newFormula.add("and");
		c = command[2].toCharArray();
		if (c[0] == '#') {
			String substring = command[2].substring(1);
			int refNumber =  Integer.parseInt(substring);
			List<String> oldFormula = formulaList.get(refNumber);
			for (int i = 0; i < oldFormula.size(); i++) {
				newFormula.add(oldFormula.get(i));
			}
		} else {
			newFormula.add(command[2]);
		}
		newFormula.add(")");
		formulaList.add(newFormula);
		return formulaToString(formulaList.size() - 1);
	}
	
	
	/**
	 * Befehl zum Ausgeben einer gewünschten Booleschen Formel.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String show(String[] command) {
		String substring = command[1].substring(1);
		int refNumber =  Integer.parseInt(substring);
		return formulaToString(refNumber);
	}
	
	
	/**
	 * Befehl zum Ausgeben aller bisher erstellten Booleschen Formeln.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String list(String[] command) {
		String ret = "";
		for (int i=0; i < formulaList.size(); i++) {
			ret += formulaToString(i) + "\n";
		}
		ret = ret.substring(0, ret.length() - 1);
		return ret;
	}
	
	
	/**
	 * Befehl zum erstellen einer Booleschen Formel durch Substitution in einer bereits 
	 * vorhandenen Formel.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String subst(String[] command) {
		String substring = command[1].substring(1);
		int refNumber =  Integer.parseInt(substring);
		List<String> newFormula = new ArrayList<String>();
		List<String> oldFormula = formulaList.get(refNumber);
		for (int i = 0; i < oldFormula.size(); i++) {
			if (oldFormula.get(i).equals(command[2])) {
				newFormula.add(command[3]);
			} else {
				newFormula.add(oldFormula.get(i));
			}
		}
		formulaList.add(newFormula);
		return formulaToString(formulaList.size() - 1);
	}
	
	
	/**
	 * Befehl zum Vereinfachen einer gewünschten Booleschen Formel.
	 * @param command Befehlsfolge
	 * @return fertige Formel in Form eines Strings
	 */
	public static String simplify(String[] command) {
		String substring = command[1].substring(1);
		int refNumber =  Integer.parseInt(substring);
		List<String> newFormula = new ArrayList<String>();
		List<String> oldFormula = formulaList.get(refNumber);
		for (int i = 0; i < oldFormula.size(); i++) {
			//Negation1
			if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("not")
					&& oldFormula.get(i + 2).equals("false")
					&& oldFormula.get(i + 3).equals(")")) {
						newFormula.add("true");
						i += 3;
			}
			//Negation2
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("not")
					&& oldFormula.get(i + 2).equals("true")
					&& oldFormula.get(i + 3).equals(")")) {
						newFormula.add("false");
						i += 3;
			}
			//Negation3
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("not")
					&& oldFormula.get(i + 2).equals("(")
					&& oldFormula.get(i + 3).equals("not")
					&& oldFormula.get(i + 5).equals(")")
					&& oldFormula.get(i + 6).equals(")")) {
						newFormula.add(oldFormula.get(i + 4));
						i += 6;
			}
			//Komjunktion1
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("and")
					&& oldFormula.get(i + 3).equals("true")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add(oldFormula.get(i + 1));
						i += 4;
			}
			//Komjunktion2
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("true")
					&& oldFormula.get(i + 2).equals("and")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add(oldFormula.get(i + 3));
						i += 4;
			}
			//Komjunktion3
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("and")
					&& oldFormula.get(i + 3).equals("false")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add("false");
						i += 4;
			}
			//Komjunktion4
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("false")
					&& oldFormula.get(i + 2).equals("and")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add("false");
						i += 4;
			}
			//Komjunktion5
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("and")
					&& oldFormula.get(i + 3).equals("(")
					&& oldFormula.get(i + 4).equals("not")
					&& oldFormula.get(i + 5).equals(oldFormula.get(i + 1))
					&& oldFormula.get(i + 6).equals(")")
					&& oldFormula.get(i + 7).equals(")")) {
						newFormula.add("false");
						i += 7;
			}
			//Komjunktion6
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("(")
					&& oldFormula.get(i + 2).equals("not")
					&& oldFormula.get(i + 4).equals(")")
					&& oldFormula.get(i + 5).equals("and")
					&& oldFormula.get(i + 6).equals(oldFormula.get(i + 3))
					&& oldFormula.get(i + 7).equals(")")) {
						newFormula.add("false");
						i += 7;
			}
			//Komjunktion7
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("and")
					&& oldFormula.get(i + 3).equals(oldFormula.get(i + 1))
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add(oldFormula.get(i + 1));
						i += 4;
			}
			//Disjunktion1
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("or")
					&& oldFormula.get(i + 3).equals("false")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add(oldFormula.get(i + 1));
						i += 4;
			}
			//Disjunktion2
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("false")
					&& oldFormula.get(i + 2).equals("or")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add(oldFormula.get(i + 3));
						i += 4;
			}
			//Disjunktion3
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("or")
					&& oldFormula.get(i + 3).equals("true")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add("true");
						i += 4;
			}
			//Disjunktion4
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("true")
					&& oldFormula.get(i + 2).equals("or")
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add("true");
						i += 4;
			}
			//Disjunktion5
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("or")
					&& oldFormula.get(i + 3).equals("(")
					&& oldFormula.get(i + 4).equals("not")
					&& oldFormula.get(i + 5).equals(oldFormula.get(i + 1))
					&& oldFormula.get(i + 6).equals(")")
					&& oldFormula.get(i + 7).equals(")")) {
						newFormula.add("true");
						i += 7;
			}
			//Disjunktion6
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 1).equals("(")
					&& oldFormula.get(i + 2).equals("not")
					&& oldFormula.get(i + 4).equals(")")
					&& oldFormula.get(i + 5).equals("or")
					&& oldFormula.get(i + 6).equals(oldFormula.get(i + 3))
					&& oldFormula.get(i + 7).equals(")")) {
						newFormula.add("true");
						i += 7;
			}
			//Disjunktion7
			else if (oldFormula.get(i).equals("(")
					&& oldFormula.get(i + 2).equals("or")
					&& oldFormula.get(i + 3).equals(oldFormula.get(i + 1))
					&& oldFormula.get(i + 4).equals(")")) {
						newFormula.add(oldFormula.get(i + 1));
						i += 4;
			}
			//default
			else {
				newFormula.add(formulaList.get(refNumber).get(i));
			}
		}
		formulaList.add(newFormula);
		return formulaToString(formulaList.size() - 1);
	}
	
	
}