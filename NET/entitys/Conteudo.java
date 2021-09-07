package netflux.entitys;

public abstract class Conteudo {
    private String titulo;
    private String dataLancamento;
    private String linguagem;
    private String genero;

    public Conteudo() {
    }

    public Conteudo(String titulo, String dataLancamento, String linguagem, String genero) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.linguagem = linguagem;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getLinguaguem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public abstract String showDescription();
}
