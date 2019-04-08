package aufgabeC;

import core.ELEM;
import core.KEY;
import core.POS;
import core.SET;

public class SETContainer implements SET
{
    Container _head;
    Container _tail;
    public int _counterPos;
	public int _counterKey;

    public SETContainer()
    {
        _tail = new Container(null, null);
        _head = new Container(null, _tail);
        _tail.setNextContainer(_head);
        _counterPos = 0;
        _counterKey = 0;
    }

    @Override
    public POS add(ELEM element)  {
        assert element != null;

        if (find(element.getKey()).isValid()) {
            return new POSContainer(null, this);
        } else {
            Container newCont = new Container(element, _tail);
            Container oldCont = _tail.getNextContainer();
            oldCont.setNextContainer(newCont);
            _tail.setNextContainer(newCont);

            return new POSContainer(oldCont, this);
        }
    }

    @Override
    public int delete(POS position)  {
        assert position != null;
        assert position.isValid();
        
        Container prevCont = ((POSContainer) position).getContainer(); 
        Container afterCont = ((POSContainer) position).getContainer().getNextContainer().getNextContainer(); 

        prevCont.setNextContainer(afterCont); 
        _counterPos++;

        if (afterCont == _tail) {
            _tail.setNextContainer(prevCont);
        }
        int tempCounterPos = _counterPos;
        _counterPos = 0;
        return tempCounterPos;
    }

   @Override
    public int delete(KEY key) {
        assert key != null;
        int counter = 0;
        POS pos = find(key);
        if (pos.isValid()) {
            counter = delete(pos);
        }
        int tempCounterKey = _counterKey;
        return counter + tempCounterKey;
    }

    @Override
    public POS find(KEY key)  {
    	_counterKey = 0;
        assert key != null;
        
        ELEM stopperElem = new ELEM(key);
        _tail.setElement(stopperElem);

        Container cont = _head;

        while (!(cont.getNextContainer().getElement().equals(stopperElem))) {
            cont = cont.getNextContainer();
            _counterKey++;
        }

        _tail.setElement(null);

        if (cont.getNextContainer() == _tail) {
            return new POSContainer(null, this);
        } else {
            return new POSContainer(cont, this);
        }
    }

    @Override
    public ELEM retrieve(POS pos)
    {
        assert pos != null;
        assert pos.isValid();
        
        POSContainer position = (POSContainer) pos;
        return position.getContainer().getNextContainer().getElement();
    }

    @Override
    public void showall()
    {
        Container _next = _head.getNextContainer();
        while (_next != _tail)  {
            System.out.println(_next.getElement().toString());
            _next = _next.getNextContainer();
        }
    }

    @Override
    public int size() {
        return _head.getNextContainer().getSize();
    }


    @Override
    public SET unify(SET s, SET t)  {
        assert s != null;
        assert t != null;
        
        SETContainer sSETContainer = (SETContainer) s;
        SETContainer tSETContainer = (SETContainer) t;

        SETContainer resuSet = new SETContainer();

        resuSet._head = sSETContainer._head;
        resuSet._tail = sSETContainer._tail;

        Container cont = tSETContainer._head;
        do {
            cont = cont.getNextContainer();
            resuSet.add(cont.getElement());

        }
        while (cont.getNextContainer().getElement() != null);
        
        return resuSet;
    }
}
