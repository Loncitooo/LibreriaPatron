package src;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Patrón de diseño Singleton para la Biblioteca
class Biblioteca {
    private static Biblioteca instancia;
    private Map<String, Libro> catalogo;
    private Map<String, Usuario> usuarios;
    private List<Libro> librosPrestados;

    public void cargarInformacionTXT() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {  // Verificar si hay 8 partes en la línea
                    try {
                        Usuario usuario = new Usuario(parts[0], parts[1], Integer.parseInt(parts[2]),
                                parts[3], parts[4], parts[5], parts[6], parts[7]);
                        registrarUsuario(usuario);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el idUsuario a entero en la línea: " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Error en el formato de la línea: " + line);
                }
            }
            System.out.println("Datos de usuarios cargados correctamente desde formato TXT.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void guardarInformacionTXT() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("usuarios_data.txt"))) {
            for (Usuario usuario : usuarios.values()) {
                writer.println(usuario.getNombre() + "," +
                        usuario.getApellido() + "," +
                        usuario.getIdUsuario() + "," +
                        usuario.getNombreUsuario() + "," +
                        usuario.getContrasena() + "," +
                        usuario.getCorreoElectronico() + "," +
                        usuario.getNumeroTelefono() + "," +
                        usuario.getFechaRegistro());
            }
            System.out.println("Información de usuarios guardada correctamente en formato TXT.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void eliminarLibro(String isbn) {
        if (catalogo.containsKey(isbn)) {
            catalogo.remove(isbn);
            System.out.println("Libro eliminado del catálogo.");
        } else {
            System.out.println("Libro no encontrado en el catálogo.");
        }
    }

    public void editarLibro(String isbn, Libro libro) {
        if (catalogo.containsKey(isbn)) {
            catalogo.put(isbn, libro);
            System.out.println("Libro editado en el catálogo.");
        } else {
            System.out.println("Libro no encontrado en el catálogo.");
        }
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void aceptarPrestamo(Libro libro, Usuario usuario) {
        if (librosPrestados.contains(libro)) {
            usuario.historialPrestamos.add(libro);
            librosPrestados.remove(libro);
            System.out.println("Préstamo aceptado.");
        } else {
            System.out.println("El libro no está marcado como prestado.");
        }
    }

    public void denegarPrestamo(Libro libro, Usuario usuario) {
        if (librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
            System.out.println("Préstamo denegado.");
        } else {
            System.out.println("El libro no está marcado como prestado.");
        }
    }

    private Biblioteca() {
        this.catalogo = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.librosPrestados = new ArrayList<>();
    }

    public static Biblioteca obtenerInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public void agregarLibro(Libro libro) {
        catalogo.put(libro.getIsbn(), libro);
    }

    public void mostrarInformacionLibro(String isbn) {
        if (catalogo.containsKey(isbn)) {
            Libro libro = catalogo.get(isbn);
            libro.mostrarInformacion();
        } else {
            System.out.println("Libro no encontrado en el catálogo.");
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
        guardarInformacionTXT();  // Guardar información después de registrar un usuario
    }


    public Usuario iniciarSesionUsuario(String nombreUsuario, String contrasena) {
        if (usuarios.containsKey(nombreUsuario)) {
            Usuario usuario = usuarios.get(nombreUsuario);
            if (usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado o contraseña incorrecta
    }

    public List<Libro> buscarLibro(String terminoBusqueda) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : catalogo.values()) {
            if (libro.getTitulo().toLowerCase().contains(terminoBusqueda.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public Libro getLibroPorISBN(String isbnEditar) {
        return null;
    }

    public void guardarInformacion() {
    }

    public void cargarInformacion() {
    }
}
