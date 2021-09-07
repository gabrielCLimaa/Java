

public class AppStart {
    public static void main(String[] args) {
        
       ChampionshipTable list = new ChampionshipTable(4);
       
       Team a = new Team("Sporting");
       a.setPoints(80);
       Team b = new Team("Porto");
       b.setPoints(65);
       Team c = new Team("Benfica");
       c.setPoints(70);
       Team d = new Team("Braga");
       d.setPoints(71);
       
      list.add(a);
      list.add(b);
      list.add(c);
      list.add(d);
      
     
      list.sort();
      
      list.stream().forEach(p->System.out.println(p.toString()));
    }
    
}
