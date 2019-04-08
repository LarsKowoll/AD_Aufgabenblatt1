package core;

/**
 * Die Klasse beschreibt ein Element. Jedes Element h�lt eine Schl�ssel-Klasse.
 * @author Philip Zirfa�, Lars Kowoll
 *
 */
public class ELEM {
	private KEY _key;
	
	public ELEM(KEY key) {
		this._key = key;
	}
	
/**
 * Getter-Methode um an den Schl�ssel des Elements zugekommen
 * @return Schl�ssel
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
