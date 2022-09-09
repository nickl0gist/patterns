package behavioral.visitor.rating;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class PerformanceRating {

    @Getter
    private final int id;

    @Getter
    private final int personalRating;

    @Setter
    @Getter
    private int teamAverageRating;

    @Setter
    @Getter
    private int finalRating;

    public PerformanceRating(int id, int personalRating) {
        this.id = id;
        this.personalRating = personalRating;
    }
}
