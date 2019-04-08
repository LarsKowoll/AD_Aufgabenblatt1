package core;

import java.util.ArrayList;
import java.util.List;

import aufgabeA.SETArray;
import aufgabeB.SETArrayContainer;
import aufgabeC.SETContainer;

public class QuantitativerTest
{
    private SET _testSet;
    private List<POS> _posList;
    private List<KEY> _keyList;
    
    //mögliche Testfälle für delete 1(POS)/2(KEY)
    //  - 1. best Case: Von hinten löschen
    //  - 2. avarage Case: Mitte löschen
    //  - 3. worst Case: Von Vorne löschen

 
    
    public static void main (String[] args) {
       
        System.out.println("SETArray");
        testeineImpl(new SETArray());
        System.out.println("-------------------");
        
        System.out.println("SETArrayContainer");
        testeineImpl(new SETArrayContainer());
        System.out.println("-------------------");
        
        System.out.println("SETContainer");
        testeineImpl(new SETContainer());
        System.out.println("-------------------");
      
        
    }
    
    public static void testeineImpl(SET setTyp) {
        QuantitativerTest messTest = null;
        //mit Listengröße 10^k k=1...5

        for(int k=1; k <= 5; k++) {
            messTest = new QuantitativerTest((int)Math.pow(10, k), setTyp);
            System.out.println(Math.pow(10, k));
            
           // System.out.println("Test mit Groesse: " + Math.pow(10, k));
            
           System.out.print("Test3: Worst Case");
            testPOSundKEY(messTest, messTest._posList.get(0), messTest._keyList.get(0));
            
            
            System.out.print("Test2: Avg Case");
            testPOSundKEY(messTest, messTest._posList.get((int)Math.pow(10, k) / 2), messTest._keyList.get((int)Math.pow(10, k) / 2));
     
            
            System.out.print("Test1: Best Case");
            testPOSundKEY(messTest, messTest._posList.get((int)Math.pow(10, k) - 1), messTest._keyList.get((int)Math.pow(10, k) - 1));
            
            System.out.println("");
            
            
        }
    }
    
    
    public static void testPOSundKEY(QuantitativerTest messTest, POS pos, KEY key) {
    	int counterPOS = 0;
    	counterPOS =  messTest.test_deletePOS(pos);
        System.out.print(": " + counterPOS + " counterPOS und ");

        int counterKEY = 0;
        counterKEY = messTest.test_delete_KEY(key);
        System.out.println( counterKEY + " counterKEY");    
    }
    
    
    
    public QuantitativerTest(int anz, SET setTyp) {
        fill(anz, setTyp);
    }
    
    
    private void fill(int anz, SET setTyp) {
        KEY tmpKey;
        POS tmpPos;
        ELEM tmpElem;
        
        _testSet = setTyp;
        _posList = new ArrayList<POS>();
        _keyList = new ArrayList<KEY>();
        
        for(int i = 0; i < anz; i++) {
            tmpKey = KEY.newKey();
            tmpElem = new ELEM(tmpKey);
            tmpPos = _testSet.add(tmpElem);
            _posList.add(tmpPos);
            _keyList.add(tmpKey);
            
        }
    }
   
    private int test_deletePOS(POS pos) {
    	int result = 0;
        result = _testSet.delete(pos);
        return result;
    }
    
    private int test_delete_KEY(KEY key) {
    	int result = 0;
        result = _testSet.delete(key);
        return result;
    }
    
 
    
   
    
 
    
    
    
    
    
}
