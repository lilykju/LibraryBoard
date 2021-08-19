DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS stars CASCADE;

CREATE TABLE users
(
    seq          bigint      NOT NULL AUTO_INCREMENT,
    email       varchar(100) NOT NULL,
    password    varchar(200) NOT NULL,
    name        varchar(50) NOT NULL,
    authority   enum ('ROLE_ADMIN', 'ROLE_USER') NOT NULL,
    phone       varchar(50) NOT NULL,
    join_at   datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (seq),
    UNIQUE KEY unique_email (email)
);

CREATE TABLE books
(
    seq             bigint          NOT NULL AUTO_INCREMENT,
    title           varchar(50)     NOT NULL,
    author          varchar(50)     NOT NULL,
    publisher       varchar(50)     NOT NULL,
    description     varchar(200)    NOT NULL,
    classification  enum ('GENERAL', 'SCIENCE', 'ART', 'LITERATURE', 'HISTORY') NOT NULL,
    tot_star_pnt    bigint  DEFAULT 0 NOT NULL,
    tot_star_cnt    int     DEFAULT 0 NOT NULL,
    publishing_date datetime        NOT NULL,
    receiving_date  datetime        NOT NULL,
    create_at       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (seq)
);

CREATE TABLE stars
(
    seq             bigint      NOT NULL AUTO_INCREMENT,
    book_seq        bigint      NOT NULL,
    user_seq        bigint      NOT NULL,
    point           int         NOT NULL,
    create_at       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (seq),
    CONSTRAINT fk_stars_to_books FOREIGN KEY (book_seq) REFERENCES books (seq) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_stars_to_users FOREIGN KEY (user_seq) REFERENCES users (seq) ON DELETE RESTRICT ON UPDATE RESTRICT
);