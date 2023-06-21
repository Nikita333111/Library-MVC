package iitu.edu.kz.dao;

import iitu.edu.kz.models.Book;
import iitu.edu.kz.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BookDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Book> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Transactional
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();

        session.save(book);
    }

    @Transactional(readOnly = true)
    public Book show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class,id);
    }

    @Transactional
    public void update(int id, Book book) {
        Session session = sessionFactory.getCurrentSession();

        Book bookToUpdate = session.get(Book.class,id);
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setReleaseYear(book.getReleaseYear());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        /*Book book = session.get(Book.class,id);
        Person person = book.getPerson();
        person.getBooks().remove(book);
        */
        session.remove(session.get(Book.class,id));
    }


    @Transactional
    public void setPersonBook(int personId,int bookId){
        Session session = sessionFactory.getCurrentSession();

        Person person = session.load(Person.class,personId);
        Book book = session.get(Book.class,bookId);

        book.setPerson(person);
    }

    @Transactional
    public void releaseBook(int id){
        Session session = sessionFactory.getCurrentSession();

        Book book = session.get(Book.class, id);
        Person person = session.get(Person.class,book.getPerson().getId());

        person.getBooks().remove(book);
        book.setPerson(null);
    }
}
