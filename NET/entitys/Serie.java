package netflux.entitys;

import java.util.ArrayList;

public class Serie extends Conteudo {
    private int numeroEpisodios;
    private ArrayList<Episodio> listaEpisodios = new ArrayList<>();

    public Serie() {
    }

    public Serie(String titulo, String dataLancamento, String linguagem, String genero, int numeroEpisodios) {
        super(titulo, dataLancamento, linguagem, genero);
        this.numeroEpisodios = numeroEpisodios;
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public void addEp(Episodio episodio) {
        listaEpisodios.add(episodio);
    }

    public void removeEpisodio(Episodio episodio) {
        listaEpisodios.remove(episodio);
    }

    public void printEps() {
        int i = 0;
        for(Episodio ep:listaEpisodios) {
            System.out.println("ID: " + i +"|"+ ep.toString());
            i++;
        }
    }

    public ArrayList<Episodio> getListaEp() {
        return listaEpisodios;
    }

    @Override
    public String showDescription() {
        return "Titulo da serie: " + this.getTitulo() + ", " + "Data de lançamento : " + this.getDataLancamento() + ", " +
                "Linguagem: " + this.getLinguaguem() + ", " + "Genero: " + this.getGenero() + ", " + "Numero de episodios: " +
                this.numeroEpisodios;
    }
}
