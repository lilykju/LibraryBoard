INSERT INTO USERS (email, password, name, authority, phone) VALUES ('aaa@aaaa.aaa', '$2a$10$OcHYKtOhGjw2cUWgzlUCKu6wwPIbHAqkYh06hNoXYyaxwI1soJnnC', 'administartor', 'ROLE_ADMIN','010-1111-1111'); --password : aaa

INSERT INTO BOOKS (title, author, publisher, description, classification, tot_star_pnt, tot_star_cnt, publishing_date, receiving_date)
VALUES  ('title1', 'author1', 'poublisher1', 'description1', 'GENERAL', 0,0, '2021-06-01 23:45:00', '2021-06-01 23:45:00'),
        ('title2', 'author2', 'poublisher2', 'description2', 'ART', 0,0, '2021-06-01 23:45:00', '2021-06-01 23:45:00')
;

