INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES
('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG'),
('Lavalantula', 83, 'Horror', 4.7, 'TV-14'),
('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13'),
('Waltz With Bashir',90,'Documentary',8.0,'R'),
('Spaceballs', 96, 'Comedy', 7.1,'PG'),
('Monsters Inc.', 92, 'Animation', 8.1, 'G');

INSERT INTO movies (title, runtime, genre, imdb_score, rating) VALUES
('Zardoz', 105, 'Sci-Fi', 5.8, 'R'),
('The Room', 99, 'Comedy', 3.6, 'R'),
('Mad Max: Fury Road', 120, 'Action', 8.1, 'R');

SELECT * FROM movies WHERE genre = 'Sci-Fi';
SELECT * FROM movies WHERE imdb_score >= 6.5;
SELECT * FROM movies WHERE rating in ('G','PG') AND runtime <100;
SELECT AVG(runtime) average_runtime, genre FROM movies WHERE imdb_score <7.5 GROUP BY genre;
UPDATE movies SET rating='R' WHERE title = 'Starship Troopers';
SELECT id, rating FROM movies WHERE genre IN ('Documentary','Horror');
SELECT AVG(imdb_score),  MIN(imdb_score),  MAX(imdb_score), rating FROM movies GROUP BY rating;
SELECT AVG(imdb_score),  MIN(imdb_score),  MAX(imdb_score), rating FROM movies GROUP BY rating HAVING COUNT(*)>1;
DELETE FROM movies WHERE rating = 'R';




