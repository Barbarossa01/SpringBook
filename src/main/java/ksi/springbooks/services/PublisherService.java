package ksi.springbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksi.springbooks.models.Publisher;
import ksi.springbooks.repositories.PublisherRepository;

@Service
public class PublisherService {

    private final PublisherRepository repository;

    @Autowired
    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public List<Publisher> findAll() {
        return repository.findAll();
    }
    
    
    public Publisher save(Publisher publisher) {
        return repository.save(publisher);
    }
    
    
    public Optional<Publisher> findById(Long idp) {
        return repository.findById(idp);
    }
    
    public void deleteById(Long idp) {
        repository.deleteById(idp);
    }
    
    
    public void update(Long idp, Publisher publisher) {
        publisher.setIdp(idp);  
        repository.save(publisher);
    }
}
	