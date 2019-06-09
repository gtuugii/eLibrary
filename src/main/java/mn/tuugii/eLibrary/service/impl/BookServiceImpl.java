package mn.tuugii.eLibrary.service.impl;

import mn.tuugii.eLibrary.domain.Book;
import mn.tuugii.eLibrary.repository.BookRepository;
import mn.tuugii.eLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
