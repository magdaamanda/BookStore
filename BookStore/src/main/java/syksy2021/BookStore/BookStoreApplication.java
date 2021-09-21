package syksy2021.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy2021.BookStore.BookStoreApplication;
import syksy2021.BookStore.domain.Book;
import syksy2021.BookStore.domain.BookRepository;
import syksy2021.BookStore.domain.Category;
import syksy2021.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository srepository, CategoryRepository drepository) {
		return(args) -> {
			System.out.println("save a couple of books");
			drepository.save(new Category("Thrillers"));
			drepository.save(new Category("Novels"));
			drepository.save(new Category("Children"));
			
			srepository.save(new Book("Potter1", "Kirjoittaja1", "1980", "4673", 129.0, drepository.findByName("Children").get(0)));
			srepository.save(new Book("Potter2", "Kirjoittaja2", "1989", "4655", 179.0, drepository.findByName("Novels").get(0)));
			
			System.out.println("fetch all books");
			for (Book book : srepository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
