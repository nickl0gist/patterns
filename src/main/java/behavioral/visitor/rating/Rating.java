package behavioral.visitor.rating;

import java.util.HashMap;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Represents data structure which keeps employee rating information.
 */
public class Rating extends HashMap<Integer, PerformanceRating> {
    public int getFinalRating(int empId) {
        return get(empId).getFinalRating();
    }
}
