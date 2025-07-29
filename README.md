# 🧠 ForoHub - Challenge Back-End

**ForoHub** es un proyecto de foro académico orientado a cursos. Está desarrollado con Java y Spring Boot, y permite gestionar temas de discusión (tópicos) entre usuarios registrados.

> Proyecto en desarrollo - Actualmente en fase inicial de configuración y estructura.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
    - Spring Web
    - Spring Data JPA
    - Spring Security
    - Spring Boot DevTools
    - Spring Validation
    - SpringDoc OpenAPI (Swagger)
- **Lombok**
- **Flyway** (para migraciones de base de datos)
- **MySQL Driver**
- **Auth0 Java JWT** (para autenticación con tokens)

---

## 📁 Estructura de carpetas esperada

```

src
├── main
│   ├── java
│   │   └── com.alura.forohub
│   │       ├── controller      # Próximamente: controladores REST
│   │       ├── service         # Próximamente: lógica de negocio
│   │       ├── repository      # Próximamente: interfaces de acceso a datos
│   │       ├── model           # Próximamente: entidades JPA
│   │       └── config          # Configuración de seguridad y beans
│   └── resources
│       ├── db/migration        # Scripts de migración Flyway
│       └── application.properties

````

---

## 🛠️ Configuración local

### ✅ Requisitos

- Java 17+
- Maven
- MySQL (con una base de datos creada, por ejemplo: `forohub_db`)

### ⚙️ Variables en `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost/forohub_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.flyway.enabled=true
````

> ⚠️ Asegúrate de que tu base de datos esté creada antes de iniciar la app.

---

## ✍️ Próximas tareas

* [ ] Tests de endpoints

---

## 📚 Autor

Desarrollado por **Lucas Rodriguez** como parte de un challenge de backend.

🔗 [Mi perfil de GitHub](https://github.com/lucas29951)

---

## 📄 Licencia

Este proyecto se encuentra bajo la licencia MIT. Libre de usar, modificar y compartir.
