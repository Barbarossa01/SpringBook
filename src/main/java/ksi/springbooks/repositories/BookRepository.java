package ksi.springbooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ksi.springbooks.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByOrderByIdbDesc();

    List<Book> findByOrderByTitleAsc();

    List<Book> findByOrderByPublisherNameDesc();

    List<Book> findByOrderByPublisherNameAscTitleAsc();

    @Query("SELECT b FROM Book b ORDER BY b.title ASC")
    List<Book> findAllByTitleNativeSQL();
}
