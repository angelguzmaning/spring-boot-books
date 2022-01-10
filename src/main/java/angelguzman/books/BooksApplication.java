package angelguzman.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BooksApplication {

  Book[] books = {
      new Book(1, "The first book", "")
  };

  public static void main(String[] args) {
    SpringApplication.run(BooksApplication.class, args);
  }

  @GetMapping("/books")
  public Book[] getBooks() {
    return books;
  }

}
