package Project.Bookstore.Repository;

import Project.Bookstore.Data.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByIdAndDeleted(Integer id, Boolean deleted);
    List<Book> findAllByDeleted(Boolean deleted);
}
