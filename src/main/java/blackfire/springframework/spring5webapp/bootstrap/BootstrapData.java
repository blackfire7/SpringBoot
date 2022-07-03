package blackfire.springframework.spring5webapp.bootstrap;

import blackfire.springframework.spring5webapp.domain.Author;
import blackfire.springframework.spring5webapp.domain.Books;
import blackfire.springframework.spring5webapp.domain.Publisher;
import blackfire.springframework.spring5webapp.repositories.AuthorRepository;
import blackfire.springframework.spring5webapp.repositories.BooksRepository;
import blackfire.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BooksRepository booksRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BooksRepository booksRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publisher");
        publisher.setCity("Mumbai");
        publisher.setState("Maharashtra");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count : " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Books ddd = new Books("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        booksRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Books noEJB = new Books("J2EE Development Without EJB", "398398398");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        booksRepository.save(noEJB);
        publisherRepository.save(publisher);
        
        System.out.println("Number of Books : " + booksRepository.count());
        System.out.println("Publisher Number of Books : " + publisher.getBooks().size());
    }
}
