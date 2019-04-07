package core;

/**
 * Beschreibt die abstrakten Methoden einer Menge
 * @author Philip Zirfa�, Lars Kowoll
 *
 */
public interface SET {
	/**
	 * F�gt ein neues Element der Menge hinzu
	 * @param elem
	 * @return Die Position, an der das Element eingef�gt wurde 
	 */
	POS add(ELEM elem);
	
	/**
	 * L�scht ein Element an einer bestimmten Position
	 * @param pos Position	
	 */
	void delete(POS pos);
	
	/**
	 * L�scht ein Element das mit dem Schl�ssel verbunden ist
	 * @param key Schl�ssel
	 */
	void delete(KEY key);
	
	/**
	 * Sucht mit Hilfe des Schl�ssels die Position
	 * @param key
	 * @return Position des Schl�ssels
	 */
	POS find(KEY key);
	
	/**
	 * Gibt das Element an der �bergebenen Position zur�ck
	 * @param pos 
	 * @return Element
	 */
	ELEM retrieve(POS pos);
	
	/**
	 * Gibt alle Elemente der Menge auf der Konsole aus
	 */
	void showall();
	
	/**
	 * Gibt die M�chtigkeit einer Menge wieder
	 * @return int
	 */
	int size();
	
	/**
	 * Vereinigt zwei Mengen
	 * @param s Erste Menge
	 * @param t Zweite Menge
	 * @return Vereinigte Menge
	 */
	SET unify(SET s, SET t);

}
