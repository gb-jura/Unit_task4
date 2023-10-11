import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import BookService.BookService;

public class TestBookService {
    private BookService service;

    @Before
    public void setUp() {
        service = new BookService(mock(BookRepository.class));
    }

    @Test
    public void test_find_by_id() {
        int bookId = 3;
        service.find_by_id(bookId);
        verify(service.book_repository).find_by_id(bookId);
    }

    @Test
    public void test_find_all() {
        service.find_all();
        verify(service.book_repository).find_all();
    }
}