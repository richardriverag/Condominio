package model;



import java.sql.Date;
import model.TipoPago;

public class Pago {
    
    private String id_Pagos;
    private String id_Usuario;
    private String fecha_Pago;
    private String id_MetodoPago;
    private float monto_Pago;
    private TipoPago tipoPago_Pago;  
    private String fechaVencimiento_Pago;
    private String estado_Pago;
    private String descripcion;

    public Pago() {
    }

    public Pago(String id_Pagos, String id_Usuario, String fecha_Pago, String id_MetodoPago, float monto_Pago, TipoPago tipoPago_Pago, String fechaVencimiento_Pago, String estado_Pago, String descripcion) {
        this.id_Pagos = id_Pagos;
        this.id_Usuario = id_Usuario;
        this.fecha_Pago = fecha_Pago;
        this.id_MetodoPago = id_MetodoPago;
        this.monto_Pago = monto_Pago;
        this.tipoPago_Pago = tipoPago_Pago;
        this.fechaVencimiento_Pago = fechaVencimiento_Pago;
        this.estado_Pago = estado_Pago;
        this.descripcion = descripcion;
    }

    public String getId_Pagos() {
        return id_Pagos;
    }

    public void setId_Pagos(String id_Pagos) {
        this.id_Pagos = id_Pagos;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getFecha_Pago() {
        return fecha_Pago;
    }

    public void setFecha_Pago(String fecha_Pago) {
        this.fecha_Pago = fecha_Pago;
    }

    public String getId_MetodoPago() {
        return id_MetodoPago;
    }

    public void setId_MetodoPago(String id_MetodoPago) {
        this.id_MetodoPago = id_MetodoPago;
    }

    public float getMonto_Pago() {
        return monto_Pago;
    }

    public void setMonto_Pago(float monto_Pago) {
        this.monto_Pago = monto_Pago;
    }

    public TipoPago getTipoPago_Pago() {
        return tipoPago_Pago;
    }

    public void setTipoPago_Pago(TipoPago tipoPago_Pago) {
        this.tipoPago_Pago = tipoPago_Pago;
    }

    public String getFechaVencimiento_Pago() {
        return fechaVencimiento_Pago;
    }

    public void setFechaVencimiento_Pago(String fechaVencimiento_Pago) {
        this.fechaVencimiento_Pago = fechaVencimiento_Pago;
    }

    public String getEstado_Pago() {
        return estado_Pago;
    }

    public void setEstado_Pago(String estado_Pago) {
        this.estado_Pago = estado_Pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
