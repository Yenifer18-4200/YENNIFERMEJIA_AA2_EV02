VIRTUAL STORE
Evidencia GA7-220501096-AA2-EV02

Módulos de software codificados y probados

1. Descripción del proyecto

Virtual Store es una aplicación web desarrollada en Java que permite gestionar los productos de una tienda virtual mediante operaciones CRUD (Crear, Consultar, Actualizar y Eliminar).

El proyecto implementa una arquitectura organizada por capas, utilizando Java Servlets para gestionar las solicitudes del usuario, JSP para la presentación de las interfaces y SQLite para el almacenamiento de la información.

2. Objetivo del proyecto

Desarrollar y probar un módulo de software web para la administración de productos, aplicando los conocimientos adquiridos en el componente formativo de Construcción de Aplicaciones con Java.

3. Tecnologías y herramientas utilizadas
Lenguaje de programación: Java.
Entorno de desarrollo: Visual Studio Code.
Gestor de proyectos: Apache Maven.
Tecnología web: Java Servlets y JSP.
Lenguaje de marcado: HTML.
Base de datos: SQLite.
Control de versiones: Git.
Repositorio remoto: GitHub.
4. Funcionalidades del módulo

El módulo de gestión de productos permite:

Consultar y visualizar los productos registrados.
Registrar nuevos productos.
Editar la información de los productos existentes.
Eliminar productos.
Consultar información como identificador, nombre, precio y stock.
5. Estructura del proyecto

El proyecto está organizado de la siguiente manera:

text
YENNIFERMEJIA_AA2_EV02/
│
├── Evidencias/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── virtualstore/
│       │           ├── dao/
│       │           │   └── ProductDAO.java
│       │           │
│       │           ├── database/
│       │           │   ├── DatabaseConnection.java
│       │           │   └── DatabaseInitializer.java
│       │           │
│       │           ├── model/
│       │           │   └── Product.java
│       │           │
│       │           ├── servlet/
│       │           │   └── ProductServlet.java
│       │           │
│       │           ├── CrudDemo.java
│       │           └── Main.java
│       │
│       └── webapp/
│           ├── index.jsp
│           ├── product-list.jsp
│           └── product-form.jsp
│
├── .gitignore
├── enlace_repositorio.txt
├── pom.xml
├── README.md
└── tienda_virtual.db

6. Descripción de los componentes
Paquete dao

Contiene ProductDAO.java, encargado de gestionar las operaciones de acceso a los datos de los productos.

Paquete database

Contiene las clases:

DatabaseConnection.java: administra la conexión con la base de datos SQLite.
DatabaseInitializer.java: permite inicializar la estructura de la base de datos.
Paquete model

Contiene Product.java, que representa la entidad o modelo de los productos.

Paquete servlet

Contiene ProductServlet.java, encargado de recibir y procesar las solicitudes del usuario mediante los métodos HTTP correspondientes.

Páginas webapp
index.jsp: página principal de la aplicación.
product-list.jsp: presenta el listado de productos.
product-form.jsp: contiene el formulario para registrar o editar productos.
Clases adicionales
CrudDemo.java: clase de demostración de operaciones CRUD.
Main.java: clase principal del proyecto.
7. Base de datos

El proyecto utiliza SQLite para almacenar la información de los productos.

El archivo de la base de datos es:

tienda_virtual.db

La información administrada incluye identificador, nombre, precio y stock de los productos.

8. Ejecución del proyecto

Para ejecutar el proyecto se requiere:

Tener instalado Java JDK.
Tener instalado Apache Maven.
Abrir la carpeta del proyecto en Visual Studio Code.
Verificar las dependencias configuradas en pom.xml.
Compilar el proyecto utilizando Maven.
Ejecutar la aplicación de acuerdo con la configuración del proyecto y acceder desde el navegador.
9. Control de versiones

El proyecto utiliza Git para el control de versiones y GitHub como plataforma de alojamiento del repositorio remoto.

El enlace del repositorio se encuentra en el archivo enlace_repositorio.txt.

10. Evidencias

La carpeta Evidencias contiene las capturas de pantalla que documentan:

La estructura del proyecto.
La codificación de los Servlets.
La implementación de las páginas JSP.
El funcionamiento de la aplicación web.
Las pruebas de las funcionalidades del módulo.
11. Información de la evidencia

Aprendiz: Yennifer Mejía.

Proyecto: Virtual Store.

Evidencia: GA7-220501096-AA2-EV02.

Nombre de la evidencia: Módulos de software codificados y probados.

Programa: Servicio Nacional de Aprendizaje (SENA).