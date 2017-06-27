package de.hska.info1.backtracking;

/**
 * NDamenProblem ist verantwortlich für das Lösen
 * des N-Damen-Problems. Beim N-Damen-Problem sollen
 * N Damen so auf ein NxN Schachbrett positioniert werden,
 * dass keine Dame die anderen schlagen kann.
 * 
 * @author pape
 *
 */
public class NDamenProblem {

	private int [] dameInSpalte;
	
	private boolean [] spalteBelegt;
	
	private boolean [] nebenDiagonale;
	
	private boolean [] hauptDiagonale;
	
	/**
	 * Erzeugt ein neues NDamenProblem mit leerem Schachbrett
	 * und ohne eine Lösung.
	 * @param n  n > 0, sollte mindestens 5 sein
	 */
	public NDamenProblem(int n) {
		this.dameInSpalte = new int[n];
		for (int i = 0; i < dameInSpalte.length; i++) {
			this.dameInSpalte[i] = -1;
		}
		this.spalteBelegt = new boolean[n];
		this.nebenDiagonale = new boolean[2 * n - 1];
		this.hauptDiagonale = new boolean[2 * n - 1];
	}
	
	private boolean zugIstGueltig(int zeile, int spalte) {
		return dameInSpalte[zeile] == -1
			&& ! spalteBelegt[spalte]
			&& ! nebenDiagonale[zeile + spalte]
			&& ! hauptDiagonale[zeile - spalte + dameInSpalte.length - 1];
	}
	
	/**
	 * Gibt genau dann true zurück, wenn für dieses NDamenProblem
	 * in allen Zeilen ab <code>zeile</code> einschließlich jeweils
	 * eine Dame positioniert werden kann, so daß keine Dame eine
	 * andere schlägt. Die Methode sollte mit zeile = 0 aufgerufen
	 * werden.
	 * 
	 * @param zeile 0 <= zeile < getBreite()
	 */
	public boolean sucheLoesung(int zeile) {
		for (int spalte = 0; spalte < dameInSpalte.length; spalte++) {
			if (zugIstGueltig(zeile, spalte)) {
				dameInSpalte[zeile] = spalte;
				spalteBelegt[spalte] = true;
				nebenDiagonale[zeile + spalte] = true;
				hauptDiagonale[zeile - spalte + dameInSpalte.length - 1] = true;
				if (zeile < dameInSpalte.length - 1) {
					if (sucheLoesung(zeile + 1)) {
						return true;
					} else {
						dameInSpalte[zeile] = -1;
						spalteBelegt[spalte] = false;
						nebenDiagonale[zeile + spalte] = false;
						hauptDiagonale[zeile - spalte + dameInSpalte.length - 1] = false;						
					}
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Gibt die Breite des quadratischen Schachbretts zurück.
	 */
	public int getBreite() {
		return dameInSpalte.length;
	}

	/**
	 * Gibt genau dann true zurück, wenn sich auf dem Schachbrett in Zeile
	 * <code>zeile</code> und Spalte <code>spalte</code>
	 * eine Dame befindet.
	 * @param zeile 0 <= zeile < getBreite()
	 * @param spalte 0 <= spalte < getBreite()
	 */
	public boolean enthaeltDame(int zeile, int spalte) {
		return dameInSpalte[zeile] == spalte;
	}
}
