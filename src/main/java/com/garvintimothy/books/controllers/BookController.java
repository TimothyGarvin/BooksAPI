package com.garvintimothy.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garvintimothy.books.models.Book;
import com.garvintimothy.books.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	@RequestMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		model.addAttribute("book", bookService.findBook(bookId));
		return "show.jsp";
	}
	
	@RequestMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@PostMapping("/books")
	public String create(
	    @Valid @ModelAttribute("book") Book book,
	    BindingResult result){
		if(result.hasErrors()) {
			return "new.jsp";
		}
	
	{
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	    bookService.createBook(book);
	    return "redirect:/books";
	}
}
}
