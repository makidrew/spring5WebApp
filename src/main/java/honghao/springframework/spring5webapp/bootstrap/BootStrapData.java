package honghao.springframework.spring5webapp.bootstrap;

import honghao.springframework.spring5webapp.domain.Author;
import honghao.springframework.spring5webapp.domain.Book;
import honghao.springframework.spring5webapp.domain.Publisher;
import honghao.springframework.spring5webapp.repositories.AuthorRepository;
import honghao.springframework.spring5webapp.repositories.BookRepository;
import honghao.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","3939459459");
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books： " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
