package model;

import G5_CheckIn.G5_GestionDB;

public class Visita {
    
    private Usuario usuario;
    private String nombreVisitante;
    private String motivoVisita;
    private String fecha;
    private String hora;
    private String vehiculo;
    private String tipoUsuario = "Visita";
    G5_GestionDB c;

    public Visita() {
        c = new G5_GestionDB();
    }

    public Visita(Usuario usuario, String nombreVisitante, String motivoVisita, String fecha, String hora, String vehiculo) {
        this.usuario = usuario;
        this.nombreVisitante = nombreVisitante;
        this.motivoVisita = motivoVisita;
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        c = new G5_GestionDB();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    
    // Método para agregar una visita
    public void registrarVisita(String idUsuario, String nombreVisitante, String motivoVisita,String fecha, String hora, String vehiculo) {
        String query = "INSERT INTO Visitante (id_usuario, nombreVisitante, motivoVisita, fecha, hora, vehiculo, tipoUsuario) VALUES ('"+idUsuario+"', '"+nombreVisitante+"', '"+motivoVisita+"', '"+fecha+"', '"+hora+"', '"+vehiculo+"', 'Visitante')";
        c.ejecutar(query);
        
        //usuario = new Usuario(); FALTA PARTE DEL GRUPO DE CLASE USUARIO
        //usuario.getIdUsuario();
        this.nombreVisitante = nombreVisitante;
        this.motivoVisita = motivoVisita;
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        this.tipoUsuario = tipoUsuario;
       
    }

    // Método para agregar un proveedor
    public void registrarProveedor(String nombreVisitante, String motivoVisita, String fecha, String hora, String vehiculo) {
        String query = "INSERT INTO Visitante (nombreVisitante, motivoVisita, fecha, hora, vehiculo, tipoUsuario) VALUES ('"+nombreVisitante+"', '"+motivoVisita+"', '"+fecha+"', '"+hora+"', '"+vehiculo+"', 'Proveedor')";
        c.ejecutar(query);
       
        this.nombreVisitante = nombreVisitante;
        this.motivoVisita = motivoVisita;
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        this.tipoUsuario = tipoUsuario;
        this.usuario = null; // Establecer idUsuario como null para representar que no hay un usuario asociado
    }
}
