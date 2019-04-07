package core;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;


import aufgabeA.SETArray;
import aufgabeB.SETArrayContainer;
import aufgabeC.SETContainer;

public class Verifikationstests
{
    private SET _testSET;
	
	private SET getSetImplementation(){
	    return new SETContainer();
	}
	
    public Verifikationstests() {
        _testSET = getSetImplementation();

    }

    @Test
    public void testAdd()  {
        ELEM e1 = new ELEM(KEY.newKey());
        ELEM e2 = new ELEM(KEY.newKey());

        assertEquals(0, _testSET.size());

        POS p1 = _testSET.add(e1);
        
        assertEquals(1, _testSET.size());
        
        _testSET.add(e1);
        assertEquals(1, _testSET.size());
        POS p2 = _testSET.add(e2);

        assertTrue(p2.isValid());
    }
    
    @Test
    public void testAddviele()  {
        Set<KEY> pruefSetKey = new HashSet<KEY>();
        Set<ELEM> pruefSetElem = new HashSet<ELEM>();
        
        KEY tmpKey = null;
        ELEM tmpElem = null;
        
        for(int i = 1; i < 1001; i++) {
            tmpKey = KEY.newKey();
            tmpElem = new ELEM(tmpKey);
            
            pruefSetKey.add(tmpKey);
            pruefSetElem.add(tmpElem);
            
            _testSET.add(tmpElem);
            
            assertEquals(i, _testSET.size());
        }
        
        for(KEY k : pruefSetKey)  {   
            assertTrue(_testSET.find(k).isValid());
        }       
        for(ELEM e : pruefSetElem) {
            assertTrue(_testSET.retrieve(_testSET.find(e.getKey())).equals(e));            
        }
     
        
    }
    

    @Test
    public void testDeletePOS() {
        KEY k1 = KEY.newKey();
        KEY k2 = KEY.newKey();

        ELEM e1 = new ELEM(k1);
        ELEM e2 = new ELEM(k2);
        POS p1 = _testSET.add(e1);
        POS p2 = _testSET.add(e2);

        assertEquals(2, _testSET.size());

        _testSET.delete(p1);
        assertEquals(1, _testSET.size());
        
        p2 = _testSET.find(k2);

        _testSET.delete(p2);

        assertEquals(0, _testSET.size());
        
        _testSET.delete(p2);

        assertEquals(0, _testSET.size());
    }

    @Test
    public void testDeleteKEY()  {
        KEY k1 = KEY.newKey();
        KEY k2 = KEY.newKey();
        ELEM e1 = new ELEM(k1);
        ELEM e2 = new ELEM(k2);
        _testSET.add(e1);
        _testSET.add(e2);

        _testSET.delete(k1);
        _testSET.delete(k2);

        assertEquals(0, _testSET.size());
        
        _testSET.delete(k1);
        assertEquals(0, _testSET.size());
    }
    
    @Test
    public void testDeleteChaos() {
        KEY k1 = KEY.newKey();
        KEY k2 = KEY.newKey();
        KEY k3 = KEY.newKey();
        ELEM e1 = new ELEM(k1);
        _testSET.add(e1);
        
        for(int i = 0; i<30; i++) {
            _testSET.add(new ELEM(KEY.newKey()));
        }
        
        
        ELEM e2 = new ELEM(k2);
       
        _testSET.add(e2);
        
        for(int i = 0; i<30; i++) {
            _testSET.add(new ELEM(KEY.newKey()));
        }
        
        ELEM e3 = new ELEM(k3);
        
        _testSET.add(e3);

        _testSET.delete(k1);
        assertFalse(_testSET.find(k1).isValid());
        
        _testSET.delete(k3);
        assertFalse(_testSET.find(k3).isValid());
        
        _testSET.delete(k2);
        assertFalse(_testSET.find(k2).isValid());
    }
    
    @Test
    public void testDeleteViele() {
      //viele Hinzf�gen
        Set<KEY> pruefSetKey = new HashSet<KEY>();
    
        
        KEY tmpKey = null;
        ELEM tmpElem = null;
        
        for(int i = 1; i < 1001; i++) {
            tmpKey = KEY.newKey();
            tmpElem = new ELEM(tmpKey);
            
            pruefSetKey.add(tmpKey);
            _testSET.add(tmpElem);           
        }
   
        for(KEY k : pruefSetKey) {
           _testSET.delete(k); 
        }
        
        for(KEY k : pruefSetKey)  {
           assertFalse(_testSET.find(k).isValid()); 
        }      
    }

    @Test
    public void testFind() {

        KEY k1 = KEY.newKey();
        KEY k2 = KEY.newKey();
        KEY k3 = KEY.newKey();
        KEY k4 = KEY.newKey();
        KEY k5 = KEY.newKey();

        ELEM e1 = new ELEM(k1);
        ELEM e2 = new ELEM(k2);
        ELEM e3 = new ELEM(k3);
        ELEM e4 = new ELEM(k4);
        ELEM e5 = new ELEM(k5);

        POS p1 = _testSET.add(e1);
        POS p2 = _testSET.add(e2);
        POS p3 = _testSET.add(e3);

        POS p5 = _testSET.add(e5);
        

        _testSET.delete(k3);
        assertFalse(_testSET.find(k3).isValid()); 
        

        POS posret2 = _testSET.find(k2);
        
        assertTrue(posret2.isValid());

        ELEM elemRet2 = _testSET.retrieve(posret2);

        assertEquals(elemRet2, e2);

        POS posret4 = _testSET.find(k4);
        assertFalse(posret4.isValid());
    }

    @Test
    public void testRetrieve() {
        KEY k1 = KEY.newKey();
        KEY k2 = KEY.newKey();
        ELEM e1 = new ELEM(k1);
        ELEM e2 = new ELEM(k2);
        POS p1 = _testSET.add(e1);
        POS p2 = _testSET.add(e2);

        assertEquals(e1, _testSET.retrieve(p1));
        assertEquals(e2, _testSET.retrieve(p2));

    }

    @Test
    public void testSize()  {
        List<KEY> posses = new LinkedList<KEY>();

        assertEquals(0, _testSET.size());

        KEY tmpK = null;
        for (int i = 1; i <= 300; i++) {
            tmpK = KEY.newKey();
            posses.add(tmpK);
            _testSET.add(new ELEM(tmpK));
            assertEquals(i, _testSET.size());
        }

        for (int i = 300; i > 0; i--)  {
            assertEquals(i, _testSET.size());

            _testSET.delete(posses.remove(0));

        }

        assertEquals(0, _testSET.size());

    }

    @Test
    public void testUnify() {
        SET set1 = getSetImplementation();
        SET set2 = getSetImplementation();

        Set<KEY> pruefSet = new HashSet<KEY>();

        KEY tmpK1 = null;
        KEY tmpK2 = null;

        for (int i = 0; i < 30; i++) {
            tmpK1 = KEY.newKey();
            tmpK2 = KEY.newKey();

            set1.add(new ELEM(tmpK1));
            set2.add(new ELEM(tmpK2));

            pruefSet.add(tmpK1);
            pruefSet.add(tmpK2);
        }        
        KEY doppelKey = KEY.newKey();
        
        set1.add(new ELEM(doppelKey));
        set2.add(new ELEM(doppelKey));

        SET uniSet = set1.unify(set1, set2);

        for (KEY k : pruefSet)   {
            assertTrue(uniSet.find(k).isValid());
        }     
        assertEquals(61, uniSet.size());
    }
}
