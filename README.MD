# Sistema de Control de Acceso para el Complejo Empresarial Zona ACME

## Descripción del Proyecto

El Sistema de Control de Acceso para el Complejo Empresarial Zona ACME tiene como objetivo gestionar eficientemente el ingreso y salida de personas en el complejo. Este sistema proporciona trazabilidad de las operaciones, facilita la generación de reportes, y asegura una operación intuitiva para usuarios con conocimientos informáticos limitados.

### Funcionalidades Implementadas
- **Gestión de Usuarios:**
  - Roles definidos: Superusuario, supervisores de seguridad, guardas y funcionarios de empresas.
  - Inactivación de usuarios en lugar de eliminación para mantener la consistencia.
- **Registro de Accesos:**
  - Validación de documentos mediante lector de código de barras o ingreso manual.
  - Alertas para personas con restricciones de acceso.
- **Control de Salidas:**
  - Registro obligatorio para evitar inconsistencias en futuros ingresos.
- **Gestión de Vehículos:**
  - Registro de placas y asociación de ocupantes.
- **Manejo de Incidentes:**
  - Registro de comportamientos indebidos y restricciones de acceso.
  - Trazabilidad completa de anotaciones y cambios de estado.
- **Trazabilidad y Reportes:**
  - Informes detallados de accesos y estado de usuarios.
  - Monitoreo en tiempo real mediante concurrencia.
- **Interfaz Gráfica:**
  - Diseño intuitivo con JavaFX para guardas, supervisores y funcionarios.

## Diagrama de Base de Datos
Incluye un diseño relacional que detalla las entidades principales, disponible para visualizar abriendo el archivo index en la ruta ![DiagramaE-R\index.html](DiagramaE-R\index.html) en un navegador moderno.


## Diagrama UML
Se han desarrollado diagramas UML para ilustrar la arquitectura y los módulos clave del sistema,  disponible para visualizar abriendo el archivo index en la ruta ![Diagramas\UML.html](Diagramas\UML.html) en un navegador moderno.

## Requisitos del Sistema
### Requisitos Técnicos
- Lenguaje de programación: Java 17 Minimo.
- Framework para interfaz gráfica: JavaFX.
- Base de datos relacional con conexión JDBC.
- Patrón arquitectónico: MVC (Modelo-Vista-Controlador).
- Aplicación de principios SOLID y patrones de diseño (Singleton, DAO, y otros tres adicionales).

### Requisitos No Funcionales
- Diseño intuitivo y accesible.
- Operación eficiente en tiempo real mediante hilos.
- Trazabilidad completa de todas las operaciones.

## Instalación y Configuración
1. **Descargar el proyecto desde este repositorio.**
2. **Configurar la base de datos:**
   - Crear la base de datos usando el script proporcionado en el directorio `sql/` en el orden `DDL`, `DML`, `USERS`, `PROCEDURES` Y `TRIGGERS`.
3. **Compilar y ejecutar el proyecto:**
   - Importar el proyecto en tu IDE preferido (IntelliJ o VS Code).
   - Ejecutar el programa compilando el archivo `MainApplication.java` en la ruta ![src\main\java\com\acme\complejoacme\MainApplication.java](src\main\java\com\acme\complejoacme\MainApplication.java).

## Autoría
- **Desarrolladores:**
  - [KevinJGV](https://github.com/KevinJGV)
  - [Javier Eduardo Acevedo Noguera](https://github.com/JavierEAcevedoN)
