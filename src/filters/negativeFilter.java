package filters;

import interfaces.Callable;

public class negativeFilter implements Callable<Boolean, Integer> {

    @Override
    public Boolean evaluate(Integer p) {
        return p < 0;
    }

}
