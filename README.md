# Taller: API REST con Spring Boot, Hibernate y MySQL

Proyecto desarrollado según las especificaciones del taller KrakDev.

## Configuración y Requisitos
1. **Java JDK 21** o superior.
2. **MySQL Server**:
   Asegurarse de tener creada la base de datos o dejar que la URL la cree:
   ```sql
   CREATE DATABASE apihibernate;
   ```
   Si la contraseña de MySQL `root` es distinta de `12345`, modificar en `src/main/resources/application.properties`.

3. **Ejecución**:
   - Desde Eclipse / Spring Tool Suite: Importar como *Existing Maven Project* y ejecutar `ApihibernateApplication.java` como *Spring Boot App*.
   - Por consola: `mvn spring-boot:run`

## Endpoints Disponibles
- `POST /peliculas` -> Crear película (JSON body)
- `GET /peliculas` -> Listar todas las películas
- `GET /peliculas/{id}` -> Buscar por ID
- `PUT /peliculas/{id}` -> Actualizar película
- `DELETE /peliculas/{id}` -> Eliminar por ID
- `GET /peliculas/genero?genero=Ciencia Ficcion` -> Filtrar por género
- `GET /peliculas/disponible?disponible=true` -> Filtrar por disponibilidad

## Guía de Commits Obligatorios (Parte 12)
Para cumplir con los 10 commits requeridos al subir a GitHub:
1. `git commit -m "Proyecto creado"`
2. `git commit -m "Configuración MySQL"`
3. `git commit -m "Entidad creada"`
4. `git commit -m "Repository funcionando"`
5. `git commit -m "Service funcionando"`
6. `git commit -m "Controller funcionando"`
7. `git commit -m "Endpoints funcionando"`
8. `git commit -m "Postman funcionando"`
9. `git commit -m "Consultas personalizadas"`
10. `git commit -m "Modificación automática de tabla"`
