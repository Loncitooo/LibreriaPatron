package src;
import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.obtenerInstancia();
        biblioteca.cargarInformacionTXT();  // Cargar información de usuarios al inicio


        // Crear libros y usuarios usando el patrón Factory
        LibroFactory libroFactory = new LibroFactoryImpl();
        UsuarioFactory usuarioFactory = new UsuarioFactoryImpl();

        Libro libro1 = libroFactory.crearLibro("Libro1", new String[]{"Autor1"}, "ISBN1", "Ficción",
                "Editorial1", 2020, 200, "Español");
        biblioteca.agregarLibro(libro1);

        // Crear administrador
        Administrador administrador = new Administrador("AdminNombre", "AdminApellido",
                "admin", "admin123", "admin@example.com", "123456789");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Iniciar sesión de usuario");
            System.out.println("2. Iniciar sesión de administrador");
            System.out.println("3. Registrarse");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Iniciar sesión del usuario
                    System.out.println("Ingresa el nombre de usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingresa la contraseña:");
                    String contrasena = scanner.nextLine();
                    Usuario usuarioAutenticado = biblioteca.iniciarSesionUsuario(nombreUsuario, contrasena);
                    if (usuarioAutenticado != null) {
                        System.out.println("Inicio de sesión exitoso.");

                        // Menú después de iniciar sesión como usuario
                        while (true) {
                            System.out.println("Selecciona una opción:");
                            System.out.println("1. Solicitar préstamo");
                            System.out.println("2. Devolver libro");
                            System.out.println("3. Buscar libro");
                            System.out.println("0. Cerrar sesión");

                            int opcionUsuario = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer del scanner

                            switch (opcionUsuario) {
                                case 1:
                                    // Solicitar préstamo
                                    // Lógica para solicitar préstamo...
                                    System.out.println("Funcionalidad no implementada.");
                                    break;
                                case 2:
                                    // Devolver libro
                                    // Lógica para devolver libro...
                                    System.out.println("Funcionalidad no implementada.");
                                    break;
                                case 3:
                                    // Buscar libro
                                    System.out.println("Ingresa el término de búsqueda:");
                                    String terminoBusqueda = scanner.nextLine();
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
                                    break;
                                case 0:
                                    // Cerrar sesión del usuario
                                    System.out.println("Sesión cerrada.");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                            }

                            if (opcionUsuario == 0) {
                                break; // Salir del bucle después de cerrar sesión
                            }
                        }
                    } else {
                        System.out.println("Inicio de sesión fallido. Usuario no encontrado o contraseña incorrecta.");
                    }
                    break;
                case 2:
                    // Iniciar sesión del administrador
                    System.out.println("Ingresa el nombre de administrador:");
                    String nombreAdmin = scanner.nextLine();
                    System.out.println("Ingresa la contraseña de administrador:");
                    String contrasenaAdmin = scanner.nextLine();

                    if (administrador.autenticar(nombreAdmin, contrasenaAdmin)) {
                        System.out.println("Inicio de sesión de administrador exitoso.");

                        // Menú después de iniciar sesión como administrador
                        while (true) {
                            System.out.println("Selecciona una opción:");
                            System.out.println("1. Agregar libro al catálogo");
                            System.out.println("2. Eliminar libro del catálogo");
                            System.out.println("3. Editar información de un libro");
                            System.out.println("4. Buscar libro en el catálogo");
                            System.out.println("5. Ver libros prestados");
                            System.out.println("6. Ver usuarios registrados");
                            System.out.println("7. Aceptar préstamo");
                            System.out.println("8. Denegar préstamo");
                            System.out.println("0. Cerrar sesión");

                            int opcionAdmin = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer del scanner

                            switch (opcionAdmin) {
                                case 1:
                                    // Agregar libro al catálogo
                                    System.out.println("Ingrese los detalles del libro:");
                                    // Lógica para agregar libro...
                                    break;
                                case 2:
                                    // Eliminar libro del catálogo
                                    System.out.println("Ingrese el ISBN del libro a eliminar:");
                                    String isbnEliminar = scanner.nextLine();
                                    biblioteca.eliminarLibro(isbnEliminar);
                                    break;
                                case 3:
                                    // Editar información de un libro
                                    System.out.println("Ingrese el ISBN del libro a editar:");
                                    String isbnEditar = scanner.nextLine();
                                    Libro libroEditar = biblioteca.getLibroPorISBN(isbnEditar);
                                    if (libroEditar != null) {
                                        System.out.println("Ingrese los nuevos detalles del libro:");
                                        // Lógica para editar libro...
                                    } else {
                                        System.out.println("Libro no encontrado.");
                                    }
                                    break;
                                case 4:
                                    // Buscar libro en el catálogo
                                    System.out.println("Ingresa el término de búsqueda:");
                                    String terminoBusquedaAdmin = scanner.nextLine();
                                    List<Libro> resultadosBusquedaAdmin = biblioteca.buscarLibro(terminoBusquedaAdmin);
                                    if (!resultadosBusquedaAdmin.isEmpty()) {
                                        System.out.println("Resultados de la búsqueda:");
                                        for (Libro resultado : resultadosBusquedaAdmin) {
                                            resultado.mostrarInformacion();
                                            System.out.println("-----------------------");
                                        }
                                    } else {
                                        System.out.println("No se encontraron resultados para la búsqueda.");
                                    }
                                    break;
                                case 5:
                                    // Ver libros prestados
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
                                    break;
                                case 6:
                                    // Ver usuarios registrados
                                    Map<String, Usuario> usuariosRegistrados = biblioteca.getUsuarios();
                                    if (!usuariosRegistrados.isEmpty()) {
                                        System.out.println("Usuarios registrados:");
                                        for (Usuario usuarioRegistrado : usuariosRegistrados.values()) {
                                            System.out.println("Nombre de Usuario: " + usuarioRegistrado.getNombreUsuario());
                                            System.out.println("Correo Electrónico: " + usuarioRegistrado.getCorreoElectronico());
                                            System.out.println("-----------------------");
                                        }
                                    } else {
                                        System.out.println("No hay usuarios registrados en este momento.");
                                    }
                                    break;
                                case 7:
                                    // Aceptar préstamo
                                    // Lógica para aceptar préstamo...
                                    break;
                                case 8:
                                    // Denegar préstamo
                                    // Lógica para denegar préstamo...
                                    break;
                                case 0:
                                    // Cerrar sesión del administrador
                                    System.out.println("Sesión de administrador cerrada.");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                            }

                            if (opcionAdmin == 0) {
                                break; // Salir del bucle después de cerrar sesión
                            }
                        }
                    } else {
                        System.out.println("Inicio de sesión de administrador fallido. Datos incorrectos.");
                    }
                    break;
                case 3:
                    // Registrarse
                    System.out.println("Ingrese los detalles para el registro:");
                    System.out.println("Nombre:");
                    String nombreRegistro = scanner.nextLine();
                    System.out.println("Apellido:");
                    String apellidoRegistro = scanner.nextLine();
                    System.out.println("Nombre de Usuario:");
                    String nombreUsuarioRegistro = scanner.nextLine();
                    System.out.println("Contraseña:");
                    String contrasenaRegistro = scanner.nextLine();
                    System.out.println("Correo Electrónico:");
                    String correoRegistro = scanner.nextLine();
                    System.out.println("Número de Teléfono:");
                    String telefonoRegistro = scanner.nextLine();
                    System.out.println("Fecha de Registro:");
                    String fechaRegistro = scanner.nextLine();

                    // En el bucle principal, donde se registra un nuevo usuario
                    Usuario nuevoUsuario = usuarioFactory.crearUsuario(nombreRegistro, apellidoRegistro,
                            1, nombreUsuarioRegistro, contrasenaRegistro, correoRegistro, telefonoRegistro, fechaRegistro);

                    biblioteca.registrarUsuario(nuevoUsuario);

                    System.out.println("Registro exitoso.");
                    break;
                case 0:
                    // Salir del programa
                    biblioteca.guardarInformacionTXT();  // Guardar información al salir
                    System.out.println("¡Adiós!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
}