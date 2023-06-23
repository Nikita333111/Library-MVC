package iitu.edu.kz.repositories;

import iitu.edu.kz.models.Book;
import iitu.edu.kz.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    public List<Book> findBooksByTitleStartsWith(String name);
}
