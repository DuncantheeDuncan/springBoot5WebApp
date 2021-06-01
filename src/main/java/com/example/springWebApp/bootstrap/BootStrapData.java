package com.example.springWebApp.bootstrap;

import com.example.springWebApp.domain.Author;
import com.example.springWebApp.domain.Book;
import com.example.springWebApp.domain.Publisher;
import com.example.springWebApp.reporsitories.AuthorRepository;
import com.example.springWebApp.reporsitories.BookRepository;
import com.example.springWebApp.reporsitories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric","Evans");
        Book book = new Book("My new Book is..","HBK-998-7676");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);



        Publisher publisher = new Publisher();
        publisher.setName("Phumlani");
        publisher.setAddressLine("Strong way");
        publisher.setCity("Capetown");
        publisher.setState("Western cape");;
        publisher.setZip(117);
        publisherRepository.save(publisher);
        System.out.println("publisher "+publisherRepository.count());

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);



        Author rod = new Author("Rod","Johnson");
        Book book1 = new Book("Java EE Spring boot","HBY-65456-765");
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book1);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        publisherRepository.save(publisher);



        System.out.println("number of book: "+ bookRepository.count());
        System.out.println("publisher bok "+ publisher.getBooks().size());


    }
}
