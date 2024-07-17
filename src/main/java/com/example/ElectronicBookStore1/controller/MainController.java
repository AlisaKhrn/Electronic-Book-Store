package com.example.ElectronicBookStore1.controller;
import com.example.ElectronicBookStore1.model.Book;
import com.example.ElectronicBookStore1.model.Person;
import com.example.ElectronicBookStore1.services.BookService;
import com.example.ElectronicBookStore1.services.CartService;
import com.example.ElectronicBookStore1.services.PersonService;
import com.example.ElectronicBookStore1.util.BookValidator;
import com.example.ElectronicBookStore1.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    private final BookService bookService;
    private final PersonService personService;
    private final BookValidator bookValidator;
    private final PersonValidator personValidator;

    @Autowired
    public MainController(BookService bookService, PersonService personService, CartService cartService, BookValidator bookValidator, PersonValidator personValidator) {
        this.bookService = bookService;
        this.personService = personService;
        this.bookValidator = bookValidator;
        this.personValidator = personValidator;
    }


    @GetMapping("/")
    public String listOfBooks(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "bookList";
    }


    @GetMapping("/{id}")
    public String showBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "book";
    }


    @GetMapping("employee/add-book")
    public String addBook(@ModelAttribute("book") Book book){
        return "addBook";
    }


    @PostMapping
    public String createBook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "addBook";
        model.addAttribute("postCorrect", true);
        model.addAttribute("book", new Book());
        bookService.save(book);
        return "redirect:/";
    }


    @PostMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/";
    }


    @GetMapping("/cart")
    public String showCartPage() {
        return "cart";
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute Person person){
        return "registrationPage";
    }

    @PostMapping("/process_registration")
    public String registrationPerson(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "registrationPage";
        personService.save(person);
        return "redirect:/login?registration";
    }
}