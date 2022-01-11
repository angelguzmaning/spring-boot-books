package angelguzman.books;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BooksApplication {

  List<Book> books;
  int lastBook;

  public static void main(String[] args) {
    SpringApplication.run(BooksApplication.class, args);
  }

  public BooksApplication() {
    books = new ArrayList<Book>();
    books.add(new Book(1, "The first book", "3422-3"));
    books.add(new Book(2, "The second book", "4333-8"));
    lastBook = books.size();
  }

  @PostMapping("/books")
  public Book createBook(@RequestBody NewBook newBook) {
    books.add(new Book(++lastBook, newBook.name, newBook.isbn));
    return books.get(books.size() - 1);
  }

  @GetMapping("/books")
  public List<Book> getBooks() {
    return books;
  }

  @PutMapping("/books/{id}")
  public Boolean updateBook(@PathVariable int id, @RequestBody NewBook newBook) {
    OptionalInt indexOpt = IntStream.range(0, books.size())
     .filter(i -> books.get(i).id == id)
     .findFirst();

    if(indexOpt.isEmpty()) return false;

    books.set(indexOpt.getAsInt(), new Book(id, newBook.name, newBook.isbn));
    return true;
  }

  @DeleteMapping("/books/{id}")
  public Boolean deleteBook(@PathVariable int id) {
    return books.removeIf(book -> book.id == id);
  }

}
