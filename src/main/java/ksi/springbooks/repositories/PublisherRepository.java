package ksi.springbooks.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ksi.springbooks.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findAll(Sort sort);
}
