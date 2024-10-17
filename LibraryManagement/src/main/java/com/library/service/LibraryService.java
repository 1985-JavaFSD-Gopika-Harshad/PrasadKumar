package com.library.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BorrowRequest;
import com.library.model.Book;
import com.library.model.BorrowRecord;
import com.library.model.Borrower;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRecordRepository;
import com.library.repository.BorrowerRepository;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
 // Method to add a new borrower
    public Borrower addBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    // Method to get all borrowers
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public void borrowBook(BorrowRequest request) {
        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        Borrower borrower = borrowerRepository.findById(request.getBorrowerId()).orElseThrow();

        if (book.isAvailable()) {
            book.setAvailable(false);
            BorrowRecord record = new BorrowRecord();
            record.setBook(book);
            record.setBorrower(borrower);
            record.setBorrowDate(LocalDate.now());
            borrowRecordRepository.save(record);
            bookRepository.save(book);
        }
    }

    public void returnBook(Long recordId) {
        BorrowRecord record = borrowRecordRepository.findById(recordId).orElseThrow();
        Book book = record.getBook();
        book.setAvailable(true);
        record.setReturned(true);
        record.setReturnDate(LocalDate.now());
        borrowRecordRepository.save(record);
        bookRepository.save(book);
    }
}
