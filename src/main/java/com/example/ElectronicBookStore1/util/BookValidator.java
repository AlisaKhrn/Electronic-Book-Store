package com.example.ElectronicBookStore1.util;

import com.example.ElectronicBookStore1.model.Book;
import com.example.ElectronicBookStore1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import static com.example.ElectronicBookStore1.services.URLService.checkURL;

@Component
public class BookValidator implements Validator {
    private final BookService bookService;

    @Autowired
    public BookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (!checkURL(book.getUrl()))
            errors.rejectValue("url", "", "Неверный url");
    }
}
