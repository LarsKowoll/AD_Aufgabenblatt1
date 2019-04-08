package aufgabeA;
import core.*;

/**
 * Beschreibt eine Menge als Array
 * @author Philip Zirfaß, Lars Kowoll
 *
 */
public class SETArray implements SET {
	
	private ELEM[] set;
	private int _numberOfElements;
	private int _lengthArray;
	private int _counterPos;
	private int _counterKey;
	
	public SETArray() {
		_lengthArray = 10;
		_numberOfElements = 0;
		set = new ELEM[_lengthArray];
		_counterPos = 0;	
		_counterKey = 0;
	}

	@Override
	public POSArray add(ELEM elem) {
		assert elem != null;
		
		for (ELEM e: set) { // Es wird geprüft ob Element schon im Array vorhanden ist
			if(elem.equals(e)) {
				return ((POSArray) find(elem.getKey())).getPOSArray();
			}
		}
		
		_numberOfElements++;
		
		if (_numberOfElements >= _lengthArray) { //Es wird ein neues Array erzeugt, wenn die Kapazität erreicht wurde
			ELEM[]tempSet = new ELEM[_lengthArray * 2];
			_lengthArray = _lengthArray * 2;
			
			for(int i = 0; i < _numberOfElements; i++) {
				tempSet[i] = set[i];
			}
			tempSet[_numberOfElements] = elem;
			set = tempSet;			
		} else {
			set[_numberOfElements] = elem;
		}
		
		POSArray POSArray = new POSArray(_numberOfElements); // Die entsprechene POS Klasse wird erzeugt
		return POSArray;
	}

	@Override
	public int delete(POS pos) {
		assert pos != null;
        assert _numberOfElements >=0;
        
        POSArray posit = (POSArray) pos;
        if(_numberOfElements > 0) {
            for (int i = posit.getPOS(); i <= _numberOfElements -1; i++)
            {
                if (i >= posit.getPOS())  {
                    set[i] = set[i + 1];
                }
                _counterPos++;
            }
            set[_numberOfElements] = null;
            _numberOfElements--;
        }
        int tempcounterPos = _counterPos;
        _counterPos = 0;
        return tempcounterPos;
		
	}

	@Override
	public int delete(KEY key) {
		int counter = 0;
		assert key != null;
		assert _numberOfElements >=0;
		
		counter = delete(find(key));
		int tempCounterKey = _counterKey;
		_counterKey = 0;
		return counter + tempCounterKey;
	}

	@Override
	public POS find(KEY key) {
		assert key != null;
		
		ELEM element = new ELEM(key);
        POSArray POSition = new POSArray(0);
        set[0] = element;
        
        for(int i=_numberOfElements; i>0; i--)
        {
            if(set[i].equals(set[0]))
            { 
                POSition.newPosition(i);
                _counterKey++;
                return POSition;
            } 
            _counterKey++;
        }
        return POSition;
	}

	@Override
	public ELEM retrieve(POS pos) {
		assert pos != null;
        assert pos.isValid() == true;
        
        POSArray position = (POSArray) pos;
        return set[position.getPOS()];
	}

	@Override
	public void showall() {
		for(ELEM elem : set) {
            System.out.println(elem);
        } 	
	}

	@Override
	public int size() {
		return _numberOfElements;
	}

	@Override
	public SET unify(SET s, SET t) {
		assert s!= null;
        assert t!= null;
                
        int sizeS = s.size();
        int sizeT = t.size();
        
        SETArray sSetArray = (SETArray) s;
        SETArray tSetArray = (SETArray) t;
        
        if (sizeS > sizeT) {
        	for(int i = 1; i<=sizeT; i++)
            {
        		sSetArray.add(tSetArray.getElem(i));
            }
        	return sSetArray;
        } else {       
		        for(int i=1; i<=sizeS; i++)
		        {
		        	tSetArray.add(sSetArray.getElem(i));
		        }
	        return tSetArray;
        }
	}
	
	private ELEM getElem(int index)
    {
        return set[index];
    }

}
