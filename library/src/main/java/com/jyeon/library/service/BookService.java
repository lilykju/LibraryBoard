package com.jyeon.library.service;

import com.jyeon.library.dto.BookDto;
import com.jyeon.library.dto.StarDto;
import com.jyeon.library.model.Book;
import com.jyeon.library.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public static final int PAGE_SIZE = 10;

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Page<Book> list(Pageable pageable) {
        //PageRequest.of(pageNum, PAGE_SIZE, Sort.by("createAt").descending())
        return bookRepository.findAll(pageable);
    }

    @Transactional
    public Optional<Book> findOne(Long seq) {
        return bookRepository.findById(seq);
    }

    @Transactional
    public Book save(BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .description(bookDto.getDescription())
                .classification(bookDto.getClassification())
                .totStarPoint(0L)
                .totStarCount(0)
                .publishingDate(bookDto.getPublishingDate())
                .receivingDate(bookDto.getReceivingDate())
                .createAt(LocalDateTime.now())
                .build();

        return bookRepository.save(book);
    }

    @Transactional
    public void updateStar(StarDto starDto) {
        Book book = bookRepository.findById(starDto.getBookSeq()).orElseThrow(() -> new RuntimeException("Wrong Book id : " + starDto.getBookSeq()));

        bookRepository.updateStar(starDto.getBookSeq(), book.getTotStarPoint() + starDto.getPoint(), book.getTotStarCount() + 1);
    }

}
