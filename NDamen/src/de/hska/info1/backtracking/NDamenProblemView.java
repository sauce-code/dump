package de.hska.info1.backtracking;

/**
 * NDamenProblemView ist verantwortlich für die
 * Ausgabe des Schachbretts für ein NDamenProblem 
 * auf der Konsole.
 * 
 * @author pape
 */
public class NDamenProblemView {

	private NDamenProblem problem;
	
	public NDamenProblemView(NDamenProblem problem) {
		this.problem = problem;
	}
	
	public void ausgeben() {
		for (int zeile = 0; zeile < problem.getBreite(); zeile++) {
			for (int spalte = 0; spalte < problem.getBreite(); spalte++) {
				if (problem.enthaeltDame(zeile, spalte)) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
