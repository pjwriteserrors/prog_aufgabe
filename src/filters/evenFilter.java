package filters;

import interfaces.Callable;

public class evenFilter implements Callable<Boolean, Integer> {

    @Override
    public Boolean evaluate(Integer p) {
        return p % 2 == 0;
    }

}
