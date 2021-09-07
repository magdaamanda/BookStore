package syksy2021.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy2021.BookStore.domain.Book;
import syksy2021.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return(args) -> {
			System.out.println("save a couple of books");
			repository.save(new Book("Potter1", "Kirjoittaja1", "1980", "4673", 129.0));
			repository.save(new Book("Potter2", "Kirjoittaja2", "1989", "4655", 179.0));
			
			System.out.println("fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
