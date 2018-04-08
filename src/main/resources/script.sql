INSERT INTO movies (title, runtime, genre, imdb_score, rating)
VALUES ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG'),('Lavalantula', 83, 'Horror', 4.7, 'TV-14'),
('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13'), ('Waltz With Bashir', 90, 'Documentary', 8.0, 'R'), ('Monsters Inc.', 92, 'Animation', 8.1, 'G'),
('Spaceballs', 96, 'Comedy', 7.1, 'PG'),('Tombstone', 102, 'Western', 7.3, 'R'), ('Black Panther', 135, 'Superhero', 9.5, 'PG-13');

SELECT * FROM movies WHERE genre='Sci-Fi';

SELECT * FROM movies WHERE imdb_score > 6.5;

SELECT * FROM movies WHERE rating = 'G' OR rating = 'PG' AND runtime < 100;

SELECT AVG(runtime), genre FROM movies WHERE imdb_score < 7.5 GROUP BY genre;

UPDATE movies SET rating = 'R' WHERE title = 'Starship Troopers';

SELECT id, rating FROM movies WHERE genre='Horror' OR genre='Documentary';

SELECT genre, AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM movies GROUP BY genre;

SELECT genre, AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM movies GROUP BY genre HAVING COUNT(*) > 1;

DELETE FROM movies WHERE rating='R';