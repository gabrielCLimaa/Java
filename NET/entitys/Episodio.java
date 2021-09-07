package netflux.entitys;

public class Episodio {
    private double duracao;
    private String tituloEpisodio;

    public Episodio() {
    }

    public Episodio(String tituloEpisodio, double duracao) {
        this.duracao = duracao;
        this.tituloEpisodio = tituloEpisodio;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getTituloEpisodio() {
        return tituloEpisodio;
    }

    public void setTituloEpisodio(String tituloEpisodio) {
        this.tituloEpisodio = tituloEpisodio;
    }

    @Override
    public String toString() {
        return "Episodio: "+ this.tituloEpisodio + ", " + "Duração: " + this.duracao + " minutos";
    }
}

