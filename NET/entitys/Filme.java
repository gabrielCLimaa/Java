package netflux.entitys;

public class Filme extends Conteudo {
    private double duracao;

    public Filme() {
    }

    public Filme(String titulo, String dataLancamento, String linguagem, String genero, double duracao) {
        super(titulo, dataLancamento, linguagem, genero);
        this.duracao = duracao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    @Override
    public String showDescription() {
        return "Titulo do filme: " + this.getTitulo() + ", " + "Data de lançamento : " + this.getDataLancamento() + ", " +
                "Linguagem: " + this.getLinguaguem() + ", " + "Genero: " + this.getGenero() + ", " + "Duração " +
                this.duracao + " minutos";
    }
}
