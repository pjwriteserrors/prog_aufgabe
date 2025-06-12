package maps;

import interfaces.Callable;

public class multiplyI implements Callable<Integer, Integer> {

    private Integer i;
    public multiplyI(Integer i){
        this.i = i;
    }

    @Override
    public Integer evaluate(Integer p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
    }

}
