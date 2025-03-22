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



=====================================================================================================
                    Maven
=====================================================================================================



# Check versions:

update-java-alternatives -l


export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven

export PATH=${JAVA_HOME}/bin:${M2_HOME}/bin:${PATH}

