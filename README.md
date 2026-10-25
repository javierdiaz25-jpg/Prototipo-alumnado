# API CRM Escolar - Módulo Alumnado

## Información General

| Campo | Valor |
|---------|---------|
| Versión | 1.0 |
| Tecnología | Java Servlet API (Jakarta EE) |
| Formato de intercambio | JSON |
| Protocolo | HTTP / HTTPS |

---

# 1. Descripción General

La API del CRM Escolar permite consultar información relacionada con el alumnado desde aplicaciones web, móviles o sistemas externos.

Actualmente se exponen los siguientes servicios REST:

- Obtener alumno por ID.
- Obtener listado completo de alumnos.

---

# 2. URL Base

## Desarrollo

```http
http://localhost:8080/crm-colegio/api
```

## Producción

```http
https://dominio-centro.es/api
```

---

# 3. Autenticación

## Versión actual

```text
Sin autenticación
```

## Recomendación para producción

```text
JWT Bearer Token
```

### Cabecera de ejemplo

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR...
```

---

# 4. Modelo de Datos

## Alumno

| Campo | Tipo | Descripción |
|---------|---------|---------|
| id | Integer | Identificador único |
| nombre | String | Nombre |
| apellidos | String | Apellidos |
| curso | String | Curso actual |
| email | String | Correo institucional |
| media | Double | Nota media |

### Ejemplo

```json
{
  "id": 1,
  "nombre": "Juan",
  "apellidos": "Pérez",
  "curso": "4º ESO",
  "email": "juan@colegio.es",
  "media": 8.5
}
```

---

# 5. Endpoints

## 5.1 Obtener Alumno

Obtiene la información de un alumno a partir de su identificador.

### Método

```http
GET
```

### Endpoint

```http
/api/alumnos?id={id}
```

### Parámetros

| Parámetro | Tipo | Obligatorio |
|------------|---------|------------|
| id | Integer | Sí |

### Ejemplo de petición

```http
GET /api/alumnos?id=1
```

### Respuesta Correcta

**Código HTTP**

```http
200 OK
```

**Body**

```json
{
  "id": 1,
  "nombre": "Juan",
  "apellidos": "Pérez",
  "curso": "4º ESO",
  "email": "juan@colegio.es",
  "media": 8.5
}
```

### Error: Parámetro ausente

**Código HTTP**

```http
400 Bad Request
```

**Body**

```json
{
  "error": "Debe proporcionar un ID"
}
```

### Error: Alumno no encontrado

**Código HTTP**

```http
404 Not Found
```

**Body**

```json
{
  "error": "Alumno no encontrado"
}
```

---

## 5.2 Obtener Lista de Alumnos

Obtiene todos los alumnos registrados en el sistema.

### Método

```http
GET
```

### Endpoint

```http
/api/alumnos/lista
```

### Parámetros

```text
No requiere parámetros
```

### Respuesta

**Código HTTP**

```http
200 OK
```

**Body**

```json
[
  {
    "id": 1,
    "nombre": "Juan",
    "apellidos": "Pérez",
    "curso": "4º ESO"
  },
  {
    "id": 2,
    "nombre": "María",
    "apellidos": "Gómez",
    "curso": "3º ESO"
  }
]
```

---

# 6. Códigos HTTP Utilizados

| Código | Significado |
|----------|----------|
| 200 | Operación completada correctamente |
| 400 | Solicitud incorrecta |
| 401 | No autorizado |
| 403 | Acceso prohibido |
| 404 | Recurso no encontrado |
| 500 | Error interno del servidor |

---

# 7. Cabeceras HTTP

## Cabeceras de petición

```http
Accept: application/json
```

## Cabeceras de respuesta

```http
Content-Type: application/json
Charset: UTF-8
```

---

# 8. Arquitectura del Módulo

```text
src
│
├── controller
│   ├── AlumnoApiServlet.java
│   └── ListarAlumnosApiServlet.java
│
├── dao
│   └── AlumnoDAO.java
│
├── model
│   └── Alumno.java
│
└── web
    ├── dashboard.html
    └── index.html
```

---

# 9. Flujo de Petición

```text
Cliente
   │
   ▼
HTTP Request
   │
   ▼
Servlet API
   │
   ▼
AlumnoApiServlet
   │
   ▼
AlumnoDAO
   │
   ▼
Modelo Alumno
   │
   ▼
JSON Response
```

---

# 10. Endpoints Futuros

## API de Calificaciones

```http
GET    /api/notas
GET    /api/notas/alumno/{id}
POST   /api/notas
PUT    /api/notas/{id}
DELETE /api/notas/{id}
```

## API de Asistencia

```http
GET    /api/asistencia
GET    /api/asistencia/alumno/{id}
POST   /api/asistencia
PUT    /api/asistencia/{id}
```

## API de Mensajería

```http
GET    /api/mensajes
POST   /api/mensajes
DELETE /api/mensajes/{id}
```

## API de Tutorías

```http
GET    /api/tutorias
POST   /api/tutorias
PUT    /api/tutorias/{id}
DELETE /api/tutorias/{id}
```

---

# 11. Versionado

Se recomienda versionar la API desde la primera iteración.

## Ejemplo

```http
/api/v1/alumnos
/api/v1/notas
/api/v1/asistencia
/api/v1/mensajes
```

### Futuras versiones

```http
/api/v2/alumnos
/api/v2/notas
/api/v3/alumnos
```

---

# 12. Recomendaciones para Producción

## Plataforma

- Java 21 LTS
- Jakarta EE 10
- Apache Tomcat 10

## Base de Datos

- MySQL 8
- PostgreSQL 16

## Seguridad

- JWT Authentication
- HTTPS
- Hashing de contraseñas con BCrypt
- Control de roles y permisos

## Desarrollo

- Arquitectura MVC
- DAO Pattern
- Repository Pattern
- Service Layer
- DTO Pattern

## Documentación

- OpenAPI 3.1
- Swagger UI
- Postman Collection

## Monitorización

- SLF4J
- Logback
- Auditoría de accesos
- Registro de errores

---

# 13. Changelog

## Versión 1.0

- Endpoint de consulta por ID
- Endpoint de listado de alumnos
- Respuestas JSON
- Arquitectura MVC básica

---

**Autor:** Equipo de Desarrollo CRM Escolar  
**Versión del Documento:** 1.0  
**Estado:** Borrador Técnico