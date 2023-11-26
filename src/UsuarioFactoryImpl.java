package src;

class UsuarioFactoryImpl implements UsuarioFactory {

    @Override
    public Usuario crearUsuario(String nombre, String apellido, int idUsuario,
                                String nombreUsuario, String contrasena, String correoElectronico,
                                String numeroTelefono, String fechaRegistro) {
        return new Usuario(nombre, apellido, idUsuario, nombreUsuario, contrasena,
                correoElectronico, numeroTelefono, fechaRegistro);
    }
}
