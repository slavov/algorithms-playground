--You are given 2 tables
CREATE TABLE tasks
(
    id   INTEGER     NOT NULL,
    name VARCHAR(40) NOT NULL,
    UNIQUE (id)
);

CREATE TABLE reports
(
    id        INTEGER     NOT NULL,
    candidate VARCHAR(40) NOT NULL,
    score     INTEGER     NOT NULL,
    task_id   INTEGER     NOT NULL,
    UNIQUE (id)
);

--Write SQL query which assigns a difficulty rating to each task having at least one solution.
--The difficulty of the task depends on the average score of all candidates' solution submitted for this task.
--It's possible that one candidate have submitted multiple solutions for the same task, in this case all of those solutions should be included in the average.
--There are 3 difficulties: Easy, Medium and Hard
--If the average score for the task is lower than or equal to 20 --> Hard
--If the average score for the task is higher than 20, but lower or equals to 60 --> Medium
--If the average score for the task is higher than 60 --> Easy


-- write your code in PostgreSQL 9.4
SELECT t.id,
       t.name,
       CASE
           WHEN AVG(r.score) <= 20 THEN 'Hard'
           WHEN AVG(r.score) <= 60 THEN 'Medium'
           ELSE 'Easy'
           END AS difficulty
FROM tasks AS t
         RIGHT JOIN reports AS r ON t.id = r.task_id
GROUP BY t.id, t.name
ORDER BY t.id
