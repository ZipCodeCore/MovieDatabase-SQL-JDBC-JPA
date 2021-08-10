INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Lavalantula', 83, 'Horror', 4.7, 'TV-14');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Waltz With Bashir', 90, 'Documentary', 8.0, 'R');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Spaceballs', 96, 'Comedy', 7.1, 'PG');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Monster Inc.', 92, 'Animation', 8.1, 'G');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Pineapple Express', 120, 'Documentary', 9.9, 'R');
INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES ('Wallys World', 15, 'Horror', 3.0, 'PG-13');

SELECT * FROM movies;
SELECT * FROM movies WHERE genre = 'Sci-Fi';
SELECT * FROM movies WHERE imdb_score >= 6.5;
SELECT * FROM movies WHERE runtime < 100 AND rating IN ('G', 'PG');

SELECT AVG(runtime) as runtime FROM movies WHERE imdb_score < 7.5 GROUP BY GENRE;

UPDATE movies SET rating = 'R' WHERE title = 'Starship Troopers';
SELECT id, rating FROM movies WHERE genre IN ('Documentary', 'Horror');
SELECT genre, AVG(imdb_score) AS Average, MIN(imdb_score) AS Min, MAX(imdb_score) AS Max FROM movies GROUP BY genre;
SELECT COUNT(rating) FROM movies HAVING COUNT(rating) > 1;
DELETE * FROM movies WHERE rating = 'R';


