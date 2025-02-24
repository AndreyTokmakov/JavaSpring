CREATE DATABASE test_db;

use test_db;

CREATE TABLE IF NOT EXISTS users
(
		id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
		name TEXT NOT NULL,
		email TEXT NOT NULL,
    timestamp BIGINT
);


GRANT ALL PRIVILEGES ON test_db.* TO 'admin'@'%' WITH GRANT OPTION;