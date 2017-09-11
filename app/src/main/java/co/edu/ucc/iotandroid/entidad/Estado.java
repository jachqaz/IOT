package co.edu.ucc.iotandroid.entidad;

/**
 * Created by jach_ on 5/09/2017.
 */

public class Estado {
    private int bano;
    private int sala;
    private int cocina;
    private int habitacion;

    public Estado() {
    }

    public int getBano() {
        return bano;
    }

    public void setBano(int bano) {
        this.bano = bano;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getCocina() {
        return cocina;
    }

    public void setCocina(int cocina) {
        this.cocina = cocina;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
}
