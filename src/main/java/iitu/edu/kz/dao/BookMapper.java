package iitu.edu.kz.dao;

import iitu.edu.kz.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setReleaseYear(resultSet.getInt("release_year"));
        book.setPerson_id(resultSet.getInt("person_id"));
        return book;
    }
}
