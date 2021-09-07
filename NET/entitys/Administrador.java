package netflux.entitys;

public class Administrador extends Pessoa {
    private int codigo_adm;
    private static int number = 0;

    public Administrador() {
        super();
    }

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
        this.codigo_adm = ++number;
    }

    @Override
    public String showInformation() {
        return "Adm:" + this.getNome()+ ", " + "Email: " + this.getEmail() +"," + "ID: "+ this.codigo_adm;
    }

    public int getCodigo_adm() {
        return codigo_adm;
    }

    public void setCodigo_adm(int codigo_adm) {
        this.codigo_adm = codigo_adm;
    }
}
