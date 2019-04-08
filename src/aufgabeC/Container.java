package aufgabeC;

import core.ELEM;

public class Container {
	
    private ELEM   _elem;
    private Container _nextContainer;

    
    public Container(ELEM e, Container nextContainer) {
    	_elem = e;
        _nextContainer = nextContainer;
    }

    public ELEM getElement() {
        return _elem;
    }

    public void setElement(ELEM elem) {
    	_elem = elem;
    }
    
    public Container getNextContainer() {
        return _nextContainer;
    }

    public void setNextContainer(Container nextContainer) {
        _nextContainer = nextContainer;
    }

    public int getSize()  {
        if (_elem == null) {
            return 0;
        } else {
            return 1 + _nextContainer.getSize();
        }
    }

}
