package aufgabeC;

import core.ELEM;

public class Container {
	
    private ELEM   _elem;
    private Container _nextContainer;

    
    Container(ELEM e, Container nextContainer) {
    	_elem = e;
        _nextContainer = nextContainer;
    }

    ELEM getElement() {
        return _elem;
    }

    void setElement(ELEM elem) {
    	_elem = elem;
    }
    
    Container getNextContainer() {
        return _nextContainer;
    }

    void setNextContainer(Container nextContainer) {
        _nextContainer = nextContainer;
    }

    int getSize()  {
        if (_elem == null) {
            return 0;
        } else {
            return 1 + _nextContainer.getSize();
        }
    }

}
