package aufgabeB;

import core.ELEM;

public class Container {
	
    private ELEM   _elem;
    
    public Container(ELEM e) {
    	_elem = e;
    }

    public ELEM getElement() {
        return _elem;
    }

    public void setElement(ELEM elem) {
    	_elem = elem;
    }
}
