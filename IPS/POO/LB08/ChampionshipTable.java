
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ChampionshipTable extends LinkedList<IPoints> implements Comparator<IPoints>{
    private int capacity;
    
    public ChampionshipTable(int capacity) {
        this.capacity = capacity;
    }
    
    public int getCapacity() {
        return this.capacity;
        
    }
    
    @Override
    public boolean add(IPoints e) {
      if(this.size() < capacity) {
         super.add(e);
         return true;
      }
      return false;
    }

    @Override
    public void add(int index, IPoints element) {
        if(capacity > index && index > 0) {
            this.set(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends IPoints> c) {
        if(this.size() < capacity && (c.size() + this.size() < capacity )) {
            super.addAll(c);
            return true;
        }
        return false;
    }

    
    public void sort() {
        Collections.sort(this, this);
    }

    @Override
    public int compare(IPoints o1, IPoints o2) {
        Team r1 = new Team("A");
        Team r2 = new Team("B");
        r1.setPoints(o1.getPoints());
        r2.setPoints(o2.getPoints());
        return r2.compareTo(r1);
        
    }
}
