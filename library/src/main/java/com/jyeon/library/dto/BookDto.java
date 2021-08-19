package com.jyeon.library.dto;

import com.jyeon.library.model.Classification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String publisher;

    @NotNull
    private String description;

    @NotNull
    private Classification classification;

    @NotNull
    private LocalDateTime publishingDate;

    @NotNull
    private LocalDateTime receivingDate;
}
