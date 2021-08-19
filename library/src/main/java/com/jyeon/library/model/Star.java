package com.jyeon.library.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stars")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "book_seq")
    private Long bookSeq;

    @Column(name = "user_seq")
    private Long userSeq;

    @Column(name = "point")
    private int point;

    @Column(name = "create_at")
    private LocalDateTime createAt;

}
