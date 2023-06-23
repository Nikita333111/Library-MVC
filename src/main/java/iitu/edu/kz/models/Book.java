package iitu.edu.kz.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "date_of_taking")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTaking;
    @Transient
    private boolean overdue = false;


    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Book(String title, String author, int releaseYear, Person person) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.person = person;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDateOfTaking() {
        return dateOfTaking;
    }

    public void setDateOfTaking(Date dateOfTaking) {
        this.dateOfTaking = dateOfTaking;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", taken at=" + dateOfTaking +
                '}';
    }
}
