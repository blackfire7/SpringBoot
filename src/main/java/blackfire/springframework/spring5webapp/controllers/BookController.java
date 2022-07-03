package blackfire.springframework.spring5webapp.controllers;

import blackfire.springframework.spring5webapp.repositories.BooksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BooksRepository booksRepository;

    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(value = "/books")
    public String getBooks(Model model) {
        
        model.addAttribute("Books", booksRepository.findAll());

        return "books";
    }
}
