# Guía 1: De lo lineal a lo jerárquico

## Escenario elegido: organigrama empresarial

Este proyecto representa el organigrama que aparece en la imagen proporcionada. La raíz es **Gerente general**. De él dependen tres áreas: **Área administrativa**, **Área comercial** y **Área técnica**. Cada área tiene dos departamentos:

- Área administrativa: Contabilidad y Recursos humanos.
- Área comercial: Ventas y Marketing.
- Área técnica: Soporte y Desarrollo.

El árbol tiene 10 nodos en total y tres niveles contando la raíz como nivel 0 (raíz, áreas y departamentos).

## Clasificación de los cuatro escenarios

1. **Sistema de archivos: jerárquico.** Una carpeta puede contener subcarpetas y archivos; normalmente cada elemento tiene una sola carpeta padre.
2. **Organigrama empresarial: jerárquico.** Los cargos y áreas se organizan por dependencia. Este es el escenario implementado en `Main.java`.
3. **Menú de aplicación: jerárquico.** Las opciones pueden abrir submenús y opciones secundarias.
4. **Árbol genealógico: generalmente jerárquico en una sola línea de ascendencia.** Si se representan ambos progenitores y las relaciones entre varias generaciones, el modelo puede necesitar un grafo porque una persona tiene dos progenitores.

## Dos ventajas de un árbol frente a una lista

- Un árbol representa claramente las relaciones de dependencia entre la gerencia, las áreas y sus departamentos.
- Permite recorrer una rama concreta, como el Área comercial, sin tratar todos los elementos como una secuencia plana.

## ¿Qué ocurriría si un nodo tuviera más de un padre?

En un árbol convencional, cada nodo tiene un único padre, excepto la raíz, que no tiene padre. Si un nodo pudiera depender de varios padres, el modelo dejaría de ser un árbol convencional y normalmente se representaría mediante un grafo dirigido. Un grafo puede expresar varias relaciones, pero hay que controlar posibles ciclos y evitar procesar un mismo nodo repetidamente durante los recorridos.

## Reflexión (150–200 palabras)

Las estructuras lineales, como las listas, organizan los datos uno detrás de otro y son útiles cuando importa el orden de los elementos. Sin embargo, no representan de manera directa las relaciones de dependencia. En el organigrama empresarial de este proyecto, el gerente general dirige tres áreas y cada área contiene dos departamentos. Un árbol general permite expresar esa organización mediante nodos y enlaces entre padres e hijos, conservando la jerarquía y facilitando su lectura.

La implementación usa la clase genérica `NodoGeneral<T>`, por lo que el dato de cada nodo no está limitado a un único tipo de información. Cada nodo almacena una lista de hijos y puede tener cero, uno o varios descendientes. Los métodos de recorrido muestran la estructura en consola, cuentan los nodos y reconocen las hojas, que en este caso son los departamentos sin subdivisiones. Si una unidad dependiera de más de un área, un árbol convencional ya no sería suficiente; sería más adecuado analizar un grafo dirigido. Por eso, elegir una estructura de datos depende de las relaciones que existan en el problema real y no solamente de la cantidad de elementos.

## Cómo compilar y ejecutar

Se requiere tener instalado el JDK de Java. Abre una terminal en esta carpeta y ejecuta:

```bash
javac Main.java
java Main
```

## Archivos de la entrega

- `Main.java`: código Java compilable.
- `organigrama-referencia.png`: imagen de referencia del organigrama proporcionada para esta actividad.
- `README.md`: clasificación de escenarios, ventajas y reflexión.

## Git

Desde la carpeta raíz del repositorio:

```bash
git add 01-introduccion-arboles
git commit -m "Agrega guía 1: organigrama empresarial"
git push
```
