package com.jyeon.library.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification")
    private Classification classification;

    @Column(name = "tot_star_pnt")
    private Long totStarPoint;

    @Column(name = "tot_star_cnt")
    private Integer totStarCount;

    @Column(name = "publishing_date")
    private LocalDateTime publishingDate;

    @Column(name = "receiving_date")
    private LocalDateTime receivingDate;

    @Column(name = "create_at")
    private LocalDateTime createAt;

}
