package aufgabeC;

import core.POS;
import core.SET;

class POSContainer implements POS
{
    Container _container;
    SET _set;

    POSContainer(Container c, SET set)
    {
        _container = c;
        _set = set;
    }

    public Container getContainer()
    {
        return _container;
    }

   
    @Override
    public boolean isValid()
    {
        return _container != null;
    }

}
