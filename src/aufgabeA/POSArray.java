package aufgabeA;
import core.POS;

/**
 * Implementation POS 
 * @author Philip Zirfaß, Lars Kowoll
 *
 */
public class POSArray implements POS {

    private int position;
    private POSArray positionArray;
    private boolean valide;
    
    /**
     * Kontruktor für POSArray. Prüft ob die angegebene Position valide ist
     * @param Position
     */
    public POSArray(int p) {
        positionArray = this;
        position = p;
        
        if(p <= 0) {
            valide = false;
        } else {
            valide = true;
        }          
    }
    
   /**
    * Gibt die eigene Klasse zurück
    * @return POSArray
    */
    public POSArray getPOSArray() {
        return positionArray;
    }
    
    /**
     * Gibt die Position des Elements zurück
     * @return int
     */
    public int getPOS() {
        return position;
    }
    
    /**
     * Legt eine neue Position fest
     * @param newPosition
     */
    public void newPosition(int newPosition) {        
        position = newPosition;
        if(newPosition <= 0) {
            valide = false;
        } else {
            valide = true;
        }          
    }

    @Override
    public boolean isValid() {
        return valide;
    }

}
