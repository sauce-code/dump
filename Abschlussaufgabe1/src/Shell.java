import ipd.Terminal;


/**
 * Benutzerschnittstelle fuer das Programm "Boolesche Formeln".
 * @author Torben Christopher Kr&uuml;ger
 *
 */
public class Shell {

	
	/**
	 * Speichervariable fuer durch den Benutzer eingegebene Kommandos.
	 */
	private static String[] input;
	
	
	/**
	 * Standardausgabefehler fuer inkorrekte Befehle.
	 */
	private static String OUTPUT_ERROR = "Ungueltige Eingabe";
	
	
	/**
	 * Frägt in einer Schleife Kommandos durch den Benutzer ab, bis die Eingabe "quit" erfolgt.
	 * @param args args
	 */
	public static void main(String[] args) {
		
		do {
			input = Terminal.ask("bool> ").split("\\s+");

			if (input[0].equals("not")) {
				
				
				if (Check.not(input)) {
					System.out.println(Formulas.not(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (input[0].equals("and")) {
				if (Check.and(input)) {
					System.out.println(Formulas.and(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (input[0].equals("or")) {
				if (Check.or(input)) {
					System.out.println(Formulas.or(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (input[0].equals("show")) {
				if (Check.show(input)) {
					System.out.println(Formulas.show(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (input[0].equals("list")) {
				if (Check.list(input)) {
					System.out.println(Formulas.list(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (input[0].equals("simplify")) {
				if (Check.simplify(input)) {
					System.out.println(Formulas.simplify(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (input[0].equals("subst")) {
				if (Check.subst(input)) {
					System.out.println(Formulas.subst(input));
				} else {
					System.out.println(OUTPUT_ERROR);
				}
				
				
			} else if (!input[0].equals("quit")) {
				System.out.println(OUTPUT_ERROR);
			}
			
			
		} while (!input[0].equals("quit"));
	}

}