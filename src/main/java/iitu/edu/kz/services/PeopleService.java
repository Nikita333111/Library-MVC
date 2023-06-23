package iitu.edu.kz.services;

import iitu.edu.kz.models.Person;
import iitu.edu.kz.repositories.PeopleRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> person = peopleRepository.findById(id);
        Hibernate.initialize(person.get().getBooks());
        person.get().getBooks().forEach(book -> {
            long diffInMillis = Math.abs(new Date().getTime() - book.getDateOfTaking().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillis,TimeUnit.MILLISECONDS);
            System.out.println(diff);
            if(diff >= 10)
                book.setOverdue(true);
        });
        return person.orElse(null);
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.findById(id).ifPresent(person -> {
            person.getBooks().forEach(book -> book.setDateOfTaking(null));
        });
        peopleRepository.deleteById(id);
    }
}
