# Mutant Detection API

Esta es una API construida con Spring Boot que identifica secuencias de ADN mutantes. La API incluye dos endpoints principales:
- `POST /mutant`: Detecta si una secuencia de ADN es mutante.
- `GET /stats`: Proporciona estadísticas de las secuencias de ADN analizadas.

## Requisitos
- Java 17 o superior
- Maven
- MongoDB (local o en la nube)
- Docker (opcional, para ejecución de MongoDB en contenedor)

## Configuración de la Base de Datos

La aplicación utiliza una base de datos MongoDB para almacenar las secuencias de ADN verificadas. Debe configurarse la URI de conexión a MongoDB en el archivo `application.properties` de Spring Boot.

1. Crea una base de datos en MongoDB o utiliza MongoDB Atlas para una solución en la nube.
2. En el archivo `src/main/resources/application.properties`, añade la siguiente propiedad y configura la URI de tu base de datos:

   ```properties
   spring.data.mongodb.uri=mongodb://<usuario>:<contraseña>@<host>:<puerto>/<nombre_db>
   ```

   Asegúrate de reemplazar `<usuario>`, `<contraseña>`, `<host>`, `<puerto>`, y `<nombre_db>` con los valores correspondientes a tu base de datos.

## Ejecución de la Aplicación

Para ejecutar la aplicación desde la terminal, sigue estos pasos:

1. Clona este repositorio y navega al directorio raíz del proyecto.
2. Ejecuta el siguiente comando para compilar y correr la aplicación:

   ```bash
   mvn spring-boot:run
   ```

3. La API estará disponible en `http://localhost:8080`.

## Endpoints

### POST /mutant

- **Descripción**: Este endpoint recibe una secuencia de ADN en formato JSON y determina si corresponde a un mutante.
- **Request Body**:
  
  ```json
  {
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
  }
  ```

- **Response**:
  - **200 OK**: Si el ADN es mutante.
  - **403 Forbidden**: Si el ADN no es mutante.
  - **400 Bad Request**: Si el Request body es incorrecto

### GET /stats

- **Descripción**: Este endpoint devuelve estadísticas de las secuencias de ADN analizadas.
- **Response**:
    - **200**:
    ```json
    {
      "count_mutant_dna": 40,
      "count_human_dna": 100,
      "ratio": 0.4
    }
    ```

## Ejecución de Pruebas

Para ejecutar los tests de la aplicación, usa el siguiente comando en la raíz del proyecto:

```bash
mvn test
```

Esto ejecutará todas las pruebas unitarias configuradas en el proyecto.

## Ejecución de MongoDB en Docker (Opcional)

Si prefieres correr MongoDB en un contenedor Docker en lugar de instalarlo localmente:

1. Asegúrate de tener Docker instalado y en ejecución.
2. Ejecuta el siguiente comando para iniciar MongoDB:

   ```bash
   docker run --name mongo-db -d -p 27017:27017 mongo:latest
   ```

3. Configura la URI en `application.properties` para apuntar a `localhost`:

   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/mutantsdb
   ```
