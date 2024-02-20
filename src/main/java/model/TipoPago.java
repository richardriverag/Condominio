/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eddya
 */
public class TipoPago {
    private String id_TipoPago;
    private String nombre_Pago;

    public TipoPago() {
    }

    public TipoPago(String id_TipoPago, String nombre_Pago) {
        this.id_TipoPago = id_TipoPago;
        this.nombre_Pago = nombre_Pago;
    }
    
    public TipoPago(String nombre_Pago) {
        this.nombre_Pago = nombre_Pago;
    }

    public String getId_TipoPago() {
        return id_TipoPago;
    }

    public void setId_TipoPago(String id_TipoPago) {
        this.id_TipoPago = id_TipoPago;
    }

    public String getNombre_Pago() {
        return nombre_Pago;
    }

    public void setNombre_Pago(String nombre_Pago) {
        this.nombre_Pago = nombre_Pago;
    }
    
    
}
