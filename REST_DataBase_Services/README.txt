
# Spring Boot With H2 Database

    https://www.baeldung.com/spring-boot-h2-database

# Need to add to "resources/<NAME>.properties"

    '
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    '
