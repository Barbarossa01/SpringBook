package ksi.springbooks.services;

import ksi.springbooks.models.Book;
import ksi.springbooks.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

	public <S extends Book> S save(S entity) {
		return repository.save(entity);
	}

	public List<Book> findAll() {
		return repository.findAll();
	}

	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
	public List<Book> findAllSortedByTitle() {
	    return repository.findByOrderByTitleAsc();
	}

    public List<Book> findAllSortedById() {
        return repository.findByOrderByIdbDesc();
    }

    public List<Book> findAllSortedByPublisherDesc() {
        return repository.findByOrderByPublisherNameDesc();
    }

    public List<Book> findAllSortedByPublisherAndTitle() {
        return repository.findByOrderByPublisherNameAscTitleAsc();
    }

    public List<Book> findAllSortedByTitleNative() {
        return repository.findAllByTitleNativeSQL();
    }

    // Service methods
}
