package iitu.edu.kz.dao;

import iitu.edu.kz.models.Book;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import iitu.edu.kz.models.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
public class PersonDAO {
   /* private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class,id);
        Hibernate.initialize(person.getBooks());

        return person;
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();

        session.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();

        Person personToBeUpdate = session.get(Person.class,id);
        personToBeUpdate.setFullName(updatedPerson.getFullName());
        personToBeUpdate.setAge(updatedPerson.getAge());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Person.class,id));
    }*/
}
