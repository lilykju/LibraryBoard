package com.jyeon.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
public class StarDto {

    @NotNull
    private Long bookSeq;

    @NotNull
    private int point;
}
