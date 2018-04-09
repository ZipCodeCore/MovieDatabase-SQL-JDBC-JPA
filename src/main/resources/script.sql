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


