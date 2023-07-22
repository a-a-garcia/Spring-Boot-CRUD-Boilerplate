package com.anthonygarcia.crudboilerplate.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.anthonygarcia.crudboilerplate.models.Book;
import com.anthonygarcia.crudboilerplate.repositories.BookRepository;

@Service
public class BookService {
	    // adding the book repository as a dependency
	    private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // update a book - it's the same as create, however if a primary key already exists, it will update instead of create.
	    public Book updateBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    // delete a book
	    public void deleteBook(Long id) {
	    	bookRepository.deleteById(id);
	    }
	    //will return any books that contain the "search" string.
	    public List<Book> booksContaining(String search) {
	    	return bookRepository.findByDescriptionContaining(search);
	}


}
