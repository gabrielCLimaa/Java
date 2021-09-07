

public final class RadioPlayer extends Player {
    private double frequency;

    public RadioPlayer() {
        this.frequency = 87.5;
    }

    public RadioPlayer(double frequency, int volume, boolean muted) {
        super(volume, muted);
        this.frequency = setFrequency(frequency);
    }

    public double getFrequency() {
        return frequency;
    }

    public double setFrequency(double frequency) {
        if(frequency >= 87.5 && frequency <= 108.0) {
            this.frequency = frequency;
        }
        return frequency;
    }
    
    @Override
    public String whatsPlaying() {
        return "Radio Player: " + getFrequency() + "Mhz";
    }
    
    
}
