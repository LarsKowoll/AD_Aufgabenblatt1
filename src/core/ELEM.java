package core;

/**
 * Die Klasse beschreibt ein Element. Jedes Element hält eine Schlüssel-Klasse.
 * @author Philip Zirfaß, Lars Kowoll
 *
 */
public class ELEM {
	private KEY _key;
	
	public ELEM(KEY key) {
		this._key = key;
	}
	
/**
 * Getter-Methode um an den Schlüssel des Elements zugekommen
 * @return Schlüssel
 */
	public KEY getKey() {
		return _key;
	}

}
