package aufgabeB;

import aufgabeA.POSArray;
import aufgabeC.Container;
import core.ELEM;
import core.KEY;
import core.POS;
import core.SET;

public class POSArrayContainer implements POS{
	
	  private int position;
	    private POSArrayContainer positionArrayContainer;
	    private boolean valide;

	    public POSArrayContainer(int p) {
	    	positionArrayContainer = this;
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
	    public POSArrayContainer getPOSArrayContainer() {
	        return positionArrayContainer;
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