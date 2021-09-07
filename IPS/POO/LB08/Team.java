import java.util.Objects;

public class Team implements IPoints, Comparable<Team> {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Team: " + name + "Points: " + points;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Team t) {
      return (this.points > t.points) ? 1 : 
              (this.points < t.points) ? -1 : 0;    }
    
    
}
