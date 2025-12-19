# Products API

## Descripción

API REST desarrollada con **Spring Boot** para exponer un catálogo de productos. Permite consultar todos los productos disponibles y obtener el detalle de un producto específico. La persistencia se simula mediante una base de datos **H2 en memoria**, creada automáticamente con JPA/Hibernate al iniciar la aplicación.

---

## Endpoints

### Listar productos
- **GET** `/api/products`

Ejemplo:
```
http://localhost:8080/api/products
```

---

### Obtener producto por ID
- **GET** `/api/products/{id}`

Ejemplo:
```
http://localhost:8080/api/products/1
```

---

### Crear producto
- **POST** `/api/products`

Inserta un producto en la base H2 **en memoria**.

Ejemplo:
```http
POST http://localhost:8080/api/products
Content-Type: application/json
```

```json
{
  "name": "Multímetro digital",
  "description": "600V AC/DC medición de temperatura CAT II 600V",
  "imageUrl": "http://img.com/multimetro.png",
  "price": 18.900,
  "rating": 3.3,
  "specifications": "UNI-T UT33C+"
}
```

---

### Eliminar producto por ID
- **DELETE** `/api/products/{id}`

Ejemplo:
```
http://localhost:8080/api/products/1
```

---

## Tecnologías

- Java 21
- Spring Boot 4.0.1
- Spring Web MVC
- Spring Data JPA (Hibernate)
- H2 Database (en memoria)
- Maven

---

## Consola H2

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:productdb`
- Usuario: `sa`
- Password: *(vacío)*

---

## Ejecución

```bash
mvn spring-boot:run
```

API disponible en:
```
http://localhost:8080/api/products
```

