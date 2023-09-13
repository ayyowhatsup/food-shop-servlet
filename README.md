## Refood

### Introduction

An e-commerce website

### Setting up locally

> Eclipse: Import... > Git > ... > Import using the New Project Wizard

- PostgreSQL (DDL: [ddl.sql](./ddl.sql))
- Apache Tomcat 10, Java 16
> [!NOTE]
> Tomcat launch options environment variables

```
DB_URL
DB_USERNAME
DB_PASSWORD
AES_SECRET_KEY (128, 192, or 256 bits)
```

> Example:

```
DB_URL=jdbc:postgresql://localhost:5432/database
DB_USERNAME=postgres
DB_PASSWORD=postgres
AES_SECRET_KEY=abcdefghiklmnopz
```

- WEB-INF\lib:
  - pgJDBC: [Download](https://jdbc.postgresql.org/download/)
  - Gson: [gson-2.9.0](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.9.0)
  - jakarta.servlet.jsp.jstl [v2.0.0](https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl/2.0.0)
  - jakarta.servlet.jsp.jstl-api: [v2.0.0](https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api/2.0.0)
