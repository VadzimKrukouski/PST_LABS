CREATE TABLE directors
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    age  INT                   NULL,
    CONSTRAINT pk_directors PRIMARY KEY (id)
);

CREATE TABLE films
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    director_id   BIGINT                NULL,
    CONSTRAINT pk_films PRIMARY KEY (id)
);

ALTER TABLE films
    ADD CONSTRAINT FK_FILMS_ON_DIRECTOR FOREIGN KEY (director_id) REFERENCES directors (id);

CREATE TABLE genres
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255)          NULL,
    film_id BIGINT                NULL,
    CONSTRAINT pk_genres PRIMARY KEY (id)
);

ALTER TABLE genres
    ADD CONSTRAINT FK_GENRES_ON_FILM FOREIGN KEY (film_id) REFERENCES films (id);



