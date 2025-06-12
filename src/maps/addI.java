package maps;

import interfaces.Callable;

public class addI implements Callable<Integer, Integer> {

    private Integer i;
    public addI(Integer i){
        this.i = i;
    }
    @Override
    public Integer evaluate(Integer p) {
        return i+p;
    }

}
