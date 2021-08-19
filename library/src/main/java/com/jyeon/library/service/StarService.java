package com.jyeon.library.service;

import com.jyeon.library.dto.StarDto;
import com.jyeon.library.model.Book;
import com.jyeon.library.model.Star;
import com.jyeon.library.model.User;
import com.jyeon.library.repository.StarRepository;
import com.jyeon.library.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StarService {

    private final StarRepository starRepository;
    private final UserRepository userRepository;

    public StarService(StarRepository starRepository, UserRepository userRepository) {
        this.starRepository = starRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Star save(StarDto starDto) {

        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new UsernameNotFoundException("Wrong User Email."));

        Star star = Star.builder()
                .bookSeq(starDto.getBookSeq())
                .userSeq(user.getSeq())
                .point(starDto.getPoint())
                .createAt(LocalDateTime.now())
                .build();

        return starRepository.save(star);
    }

    @Transactional
    public Optional<List<Star>> getStarListOfUser(Long userSeq) {
        return starRepository.findByUserSeq(userSeq);
    }
}
