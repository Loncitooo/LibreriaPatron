package src;

// Clase Libro
class Libro {
    private String titulo;
    private String[] autores;
    private String isbn;
    private String genero;
    private String editorial;
    private int anoPublicacion;
    private int numPaginas;
    private String idioma;

    // Constructor privado para usar el patrón Factory
    Libro(String titulo, String[] autores, String isbn, String genero, String editorial,
          int anoPublicacion, int numPaginas, String idioma) {
        this.titulo = titulo;
        this.autores = autores;
        this.isbn = isbn;
        this.genero = genero;
        this.editorial = editorial;
        this.anoPublicacion = anoPublicacion;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
    }

    // Getter para el título del libro
    public String getTitulo() {
        return titulo;
    }

    // Otros getters para las propiedades del libro...

    // Método para mostrar información del libro
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autores: " + String.join(", ", autores));
        System.out.println("ISBN: " + isbn);
        System.out.println("Género: " + genero);
        System.out.println("Editorial: " + editorial);
        System.out.println("Año de Publicación: " + anoPublicacion);
        System.out.println("Número de Páginas: " + numPaginas);
        System.out.println("Idioma: " + idioma);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }

    public String getNumPaginas() {
        return String.valueOf(numPaginas);
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAnoPublicacion() {
        return String.valueOf(anoPublicacion);
    }

    public String[] getAutores() {
        return autores;
    }

    public String getIdioma() {
        return idioma;
    }
}
