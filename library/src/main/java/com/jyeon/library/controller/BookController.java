package com.jyeon.library.controller;

import com.jyeon.library.dto.BookDto;
import com.jyeon.library.dto.StarDto;
import com.jyeon.library.model.Book;
import com.jyeon.library.service.BookService;
import com.jyeon.library.service.StarService;
import com.jyeon.library.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final StarService starService;
    private final UserService userService;

    public BookController(BookService bookService, StarService starService, UserService userService) {
        this.bookService = bookService;
        this.starService = starService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> list(@NotNull Pageable pageable) {
        //Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        return ResponseEntity.ok(bookService.list(pageable).getContent());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/{id}/star")
    public ResponseEntity<Book> saveStar(@PathVariable long id, @RequestParam(value = "point", defaultValue = "5") int point) {
        StarDto starDto = new StarDto(id, point);

        bookService.updateStar(starDto);
        starService.save(starDto);
        return ResponseEntity.ok(bookService.findOne(id).orElseThrow(() -> new RuntimeException("Wrong access")));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/post")
    public ResponseEntity<Book> save(@NotNull @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.save(bookDto));
    }

}
