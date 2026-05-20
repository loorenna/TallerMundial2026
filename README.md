# README - Sistema Mundial FIFA 2026
#Autor: Alisson Quiguango
## Descripción del Proyecto

Este proyecto consiste en un sistema desarrollado en Java para la gestión de jugadores del Mundial FIFA 2026.  
El sistema permite registrar, listar, buscar, actualizar y eliminar jugadores, además de manejar estadísticas deportivas como goles, asistencias y minutos jugados.

El proyecto fue desarrollado aplicando Programación Orientada a Objetos (POO), manejo de excepciones, interfaces, herencia, encapsulamiento y colecciones dinámicas (`ArrayList`).

---

# Funcionalidades

- Registrar jugadores
- Listar jugadores registrados
- Buscar jugador por ID
- Actualizar goles
- Actualizar asistencias
- Actualizar minutos jugados
- Eliminar jugadores
- Mostrar estadísticas generales
- Exportar información en formato CSV
- Manejo de excepciones personalizadas

---

# Tecnologías Utilizadas

- Java
- IntelliJ IDEA
- Programación Orientada a Objetos
- ArrayList
- Excepciones
- Interfaces
- Herencia
- Polimorfismo

---

# Estructura del Proyecto

```text
ProyectoMundial/
│
├── Main.java
├── GestorMundial.java
├── Persona.java
├── Jugador.java
├── Tecnico.java
├── Calificable.java
├── Exportable.java
└── JugadorNoEncontradoException.java
```

---

# Explicación de las Clases

## Persona

Clase base del sistema.  
Contiene atributos generales como:

- id
- nombre
- edad
- nacionalidad

---

## Jugador

Hereda de `Persona`.

Contiene información específica del jugador:

- posición
- dorsal
- equipo
- goles
- asistencias
- minutos jugados

Además implementa interfaces para:

- calcular calificación
- exportar datos

---

## Tecnico

Representa a los técnicos o entrenadores del mundial.

---

## GestorMundial

Clase principal de gestión.

Permite:

- registrar jugadores
- buscar jugadores
- actualizar estadísticas
- eliminar registros
- mostrar estadísticas
- exportar información

---

## Calificable

Interface que obliga a implementar el cálculo de calificación del jugador.

---

## Exportable

Interface utilizada para exportar datos en formato CSV.

---

## JugadorNoEncontradoException

Excepción personalizada utilizada cuando un jugador no existe en el sistema.

---

# Conceptos Aplicados

## Herencia

`Jugador` y `Tecnico` heredan de `Persona`.

---

## Polimorfismo

Uso de métodos sobrescritos y manejo de interfaces.

---

## Encapsulamiento

Todos los atributos son privados y se acceden mediante getters y setters.

---

## Excepciones

Se utilizaron:

- `IllegalArgumentException`
- `NumberFormatException`
- `JugadorNoEncontradoException`

---

# Ejecución del Programa

1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `Main.java`.
3. Utilizar el menú interactivo.

---

# Menú Principal

```text
1. Registrar jugador
2. Listar jugadores
3. Buscar jugador
4. Actualizar goles
5. Actualizar asistencias
6. Actualizar minutos jugados
7. Eliminar jugador
8. Ver estadísticas
9. Exportar CSV
0. Salir
```

---

# Estadísticas Mostradas

El sistema permite visualizar:

- total de jugadores
- total de goles
- máximo goleador
- estadísticas individuales

---

# Exportación CSV

Los jugadores pueden exportarse en formato CSV mediante el método:

```java
exportarCSV()
```

Ejemplo:

```text
1,Alisson,21,Ecuatoriana,Delantero,9,Liga,5,3,900
```

---

# Conclusiones

- Se fortalecieron conocimientos de Programación Orientada a Objetos.
- Se aplicó manejo de excepciones en Java.
- Se utilizó herencia e interfaces correctamente.
- Se desarrolló un sistema CRUD funcional.
- Se implementó validación de datos y estadísticas deportivas.
