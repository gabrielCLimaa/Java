
import java.util.ArrayList;
import java.util.List;

public class AppStart {
    public static void main(String[] args) {
        Player g1 = new Player();
        
        System.out.println(g1.toString());
        
        
        RadioPlayer rd1 = new RadioPlayer();
        rd1.setFrequency(89.9);
        System.out.println(rd1.toString());
        
        MP3Player mp1 = new MP3Player();
        
         ArrayList<Music> musics = new ArrayList();
         musics.add(new Music("O Amor é Magico", "Expensive Soul"));
         musics.add(new Music("Ordinary World", "Duran Duran"));
         musics.add(new Music("In Your Eyes", "The Weekend"));
        
        
         mp1.setMusicList(musics);
        
         mp1.increaseVolume();
         mp1.increaseVolume();
         mp1.increaseVolume();
         
         mp1.nextMusic();
         System.out.println("1>"+ mp1.toString());
         mp1.nextMusic();
         System.out.println("2>"+ mp1.toString());
         
         List<Player> Lista = new ArrayList<>();
         Lista.add(g1);
         Lista.add(rd1);
         Lista.add(mp1);
         
         for(Player p:Lista) { 
             System.out.println(p.toString());
         }
    }
    
}
