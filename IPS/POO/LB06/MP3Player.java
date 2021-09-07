
import java.util.ArrayList;

public class MP3Player extends Player {
    ArrayList<Music> musicList;
    private Music currentMusic;

    public MP3Player() {
        super();
        this.musicList = new ArrayList<>();
    }

    public ArrayList<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(ArrayList<Music> musicList) {
        this.musicList = musicList;
    }

    public Music getCurrentMusic() {
        return currentMusic;
    }

    public void setCurrentMusic(Music currentMusic) {
        this.currentMusic = currentMusic;
    }
    
   @Override
   public String whatsPlaying() {
       Music musica = getCurrentMusic();
       return "MP3 Player: " + musica.getArtist() + ":" + musica.getTitle();
   }
    
   public void nextMusic() { 
      if(musicList.indexOf(this.currentMusic) != musicList.size() - 1) {
        int nextIndex = musicList.indexOf(this.currentMusic) + 1;
        Music nextSong = musicList.get(nextIndex);
        this.setCurrentMusic(nextSong);
      } else { 
            int nextIndex = 0;
            Music nextSong = musicList.get(nextIndex);
            this.setCurrentMusic(nextSong);
      }
   }
   
   public void previousMusic() {
        if(musicList.indexOf(this.currentMusic) != 0) {
            int nextIndex = musicList.indexOf(this.currentMusic) - 1;
            Music nextSong = musicList.get(nextIndex);
            this.setCurrentMusic(nextSong);
   } else {
            if(musicList.indexOf(this.currentMusic) == 0) {
                int nextIndex = musicList.size() - 1;
                Music nextSong = musicList.get(nextIndex);
                this.setCurrentMusic(nextSong);
        }
    }
    }
}
