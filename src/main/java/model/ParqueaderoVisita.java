package model;

import G5_CheckIn.G5_GestionDB;

public class ParqueaderoVisita {
    int numeroParqueadero;
    String estado;
    G5_GestionDB c;

    public ParqueaderoVisita() {
        c = new G5_GestionDB();
    }

    public ParqueaderoVisita(int numeroParqueadero, String estado) {
        c = new G5_GestionDB();
        this.numeroParqueadero = numeroParqueadero;
        this.estado = estado;
    }

    public int getNumeroParqueadero() {
        return numeroParqueadero;
    }

    public void setNumeroParqueadero(int numeroParqueadero) {
        this.numeroParqueadero = numeroParqueadero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para cambiar el estado del parqueadero utilizando el número de parqueadero
    public void cambiarEstadoParqueadero(int numero, String nuevoEstado) {
        String queryParqueadero = "UPDATE ParqueaderoVisita SET estado = '" + nuevoEstado + "' WHERE idParqueadero = " + numero;
        c.ejecutar(queryParqueadero);
        this.estado = nuevoEstado;
    }
}
