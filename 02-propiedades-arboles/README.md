# Guía 2 - Anatomía y propiedades de un árbol

**Asignatura:** Estructura de Datos II  
**Programas:** Ingeniería de Software e Ingeniería de Sistemas  
**Semestre:** IV  
**Lenguaje:** Java  
**Proyecto:** Pixel Studios - Empresa de videojuegos

---

## 1. Objetivo

Identificar y calcular las propiedades de un árbol general mediante programación en Java, utilizando una empresa de desarrollo de videojuegos como ejemplo.

## 2. Descripción del proyecto

Pixel Studios es una empresa ficticia dedicada al desarrollo de videojuegos. Su estructura se representa mediante un árbol general compuesto por áreas, equipos y proyectos.

Cada nodo representa una parte de la organización y puede tener varios hijos.

## 3. Conceptos de árboles

- **Raíz:** nodo principal del árbol. En este proyecto es Pixel Studios.
- **Padre:** nodo que tiene uno o varios hijos directos.
- **Hijo:** nodo que depende directamente de otro nodo.
- **Hermanos:** nodos que comparten el mismo padre.
- **Primos:** en la analogía familiar, nodos cuyos padres son hermanos.
- **Hoja:** nodo que no tiene hijos.
- **Grado de un nodo:** cantidad de hijos directos.
- **Grado del árbol:** mayor grado encontrado entre sus nodos.
- **Profundidad:** distancia desde la raíz hasta un nodo, medida en aristas.
- **Altura:** longitud del camino más largo desde un nodo hasta una hoja, medida en aristas.
- **Nivel:** en este proyecto, es igual a la profundidad.

## 4. Estructura del árbol

```text
PIXEL STUDIOS
├── Desarrollo de Videojuegos
│   ├── Programacion
│   │   ├── Inteligencia Artificial
│   │   └── Modo Multijugador
│   └── Pruebas y Calidad
├── Diseno y Arte
│   ├── Modelado 3D
│   │   ├── Personajes 3D
│   │   └── Escenarios Virtuales
│   └── Animacion
└── Audio y Sonido
    ├── Musica
    │   └── Banda Sonora
    └── Efectos de Sonido
```

El programa agrega posteriormente el nodo `Proyecto IA Generativa` como hijo de `Inteligencia Artificial`, aumentando la profundidad máxima del árbol.

## 5. Convenciones utilizadas

- La raíz tiene profundidad 0.
- El nivel es igual a la profundidad.
- Una hoja tiene altura 0.
- La altura se mide en número de aristas.
- El grado de un nodo es su número de hijos directos.

## 6. Archivos del proyecto

- `NodoGeneral.java`: representa cada nodo y administra sus hijos.
- `MetricasArbol.java`: contiene los algoritmos para calcular altura, profundidad, grado, caminos y conteos.
- `Main.java`: construye el árbol y ejecuta las pruebas.
- `tabla_metricas_manual.csv`: contiene las métricas calculadas manualmente.
- `salida_esperada.txt`: registra la salida esperada del programa.

## 7. Cómo compilar y ejecutar

Abre una terminal en la carpeta del proyecto y ejecuta:

```bash
javac NodoGeneral.java MetricasArbol.java Main.java
java Main
```

## 8. Propiedades calculadas

El programa permite:

1. Identificar la raíz.
2. Contar los nodos y las hojas.
3. Calcular los nodos internos.
4. Obtener el grado de cada nodo y del árbol.
5. Calcular la altura y el número de niveles.
6. Obtener la profundidad de cinco nodos.
7. Calcular la profundidad de todas las hojas.
8. Mostrar dos caminos y sus longitudes.
9. Comparar las métricas antes y después de agregar un nivel.

## 9. Prueba de un nivel adicional

Antes de agregar el nodo `Proyecto IA Generativa`:

- Nodos: 15.
- Altura: 3.
- Niveles: 4.

Después de agregarlo:

- Nodos: 16.
- Altura: 4.
- Niveles: 5.

**Conclusión:** al agregar un hijo debajo de una hoja que se encuentra en el camino más largo, la altura del árbol aumenta en una unidad y se incorpora un nuevo nivel.

## 10. Conclusión general

Este proyecto permite comprender las propiedades de los árboles generales mediante un ejemplo relacionado con el desarrollo de videojuegos. Los métodos recursivos facilitan el cálculo de las métricas y permiten observar cómo cambia la estructura al agregar nuevos nodos.

## 11. Entrega

Proyecto académico desarrollado para la asignatura Estructura de Datos II. El repositorio incluye el código fuente, las métricas manuales y la salida esperada para facilitar la revisión del funcionamiento.

## 12. Diagrama del árbol de PIXEL STUDIOS

El siguiente diagrama representa la estructura jerárquica de la empresa, organizada mediante un árbol general en Java.