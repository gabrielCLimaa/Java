

public class Player {
    private int volume;
    private boolean muted;

    public Player() {
        this.volume = 5;
        this.muted = false;
    }   
    
    public Player(int volume, boolean muted) {
        this.volume = setVolume(volume);
        this.muted = setMuted(muted);
    }   

    public int getVolume() {
        return volume;
    }

    public int setVolume(int volume) {
        if(volume <= 30 && volume >= 0){
            this.volume = volume;
        }
        return volume;
    }

    public boolean isMuted() {
        return muted;
    }

    public boolean setMuted(boolean muted) {
        if(muted == true) {
            setVolume(0);
            this.muted = muted;
        } else {this.muted = muted;}
        return muted;
    }
    
    public void increaseVolume(){
        if(volume <= 30 && volume >= 0){
             this.volume+= 1;
        }
    }
    
    public void decreaseVolume() {
        if(volume > 0) { 
            this.volume-= 1;
        } else {setMuted(true);}
    }
    
    public String whatsPlaying() {
        return "no music to play";
    }

    @Override
    public String toString() {
        return "Volume:" + getVolume() + "\r\n" + whatsPlaying();
    }
    
}
