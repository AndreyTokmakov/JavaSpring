
-- Create Schema if missing:
-- CREATE DATABASE test_database;

use test_database;

CREATE TABLE IF NOT EXISTS users
(
		id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
		name TEXT NOT NULL,
		email TEXT NOT NULL,
    timestamp BIGINT
);


GRANT ALL PRIVILEGES ON test_database.* TO 'admin'@'%' WITH GRANT OPTION;