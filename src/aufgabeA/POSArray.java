package aufgabeA;
import core.POS;

public class POSArray implements POS {
	
    private int position;
    private POSArray positionArray;
    private boolean valide;
    
    
    public POSArray(int p) {
        positionArray= this;
        position = p;
        
        if(p <= 0) {
            valide = false;
        } else {
            valide = true;
        }          
    }
    
   
    public POSArray getPOSArray() {
        return positionArray;
    }
    
    public int getPOS() {
        return position;
    }
    
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
