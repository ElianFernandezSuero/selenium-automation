#  Estrategia de Pruebas para la Automatización de SauceDemo

Este proyecto contiene pruebas automatizadas para la plataforma [SauceDemo](https://www.saucedemo.com), utilizando **Selenium WebDriver**, **TestNG** y **Java**, con un enfoque en el patrón **Page Object Model (POM)**.

---

##  Estrategia de Pruebas

### 1️ Flujos de Pruebas Automatizados

Se han implementado pruebas para los siguientes flujos clave:

- **Login**
  - Validación de credenciales correctas e incorrectas
  - Manejo de usuarios bloqueados o problemáticos

- **Logout**
  - Verificación del cierre de sesión exitoso

- **Checkout**
  - Agregar productos al carrito
  - Validar el resumen del pedido
  - Completar la compra

---

### 2️ Categorías de Pruebas

Para cada flujo, las pruebas cubren los siguientes aspectos:

####  Pruebas de Autenticación
- Inicio de sesión exitoso con credenciales válidas
- Manejo de errores con credenciales inválidas o usuarios bloqueados

####  Pruebas de Carrito y Checkout
- Agregar y eliminar productos del carrito
- Validación del total del pedido
- Finalización de compra con datos correctos

####  Pruebas de Navegación
- Acceso a distintas páginas de la aplicación
- Validación de redirecciones correctas

---

### 3 Instalar Dependencias
Asegúrate de tener Java 11+ y Maven instalados. Luego, ejecuta:

- mvn clean install
  
### 4 Ejecutar todas las pruebas:

#### Ejecutar todas las pruebas:
- mvn test
  
#### Ejecutar pruebas en paralelo con TestNG:
- mvn surefire:test
  
#### Ejecutar una prueba específica:
- mvn -Dtest=LoginTests test


