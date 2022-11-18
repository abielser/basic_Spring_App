package guru.springframework.spring5Webapp.controllers;

import guru.springframework.spring5Webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;


public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }
        @RequestMapping("/authors")
        public String getAuthors(Model model) {
            model.addAttribute("authors",authorRepository.findAll());

            return "authors/list";


        }

}
