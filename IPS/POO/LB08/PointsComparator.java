
import java.util.Comparator;

public class PointsComparator implements Comparator<Team> {

    @Override
    public int compare(Team t1, Team t2) {
       return t1.compareTo(t2);
    }
    
    
}
