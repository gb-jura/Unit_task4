import java.util.ArrayList;
import java.util.List;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class BookRepository {
    private List<Book> books;

    public BookRepository(List<Book> books) {
        this.books = books;
        if (books == null) {
            this.books = new ArrayList<>();
        }
    }

    public Book findByID(int bookID) {
        for (Book book : books) {
            if (book.getId() == bookID) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        List<Book> copy = new ArrayList<>();
        for (Book book : books) {
            copy.add(new Book(book.getId(), book.getTitle(), book.getAuthor()));
        }
        return copy;
    }
}

class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public Book findByID(int bookID) {
        return bookRepository.findByID(bookID);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}