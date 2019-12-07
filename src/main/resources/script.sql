DROP TABLE IF EXISTS Movies;
CREATE TABLE Movies (
  id SERIAL NOT NULL,
  title VARCHAR(255),
  runtime INT,
  genre VARCHAR(45),
  imdb_score DECIMAL(2,1),
  rating VARCHAR(10),
  PRIMARY KEY(id)
);

INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Lavalantula', 83, 'Horror', 4.7, 'TV-14');
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Waltz With Bashir', 90, 'Documentary', 8.0, 'R');
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Space Balls', 96, 'Comedy', 7.1, 'PG');
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Monsters Inc.', 92, 'Animation', 8.1, 'G');
--1
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Cabin In The Woods', 95, 'Horror', 7.0, 'R');
INSERT INTO Movies (title, runtime, genre, imdb_score, rating) VALUES('Ford v Ferrari', 152, 'Drama', 8.3, 'PG-13');

--2
SELECT * FROM Movies WHERE genre = 'Sci-Fi';
--3
SELECT * FROM Movies WHERE imdb_score >= 6.5;
--4
SELECT * FROM Movies WHERE (rating = 'PG' OR
                           rating = 'G') AND
                           runtime < 100;
--5
SELECT genre, AVG(runtime) FROM Movies
WHERE imdb_score < 7.5
GROUP BY genre;
--6
UPDATE Movies SET rating = 'R'
WHERE title = 'Starship Troopers';
--7
SELECT id, rating FROM Movies WHERE genre = 'Documentary' OR genre = 'Horror';
--8
SELECT rating, AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM Movies
GROUP BY rating;
--9
SELECT rating, AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM Movies
GROUP BY rating
HAVING COUNT(*) > 1;