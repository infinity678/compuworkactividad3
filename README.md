# 📌 Proyecto CompuWorkApp  

Este proyecto fue desarrollado como parte del aprendizaje en **Java**, aplicando los principios de **Programación Orientada a Objetos (POO)** y el uso de **JavaFX** para la interfaz gráfica.  

---

## ✨ Objetivos del Proyecto  
- Diseñar un sistema para la **gestión de empleados** (permanentes y temporales).  
- Implementar **herencia y polimorfismo** en Java.  
- Organizar la lógica en clases separadas y cohesionadas.  
- Incorporar **JavaFX** para ofrecer una interfaz sencilla e interactiva.  
- Realizar **pruebas unitarias** para validar el correcto funcionamiento.  

---

## 🏗️ Estructura del Proyecto  

📂 **CompuWorkApp**  
- `Main.java` → Punto de entrada de la aplicación.  
- `CompuWorkApp.java` → Configuración de la interfaz con **JavaFX**.  
- `EmpleadoPermanente.java` → Clase que modela a los empleados con contrato fijo.  
- `EmpleadoTemporal.java` → Clase que modela a los empleados por tiempo definido.  
- `GestorEmpleados.java` → Gestiona la lista de empleados.  
- `GestorDepartamentos.java` → Administra los departamentos disponibles.  

---

## 🖥️ Tecnologías Utilizadas  
- **Java 17**  
- **JavaFX** (interfaz gráfica)  
- **JUnit** (pruebas unitarias)  
- **Git & GitHub** (control de versiones)  

---

## 📊 Ejemplo de Funcionamiento  

1. El sistema permite **registrar empleados permanentes y temporales**.  
2. Cada empleado pertenece a un **departamento**.  
3. Desde la interfaz gráfica se pueden **visualizar y gestionar los empleados**.  

---

## ✅ Pruebas Unitarias  

Se implementaron pruebas con **JUnit** para validar:  
- Creación de empleados permanentes y temporales.  
- Cálculo de salarios.  
- Gestión de departamentos.  
- Correcta interacción entre clases.  

Ejemplo de prueba:  

```java
@Test
public void testEmpleadoTemporal() {
    EmpleadoTemporal emp = new EmpleadoTemporal("Ana", 25, 1200, 6);
    assertEquals("Ana", emp.getNombre());
    assertEquals(1200, emp.getSalario());
}