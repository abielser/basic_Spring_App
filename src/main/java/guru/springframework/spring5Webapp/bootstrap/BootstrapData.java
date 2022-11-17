package guru.springframework.spring5Webapp.bootstrap;

import guru.springframework.spring5Webapp.damain.Author;
import guru.springframework.spring5Webapp.damain.Book;
import guru.springframework.spring5Webapp.damain.Publisher;
import guru.springframework.spring5Webapp.repositories.AuthorRepository;
import guru.springframework.spring5Webapp.repositories.BookRepository;
import guru.springframework.spring5Webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("QAf Publishing");
        publisher.setCity("San Lorenzo");
        publisher.setState("CA");

        publisherRepository.save(publisher);
        System.out.println("Publisher count :"+ publisherRepository.count());

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


        System.out.println("Number of Books"+bookRepository.count());


    }
}
