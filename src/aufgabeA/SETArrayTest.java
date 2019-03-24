package aufgabeA;

import static org.junit.jupiter.api.Assertions.*;
import core.*;

import org.junit.jupiter.api.Test;

import core.KEY;

class SETArrayTest {
	
	private SETArray _setArrayTest;
	
	public SETArrayTest() {
		_setArrayTest = new SETArray();
	}
	
	@Test
	public void testAdd() {
		ELEM e1 = new ELEM(KEY.newKey());
        ELEM e2 = new ELEM(KEY.newKey());
        ELEM e3 = new ELEM(KEY.newKey());
        ELEM e4 = new ELEM(KEY.newKey());
        
        assertEquals(0, _setArrayTest.size());
        
        POS p1 = _setArrayTest.add(e1);
        
        assertEquals(1, _setArrayTest.size());
        
        _setArrayTest.add(e1);
        
        assertEquals(1, _setArrayTest.size());
        
	}
	
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
