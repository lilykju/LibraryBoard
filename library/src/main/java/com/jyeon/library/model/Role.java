package com.jyeon.library.model;

import lombok.Getter;

@Getter
public enum Role {
    ROLE_ADMIN("ADMIN"), ROLE_USER("USER"), ALL("ALL");

    Role(String role) {
    }
}
