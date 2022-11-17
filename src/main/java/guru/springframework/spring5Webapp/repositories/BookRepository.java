package guru.springframework.spring5Webapp.repositories;

import guru.springframework.spring5Webapp.damain.Book;
import org.springframework.data.repository.CrudRepository;




public interface BookRepository extends CrudRepository<Book, Long> {
}
