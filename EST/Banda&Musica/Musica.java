/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EST2;

/**
 *
 * @author G
 */
public class Musica {
    private String nome;
    private Banda banda;

    public Musica(String nome) {
        this.nome = nome;
        this.banda = null;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    @Override
    public String toString() {
        return banda == null ? "Musica: " + nome : "Musica: " + nome + " " + "Banda: " + banda.getNome();
    }
    
}
