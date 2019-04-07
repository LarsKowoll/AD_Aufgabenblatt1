package core;

/**
 * Die Klasse beschreibt einen Schl�ssel. Jeder Schl�ssel ist eindeutig.
 * @author Philip Zirfa�, Lars Kowoll
 *
 */
public class KEY {
	
	int _value;
	static int counter;
	
	public KEY(int v) {
		this._value = v;
	}
	
	/**
	 * Erstellt einen neuen, einzigartigen Key
	 * @return new Key
	 */
	public static KEY newKey() {
		return new KEY(counter++);
	}

}
