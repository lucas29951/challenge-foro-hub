# 🧠 ForoHub - Challenge Back-End

**ForoHub** es una API REST construida con Spring Boot que permite crear y responder tópicos de discusión relacionados con distintos cursos, gestionando usuarios autenticados.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
    - Spring Web
    - Spring Data JPA
    - Spring Security
    - Spring Boot DevTools
    - Spring Validation
    - SpringDoc OpenAPI (documentación de endpoints)
- **Lombok**
- **Flyway** (control de versiones de la base de datos)
- **MySQL Driver**
- **Auth0 Java JWT** (gestión de tokens)

---

## 📁 Estructura de carpetas

```

src
├── main
│   ├── java
│   │   └── com.alura.forohub
│   │       ├── config                # Configuración de seguridad y documentación
│   │       │   ├── security
│   │       │   └── springdoc
│   │       ├── controller            # Controladores REST
│   │       ├── dto                   #
│   │       ├── exceptions            # 
│   │       ├── model                 # Entidades JPA
│   │       ├── repository            # Interfaces de acceso a datos
│   │       └── service               # Lógica de negocios
│   └── resources
│       ├── db/migration              # Scripts de migración Flyway
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

## 🔐 Autenticación y seguridad

- Autenticación basada en JWT.
- Endpoints protegidos por roles.
- Implementación de filtros de seguridad personalizados.
- Almacenamiento seguro de contraseñas usando `BCrypt`.

---

## ▶️ Ejecución del Proyecto

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/lucas29951/challenge-foro-hub.git
   cd challenge-foro-hub
   ```

2. **Configurar base de datos en `src/main/resources/application.properties`:**
   ```properties
    spring.datasource.url=jdbc:mysql://localhost/forohub_db
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_clave

    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.show-sql=true

    spring.flyway.enabled=true
    spring.flyway.baseline-on-migrate=true
    ```

3. **Compila y ejecuta desde tu IDE o usa Maven:**
   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="com.alura.forohub.app.App"
   ```

4. **¡Listo! Interactúa desde la terminal.**

---

## 🎯 Funcionalidades implementadas

* [x] Autenticación JWT segura
* [x] Registro e inicio de sesión de usuarios
* [x] Creación y gestión de cursos
* [x] Creación y gestión de tópicos
* [x] Agregado de respuestas a tópicos
* [x] Validaciones con Bean Validation
* [x] Control de errores con manejo global de excepciones
* [x] Swagger UI para probar la API
* [x] Separación por capas (Controller - Service - Repository)

---

## 📚 Autor

Desarrollado por **Lucas Rodriguez** como parte de un challenge de backend.

🔗 [Mi perfil de GitHub](https://github.com/lucas29951)

---

## 📄 Licencia

Este proyecto se encuentra bajo la licencia MIT. Libre de usar, modificar y compartir.

---