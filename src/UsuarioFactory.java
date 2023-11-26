package src;

// Patrón de diseño Factory para la creación de usuarios
interface UsuarioFactory {
    Usuario crearUsuario(String nombre, String apellido, int idUsuario,
                         String nombreUsuario, String contrasena, String correoElectronico,
                         String numeroTelefono, String fechaRegistro);
}
