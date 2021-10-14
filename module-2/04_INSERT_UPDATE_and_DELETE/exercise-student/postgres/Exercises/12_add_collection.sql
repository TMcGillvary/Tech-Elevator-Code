-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

INSERT INTO collection(collection_name)
VALUES ('Bill Murray Collection');

UPDATE movie SET collection_id = (SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection')
FROM movie_actor
WHERE movie.movie_id = movie_actor.movie_id AND movie_actor.actor_id = (SELECT person_id FROM person WHERE person_name = 'Bill Murray');