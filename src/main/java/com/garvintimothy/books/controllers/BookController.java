package com.garvintimothy.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garvintimothy.books.models.Book;
import com.garvintimothy.books.services.BookService;

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
}
