package blackfire.springframework.spring5webapp.bootstrap;

import blackfire.springframework.spring5webapp.domain.Author;
import blackfire.springframework.spring5webapp.domain.Books;
import blackfire.springframework.spring5webapp.repositories.AuthorRepository;
import blackfire.springframework.spring5webapp.repositories.BooksRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BooksRepository booksRepository;

    public BootstrapData(AuthorRepository authorRepository, BooksRepository booksRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) {

        Author eric = new Author("Eric", "Evans");
        Books ddd = new Books("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        booksRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Books noEJB = new Books("J2EE Development Without EJB", "398398398");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        booksRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books : " + booksRepository.count());
    }
}
