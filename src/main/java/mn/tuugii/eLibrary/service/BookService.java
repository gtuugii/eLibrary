package mn.tuugii.eLibrary.service;

import mn.tuugii.eLibrary.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book save(Book book);
    Book findOne(Long id);
    void delete(Long id);

}
