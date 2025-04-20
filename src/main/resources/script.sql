INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (DEFAULT, 'Howard the Duck', '110','Sci-Fi', '4.6', 'PG');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (DEFAULT, 'Lavalantula', '83','Horror', '4.7', 'TV-14');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (DEFAULT, 'Starship Trooper', '129', 'Sci-Fi', '7.2', 'PG-13');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (DEFAULT, 'Waltz With Bashir', '90', 'Documentary', '8.0', 'R');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (DEFAULT, 'Spaceballs', '96', 'Comedy', '7.1', 'PG');
INSERT INTO movies (id, title, runtime, genre, imdb_score, rating) VALUES (DEFAULT, 'Monsters Inc.', '92', 'Animation', '8.1', 'G');

SELECT * FROM movies WHERE genre='Sci-Fi';

SELECT * FROM movies WHERE  imdb_score > 6.5;

SELECT * FROM movies WHERE rating='G' OR rating='PG' AND runtime < 100;

SELECT genre, AVG(runtime) FROM movies WHERE imdb_score <= 7 GROUP BY genre;

UPDATE movies SET rating='R' WHERE title='Starship Troopers';

SELECT id, rating FROM movies WHERE genre='Horror' OR genre='Documentary';

SELECT AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM movies GROUP BY rating;

SELECT AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM movies GROUP BY rating HAVING COUNT(*) > 1;

DELETE FROM movies WHERE rating='R';
