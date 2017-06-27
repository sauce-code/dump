package de.hska.info1.backtracking;

/**
 * Gibt für verschiedene NxN Schachbrettern eine Lösung
 * des N-Damen-Problems aus.
 * 
 * @author pape
 */
public class NDamenProblemMain {

	public static void main(String[] args) {
		for (int n = 6; n < 20; n++) {
			NDamenProblem problem = new NDamenProblem(n);
			NDamenProblemView view = new NDamenProblemView(problem);
			if (problem.sucheLoesung(0)) {
				System.out.println("Lösung gefunden");
			} else {
				System.out.println("Kein Lösung gefunden");
			}
			view.ausgeben();
		}
	}

}
