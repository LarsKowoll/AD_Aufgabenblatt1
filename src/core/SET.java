package core;

/**
 * Beschreibt die abstrakten Methoden einer Menge
 * @author Philip Zirfaß, Lars Kowoll
 *
 */
public interface SET {
	/**
	 * Fügt ein neues Element der Menge hinzu
	 * @param elem
	 * @return Die Position, an der das Element eingefügt wurde 
	 */
	POS add(ELEM elem);
	
	/**
	 * Löscht ein Element an einer bestimmten Position
	 * @param pos Position	
	 */
	void delete(POS pos);
	
	/**
	 * Löscht ein Element das mit dem Schlüssel verbunden ist
	 * @param key Schlüssel
	 */
	void delete(KEY key);
	
	/**
	 * Sucht mit Hilfe des Schlüssels die Position
	 * @param key
	 * @return Position des Schlüssels
	 */
	POS find(KEY key);
	
	/**
	 * Gibt das Element an der übergebenen Position zurück
	 * @param pos 
	 * @return Element
	 */
	ELEM retrieve(POS pos);
	
	/**
	 * Gibt alle Elemente der Menge auf der Konsole aus
	 */
	void showall();
	
	/**
	 * Gibt die Mächtigkeit einer Menge wieder
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
