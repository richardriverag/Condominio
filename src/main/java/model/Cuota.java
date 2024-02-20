/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;



/**
 *
 * @author eddya
 */
public class Cuota {
    private String id_Pagos;
    private String id_Cuota;
    private int numero_Cuota;
    private float monto_Cuota;
    private Date fechaV_cuota;

    public Cuota() {
    }

    public Cuota(String id_Pagos, String id_Cuota, int numero_Cuota, float monto_Cuota, Date fechaV_cuota) {
        this.id_Pagos = id_Pagos;
        this.id_Cuota = id_Cuota;
        this.numero_Cuota = numero_Cuota;
        this.monto_Cuota = monto_Cuota;
        this.fechaV_cuota = fechaV_cuota;
    }

    public String getId_Pagos() {
        return id_Pagos;
    }

    public void setId_Pagos(String id_Pagos) {
        this.id_Pagos = id_Pagos;
    }

    public String getId_Cuota() {
        return id_Cuota;
    }

    public void setId_Cuota(String id_Cuota) {
        this.id_Cuota = id_Cuota;
    }

    public int getNumero_Cuota() {
        return numero_Cuota;
    }

    public void setNumero_Cuota(int numero_Cuota) {
        this.numero_Cuota = numero_Cuota;
    }

    public float getMonto_Cuota() {
        return monto_Cuota;
    }

    public void setMonto_Cuota(float monto_Cuota) {
        this.monto_Cuota = monto_Cuota;
    }

    public Date getFechaV_cuota() {
        return fechaV_cuota;
    }

    public void setFechaV_cuota(Date fechaV_cuota) {
        this.fechaV_cuota = fechaV_cuota;
    }
    
    
    
}
