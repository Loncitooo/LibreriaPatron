package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Clase Usuario
class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private String correoElectronico;
    private String numeroTelefono;
    List<Libro> historialPrestamos;
    private String fechaRegistro;

    // Constructor para cargar usuarios desde el CSV
    public Usuario(String nombre, String apellido, int idUsuario,
                   String nombreUsuario, String contrasena, String correoElectronico,
                   String numeroTelefono, String fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.fechaRegistro = fechaRegistro;
        this.historialPrestamos = new ArrayList<>();
    }


    public Usuario(String part, String part1, int i, String part2, String part3, String part4, String part5) {
    }

    // Métodos para las funcionalidades del usuario...
    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
