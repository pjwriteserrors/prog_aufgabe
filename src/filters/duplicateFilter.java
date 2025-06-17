package filters;

import interfaces.Callable;
import java.util.HashSet;

public class duplicateFilter implements Callable<Boolean, Integer> {
    private HashSet<Integer> seen = new HashSet<>();

    @Override
    public Boolean evaluate(Integer element) {
        if (seen.contains(element)) {
            return false;
        } else {
            seen.add(element);
            return true;
        }
    }
}
