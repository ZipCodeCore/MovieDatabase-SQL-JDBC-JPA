INSERT INTO movies VALUES(1, 'Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
INSERT INTO movies VALUES(2, 'Lavalantula', 83, 'Horror', 4.7, 'TV-14');
INSERT INTO movies VALUES(3, 'Starship Troopers', 129, 'Sci-Fi', 4.7, 'PG-13');
INSERT INTO movies VALUES(4, 'Waltz With Bashir', 90, 'Documentary', 4.7, 'R');
INSERT INTO movies VALUES(5, 'Spaceballs', 96, 'Comedy', 4.7, 'PG');
INSERT INTO movies VALUES(6, 'Monsters Inc.', 92, 'Animation', 4.7, 'G');

SELECT * FROM movies WHERE genre='Sci-Fi';

SELECT * FROM movies WHERE imdb_score >= 6.5;

SELECT * FROM movies WHERE rating = 'G' OR rating = 'PG' AND runtime < 100;

SELECT AVG(runtime) FROM movies WHERE imdb_score < 7.5 GROUP BY genre;

UPDATE movies SET rating = 'R' WHERE title = 'Starship Troopers';

SELECT id, rating FROM movies WHERE genre = 'Horror' OR genre = 'Documentary';

SELECT AVG(imdb_score), MIN(imdb_score), MAX(imdb_score) FROM movies GROUP BY rating;

SELECT AVG(imdb_score), MIN(imdb_score), MAX(imdb_score) FROM movies GROUP BY rating HAVING COUNT(*) > 1;

DELETE FROM movies WHERE rating = 'R';