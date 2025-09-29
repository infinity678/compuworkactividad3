# 📌 Proyecto CompuWork

Este repositorio contiene el desarrollo de la **Actividad 1** en Java, que incluye modelado con diagramas UML, implementación orientada a objetos, integración de gestores y pruebas unitarias.

---

## 📊 Diagramas del Proyecto

### 🔹 Diagrama de Casos de Uso
![Casos de Uso](https://github.com/user-attachments/assets/0be76cf6-3af6-4a0b-9587-e046fe7d849a)

### 🔹 Diagrama de Clases
![Clases](https://github.com/user-attachments/assets/d23dd47c-d17d-4f41-befe-19d7140eaf2c)

### 🔹 Diagrama RAM
![RAM](https://github.com/user-attachments/assets/18ab31fd-de04-4b18-ad28-028e625d6067)

---

## 📖 Documentación del Proceso

El proyecto **CompuWork** se desarrolló en varias etapas:

1. **Modelado inicial**  
   - Creación de diagramas UML (casos de uso, clases y RAM).  
   - Definición de entidades: `Empleado`, `EmpleadoPermanente`, `EmpleadoTemporal`, `Departamento`.  

2. **Implementación en Java**  
   - Uso de POO (herencia y polimorfismo).  
   - Gestión de empleados mediante `GestorEmpleados`.  
   - Gestión de departamentos mediante `GestorDepartamentos`.  
   - Aplicación principal en `CompuWorkApp`.  

3. **Integración**  
   - Comunicación entre gestores a través de listas en memoria (`ArrayList`).  
   - Interfaz inicial por consola con opción de enlazar a **JavaFX** (para futura GUI).  

4. **Pruebas**  
   - Pruebas unitarias con **JUnit 5** para validar empleados, departamentos e integración.  
   - Casos probados: creación, normalización de desempeño, asignación a departamentos, cálculo de promedios.  
   - Flujo manual probado en consola.  

---

## 🚀 Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/compuwork.git
   cd compuwork