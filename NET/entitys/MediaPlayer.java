package netflux.entitys;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

public class MediaPlayer {
    private Conteudo conteudo;
    private int episodioExibindoId;
    public MediaPlayer() {
    }

    public MediaPlayer(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public void Play() {

        System.out.println("-----------------------------------");
        System.out.println("|Exibindo "+ conteudo.getTitulo()+"|");
        System.out.println("-----------------------------------");
    }

    public void StopPlaying() {

        System.out.println("-----------------------------------");
        System.out.println("|"+conteudo.getTitulo()+" em pausa|");
        System.out.println("-----------------------------------");

    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public int getEpisodioExibindo() {
        return this.episodioExibindoId;
    }

    public void setEpisodioExibindo(int id) {
        this.episodioExibindoId  = id;
    }

    public void PlaySerie(int idEpisodio) {
        Serie serie = (Serie) conteudo;
        ArrayList<Episodio>  episodios = serie.getListaEp();
        Episodio episodio = episodios.get(idEpisodio);
        this.setEpisodioExibindo(idEpisodio);
        System.out.println("-----------------------------------");
        System.out.println("|Exibindo "+episodio.getTituloEpisodio()+"|");
        System.out.println("-----------------------------------");
    }

    public void StopPlayingSerie(int idEpisodio) {
        Serie serie = (Serie) conteudo;
        ArrayList<Episodio>  episodios = serie.getListaEp();
        Episodio episodio = episodios.get(idEpisodio);
        this.setEpisodioExibindo(idEpisodio);
        System.out.println("-----------------------------------");
        System.out.println("|"+episodio.getTituloEpisodio()+" em pausa|");
        System.out.println("-----------------------------------");
    }
}
