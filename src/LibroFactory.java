package src;

// Patrón de diseño Factory para la creación de libros
interface LibroFactory {
    Libro crearLibro(String titulo, String[] autores, String isbn, String genero,
                     String editorial, int anoPublicacion, int numPaginas, String idioma);
}
