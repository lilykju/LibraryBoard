package com.jyeon.library.repository;

import com.jyeon.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    //Optional<List<Book>> findByTitle(String title);
    //Optional<List<Book>> findBySearch();

    @Modifying(clearAutomatically = true)
    @Query(value= "UPDATE books b SET b.tot_star_pnt = :point, b.tot_star_cnt = :count WHERE b.seq = :seq", nativeQuery = true)
    void updateStar(@Param("seq")Long seq, @Param("point")Long totStarPoint, @Param("count")int totStarCount);

}
