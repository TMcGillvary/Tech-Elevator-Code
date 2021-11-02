-- Select all columns from posts that are published

SELECT id, name, body, published, created
FROM posts
WHERE published = 'true';

-- Select posted_by and body from comments that have a body and were created after Oct. 15, 2019

SELECT posted_by, body
FROM comments
WHERE body IS NOT NULL AND created > '2019-10-15';

-- Select the name and published states from posts ordered by when they were created, earliest first

SELECT name, published
FROM posts
ORDER BY created;

-- Select the created date and the count of all the comments created on that date

SELECT created, COUNT(*) AS comment_count
FROM comments
GROUP BY created
ORDER BY created;

-- Select the post name, comment posted_by and comment body for all posts created after Oct. 1st, 2019

SELECT posts.name, comments.posted_by, comments.body
FROM posts
LEFT JOIN comments ON posts.id = comments.post_id
WHERE posts.created > '2019-10-01'
ORDER BY posts.created;

