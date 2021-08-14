INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG'),
       ('Lavalantula', 83, 'Horror', 4.7, 'TV-14'),
       ('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13'),
       ('Waltz With Bashir', 90, 'Documentary', 8.0, 'R'),
       ('Spaceballs', 96, 'Comedy', 7.1, 'PG'),
       ('Monsters Inc.', 92, 'Animation', 8.1, 'G');



SELECT * FROM movies

SELECT * FROM MOVIES WHERE imdb_score >= 6.

SELECT * FROM movie WHERE (rating = 'G' OR rating = 'PG') AND runtime < 100;

SELECT AVG(RUNTIME) AS AVG_RUNTIME, genre FROM MOVIES WHERE imdb_score < 7.5 GROUP BY genre;

UPDATE movies SET rating = 'R' WHERE runtime=129;

SELECT id, rating FROM movies WHERE genre = 'Horror' OR genre = 'Documentary';

SELECT rating, AVG(imdb_score), MIN(imdb_score), MAX(imdb_score) from movies GROUP BY rating;

SELECT rating, AVG(imdb_score), MIN(imdb_score), MAX(imdb_score) from movies GROUP BY rating HAVING COUNT(*) > 1;

DELETE FROM movie where rating = 'R';