INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Lavalantula', 83, 'Horror', 4.7, 'TV-14');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Waltz With Bashir', 90, 'Documentary', 8.0, 'R');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Spaceballs', 96, 'Comedy', 7.1, 'PG');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Monsters Inc.', 92, 'Animation', 8.1, 'G');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('2001: A Space Odyssey', 149, 'Sci-Fi', 8.3, 'G');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Blade Runner 2049', 164, 'Sci-Fi', 8.2, 'R');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Mad Max: Fury Road', 120, 'Action', 8.1, 'R');
INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES('Titanic', 194, 'Romance', 7.8, 'PG-13');

SELECT * FROM movies;

SELECT title FROM movies
WHERE genre = 'Sci-Fi';

SELECT title FROM movies
WHERE imdb_score >= 6.5;

SELECT title FROM movies
WHERE rating = 'G' OR rating = 'PG'
AND runtime < 100;

SELECT AVG(runtime) AS AverageRunTime
FROM movies
WHERE imdb_score < 7.5
GROUP BY genre;

UPDATE movies
SET rating = 'R'
WHERE title = 'Starship Troopers';

SELECT id, rating FROM movies
WHERE genre = 'Horror' OR genre = 'Documentary';

SELECT rating, AVG(imdb_score) as avgIMDB, MAX(imdb_score) as maxIMDB, MIN(imdb_score) as minIMDB
FROM movies
GROUP BY rating;

SELECT rating, AVG(imdb_score) as avgIMDB, MAX(imdb_score) as maxIMDB, MIN(imdb_score) as minIMDB
FROM movies
GROUP BY rating
HAVING COUNT(*) > 1;

DELETE FROM movies
WHERE rating = 'R';