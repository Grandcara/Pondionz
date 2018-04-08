package br.com.pondionz.model;

/**
 * Created by Iago on 14/03/2016.
 */
public class Cidade {
    private int idCidade;
    private String nome;
    public Cidade(int idCidade,String nome){
        this.idCidade = idCidade;
        this.nome = nome;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nome='" + nome + '\'' +
                '}';
    }
}
