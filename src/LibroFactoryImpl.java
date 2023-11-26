package src;

class LibroFactoryImpl implements LibroFactory {
    @Override
    public Libro crearLibro(String titulo, String[] autores, String isbn, String genero,
                            String editorial, int anoPublicacion, int numPaginas, String idioma) {
        return new Libro(titulo, autores, isbn, genero, editorial, anoPublicacion, numPaginas, idioma);
    }
}
