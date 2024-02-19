
package model;
import java.util.Date;
import condominio.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irobot
 */
public class AnunciosGenerales {
    private int idAnunciosGenerales;
    private int idAdministrador;
    private int idUsuario;
    private Date fechaAnuncio;
    private String tituloAnuncio;
    private String descripcionAnuncio;
    private Connection connection;

    public AnunciosGenerales() {
        this.connection = Conexion.getCon();
    }
    
    public void crearAnuncioGeneral(AnunciosGenerales anuncio) throws SQLException {
        String query = "INSERT INTO AnunciosGenerales (idAnunciosGenerales, idAdministrador, idUsuario, fechaAnuncio, tituloAnuncio, descripcionAnuncio) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, anuncio.getIdAnunciosGenerales());
            ps.setInt(2, anuncio.getIdAdministrador());
            ps.setInt(3, anuncio.getIdUsuario());
            ps.setDate(4, new java.sql.Date(anuncio.getFechaAnuncio().getTime()));
            ps.setString(5, anuncio.getTituloAnuncio());
            ps.setString(6, anuncio.getDescripcionAnuncio());
            ps.executeUpdate();
        }
    }

    public AnunciosGenerales obtenerAnuncioGeneralPorId(int idAnuncio) throws SQLException {
        String query = "SELECT * FROM AnunciosGenerales WHERE idAnunciosGenerales = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idAnuncio);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    AnunciosGenerales anuncio = new AnunciosGenerales();
                    anuncio.setIdAnunciosGenerales(rs.getInt("idAnunciosGenerales"));
                    anuncio.setIdAdministrador(rs.getInt("idAdministrador"));
                    anuncio.setIdUsuario(rs.getInt("idUsuario"));
                    anuncio.setFechaAnuncio(rs.getDate("fechaAnuncio"));
                    anuncio.setTituloAnuncio(rs.getString("tituloAnuncio"));
                    anuncio.setDescripcionAnuncio(rs.getString("descripcionAnuncio"));
                    return anuncio;
                }
            }
        }
        return null;
    }

    public List<AnunciosGenerales> obtenerTodosAnunciosGenerales() throws SQLException {
        List<AnunciosGenerales> anuncios = new ArrayList<>();
        String query = "SELECT * FROM AnunciosGenerales";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AnunciosGenerales anuncio = new AnunciosGenerales();
                anuncio.setIdAnunciosGenerales(rs.getInt("idAnunciosGenerales"));
                anuncio.setIdAdministrador(rs.getInt("idAdministrador"));
                anuncio.setIdUsuario(rs.getInt("idUsuario"));
                anuncio.setFechaAnuncio(rs.getDate("fechaAnuncio"));
                anuncio.setTituloAnuncio(rs.getString("tituloAnuncio"));
                anuncio.setDescripcionAnuncio(rs.getString("descripcionAnuncio"));
                anuncios.add(anuncio);
            }
        }
        return anuncios;
    }

    public void actualizarAnuncioGeneral(AnunciosGenerales anuncio) throws SQLException {
        String query = "UPDATE AnunciosGenerales SET idAdministrador = ?, idUsuario = ?, fechaAnuncio = ?, tituloAnuncio = ?, descripcionAnuncio = ? WHERE idAnunciosGenerales = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, anuncio.getIdAdministrador());
            ps.setInt(2, anuncio.getIdUsuario());
            ps.setDate(3, new java.sql.Date(anuncio.getFechaAnuncio().getTime()));
            ps.setString(4, anuncio.getTituloAnuncio());
            ps.setString(5, anuncio.getDescripcionAnuncio());
            ps.setInt(6, anuncio.getIdAnunciosGenerales());
            ps.executeUpdate();
        }
    }

    public void eliminarAnuncioGeneral(int idAnuncio) throws SQLException {
        String query = "DELETE FROM AnunciosGenerales WHERE idAnunciosGenerales = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idAnuncio);
            ps.executeUpdate();
        }
    }
    
    public int getIdAnunciosGenerales() {
        return idAnunciosGenerales;
    }

    public void setIdAnunciosGenerales(int idAnunciosGenerales) {
        this.idAnunciosGenerales = idAnunciosGenerales;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaAnuncio() {
        return fechaAnuncio;
    }

    public void setFechaAnuncio(Date fechaAnuncio) {
        this.fechaAnuncio = fechaAnuncio;
    }

    public String getTituloAnuncio() {
        return tituloAnuncio;
    }

    public void setTituloAnuncio(String tituloAnuncio) {
        this.tituloAnuncio = tituloAnuncio;
    }

    public String getDescripcionAnuncio() {
        return descripcionAnuncio;
    }

    public void setDescripcionAnuncio(String descripcionAnuncio) {
        this.descripcionAnuncio = descripcionAnuncio;
    }
}
