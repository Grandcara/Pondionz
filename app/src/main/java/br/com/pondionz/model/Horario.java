package br.com.pondionz.model;

/**
 * Created by Iago on 29/12/2015.
 */
//Modelo do horario ultilizado na aplicação
public class Horario {
    private int idLinha;
    private String horarioX,horarioY,infoAdicionaisX,infoAdicionaisY ;
    private int tipo; //Determina: 1 = Segunda a sexta , 2 = sabado , 3 = domingo e feriados, 4 = todos os dias sao os msm
    public Horario(int idLinha, String horarioX,String infoAdicionaisX, String horarioY,String infoAdicionaisY,int tipo){
        this.idLinha = idLinha;
        this.horarioX = horarioX;
        this.horarioY = horarioY;
        this.infoAdicionaisX = infoAdicionaisX;
        this.infoAdicionaisY = infoAdicionaisY;
        this.tipo = tipo;
    }



    public int getTipo() {
        return tipo;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public String getInfoAdicionaisX() {
        return infoAdicionaisX;
    }

    public void setInfoAdicionaisX(String infoAdicionaisX) {
        this.infoAdicionaisX = infoAdicionaisX;
    }

    public String getInfoAdicionaisY() {
        return infoAdicionaisY;
    }

    public void setInfoAdicionaisY(String infoAdicionaisY) {
        this.infoAdicionaisY = infoAdicionaisY;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    public String getHorarioX() {
        return horarioX;
    }

    public void setHorarioX(String horarioX) {
        this.horarioX = horarioX;
    }

    public String getHorarioY() {
        return horarioY;
    }

    public void setHorarioY(String horarioY) {
        this.horarioY = horarioY;
    }
}
