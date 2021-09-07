package netflux.entitys;

public class Usuario extends Pessoa {
    private int mensalidade;
    private int codigo_usuario;
    private static int number;

    public Usuario() {
    }

    public Usuario(String nome ,String email, String senha, int mensalidade ) {
        super(nome, email,senha);
        this.mensalidade = mensalidade;
        this.codigo_usuario = ++number;
    }

    public int getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(int mensalidade) {
        this.mensalidade = mensalidade;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    @Override
    public String showInformation() {
        return "Usuario:" + this.getNome()+ ", " + "Email: " + this.getEmail() +", "+ "Plano: " + this.mensalidade + "," + "ID: "+ this.codigo_usuario;
    }
}
