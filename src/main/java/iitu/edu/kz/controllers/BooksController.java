package iitu.edu.kz.controllers;

import iitu.edu.kz.dao.BookDAO;
import iitu.edu.kz.dao.PersonDAO;
import iitu.edu.kz.models.Book;
import iitu.edu.kz.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", personDAO.index());
        model.addAttribute("book", bookDAO.show(id));
        model.addAttribute("human", personDAO.show(bookDAO.show(id).getPerson_id()));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book){
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("book",bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable int id){
        bookDAO.update(id,book);
        return "redirect:/books";
    }

    @PatchMapping("/assign/{bookId}")
    public String assignBook(@ModelAttribute("person") Person person, @PathVariable int bookId){
        bookDAO.setPersonBook(person.getId(),bookId);
        return "redirect:/books/" + bookId;
    }

    @GetMapping("/release/{id}")
    public String releaseBook(@PathVariable int id){
        bookDAO.releaseBook(id);
        return "redirect:/books/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
