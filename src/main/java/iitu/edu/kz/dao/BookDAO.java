package iitu.edu.kz.dao;

import iitu.edu.kz.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title,author,release_year) VALUES (?,?,?)", book.getTitle(), book.getAuthor(), book.getReleaseYear());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BookMapper()).stream().findAny().orElse(null);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET title=?,author=?,release_year=? WHERE id=?", book.getTitle(), book.getAuthor(), book.getReleaseYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public List<Book> getPersonBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id}, new BookMapper());
    }

    public void setPersonBook(int personId,int bookId){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?",personId,bookId);
    }

    public void releaseBook(int id){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?",null,id);
    }
}
