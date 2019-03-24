package aufgabeA;
import core.*;

public class SETArray implements SET {
	
	private ELEM[] set;
	private int _numberOfElements;
	private int _lengthArray;
	
	public SETArray() {
		_lengthArray = 10;
		_numberOfElements = 0;
		set = new ELEM[_lengthArray];
	}

	@Override
	public POSArray add(ELEM elem) {
		assert elem != null; //Bedingung
		
		for (ELEM e: set) {
			if(elem.equals(e)) {
				return ((POSArray) find(elem.getKey())).getPOSArray();
			}
		}
		
		_numberOfElements++;
		
		if (_numberOfElements >= _lengthArray) {
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
		
		POSArray POSArray = new POSArray(_numberOfElements);
		return POSArray;
	}

	@Override
	public void delete(POS pos) {
		assert pos != null;
        assert _numberOfElements >=0;
        
        POSArray posit = (POSArray) pos;
        if(_numberOfElements > 0)
        {
            for (int i = posit.getPOS(); i <= _numberOfElements -1; i++)
            {
                if (i >= posit.getPOS())
                {
                    set[i] = set[i + 1];
                }
            }
            set[_numberOfElements] = null;
            _numberOfElements--;
        }
		
	}

	@Override
	public void delete(KEY key) {
		assert key != null;
		assert _numberOfElements >=0;
		
		delete(find(key));	
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
                return POSition;
            }                
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
		// TODO Auto-generated method stub
		return null;
	}

}
