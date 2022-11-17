package guru.springframework.spring5Webapp.bootstrap;

import guru.springframework.spring5Webapp.damain.Author;
import guru.springframework.spring5Webapp.damain.Book;
import guru.springframework.spring5Webapp.repositories.AuthorRepository;
import guru.springframework.spring5Webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "345621513");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        authorRepository.save(rod);
        Book save = bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books"+bookRepository.count());


    }
}
