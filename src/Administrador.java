package src;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
//comentario de prueba
// Nueva clase Administrador
class Administrador implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasena;
    private String correoElectronico;
    private String numeroTelefono;

    public Administrador(String nombre, String apellido, String nombreUsuario,
                         String contrasena, String correoElectronico, String numeroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    public boolean autenticar(String nombreUsuario, String contrasena) {
        boolean autenticado = this.nombreUsuario.equals(nombreUsuario) && this.contrasena.equals(contrasena);
        if (autenticado) {
            Biblioteca.obtenerInstancia().guardarInformacion();  // Guardar información al iniciar sesión como administrador
        }
        return autenticado;
    }

    public void agregarLibro(Biblioteca biblioteca, Libro libro) {
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado al catálogo.");
    }

    public void eliminarLibro(Biblioteca biblioteca, String isbn) {
        biblioteca.eliminarLibro(isbn);
    }

    public void editarLibro(Biblioteca biblioteca, String isbn, Libro libro) {
        biblioteca.editarLibro(isbn, libro);
    }

    public void buscarLibro(Biblioteca biblioteca, String terminoBusqueda) {
        List<Libro> resultadosBusqueda = biblioteca.buscarLibro(terminoBusqueda);
        if (!resultadosBusqueda.isEmpty()) {
            System.out.println("Resultados de la búsqueda:");
            for (Libro resultado : resultadosBusqueda) {
                resultado.mostrarInformacion();
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("No se encontraron resultados para la búsqueda.");
        }
    }

    public void verLibrosPrestados(Biblioteca biblioteca) {
        List<Libro> librosPrestados = biblioteca.getLibrosPrestados();
        if (!librosPrestados.isEmpty()) {
            System.out.println("Libros prestados:");
            for (Libro libro : librosPrestados) {
                libro.mostrarInformacion();
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("No hay libros prestados en este momento.");
        }
    }

    public void verUsuariosRegistrados(Biblioteca biblioteca) {
        Map<String, Usuario> usuarios = biblioteca.getUsuarios();
        if (!usuarios.isEmpty()) {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : usuarios.values()) {
                System.out.println("Nombre de Usuario: " + usuario.getNombreUsuario());
                System.out.println("Correo Electrónico: " + usuario.getCorreoElectronico());
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("No hay usuarios registrados en este momento.");
        }
    }

    public void aceptarPrestamo(Biblioteca biblioteca, Libro libro, Usuario usuario) {
        biblioteca.aceptarPrestamo(libro, usuario);
    }

    public void denegarPrestamo(Biblioteca biblioteca, Libro libro, Usuario usuario) {
        biblioteca.denegarPrestamo(libro, usuario);
    }
}
