# start database Docker container:

cd JavaSpring/Database_JPA_Experiments/src/main/resources/

docker compose up -d mysql_database

docker compose down

=====================================================================================================
                    Create Schema and Table
=====================================================================================================



CREATE DATABASE test_database;

use test_database;

CREATE TABLE IF NOT EXISTS users
(
		id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
		name TEXT NOT NULL,
		email TEXT NOT NULL,
    timestamp BIGINT
);


GRANT ALL PRIVILEGES ON test_database.* TO 'admin'@'%' WITH GRANT OPTION;