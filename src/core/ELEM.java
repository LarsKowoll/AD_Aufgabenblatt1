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
	
	@Override
    public boolean equals(Object obj) {
       if(obj instanceof ELEM) {
           ELEM other = (ELEM)obj;
           return other.getKey().equals(_key);
       }
       return false;
    }
    
    @Override
    public int hashCode()  {
        return _key.hashCode();
    }

}
