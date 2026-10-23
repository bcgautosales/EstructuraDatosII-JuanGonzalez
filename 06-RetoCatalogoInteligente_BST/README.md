# Reto: Catálogo Inteligente

## Descripción del proyecto

Este proyecto está desarrollado en Java y permite administrar un catálogo de productos tecnológicos mediante un **Árbol Binario de Búsqueda (BST)**.

Cada producto tiene un código único, nombre, categoría y precio. El código se utiliza como clave para organizar los productos dentro del árbol y facilitar las operaciones de inserción y búsqueda.

El proyecto también permite comparar el comportamiento de dos árboles: uno construido con productos insertados en un orden aleatorio y otro construido con los productos ordenados de menor a mayor código.

## Objetivos

- Almacenar productos tecnológicos utilizando el código como clave.
- Implementar la inserción recursiva de productos en un BST.
- Implementar la búsqueda recursiva de productos.
- Registrar las comparaciones realizadas durante una búsqueda.
- Mostrar el recorrido seguido por el algoritmo para encontrar un producto.
- Calcular la altura del árbol binario de búsqueda.
- Comparar la altura de un árbol construido con inserciones aleatorias y otro con inserciones ordenadas.
- Mostrar los productos en orden ascendente mediante un recorrido inorden.

## Estructura del proyecto

El proyecto está compuesto por los siguientes archivos:

| Archivo | Función |
|---|---|
| `Producto.java` | Representa los productos del catálogo y almacena su código, nombre, categoría y precio. |
| `NodoProducto.java` | Representa cada nodo del árbol y contiene el producto y las referencias a sus hijos izquierdo y derecho. |
| `ResultadoBusqueda.java` | Almacena el resultado de una búsqueda, la cantidad de comparaciones y el camino recorrido. |
| `ArbolBSTCatalogo.java` | Implementa las operaciones del árbol: inserción, búsqueda, recorrido inorden, cálculo de altura e impresión. |
| `Main.java` | Ejecuta el programa, crea los productos, construye los árboles y presenta los resultados de las pruebas. |

## Regla de organización del BST

El árbol se organiza utilizando el código de cada producto como clave:

- **Código menor:** se ubica en el subárbol izquierdo.
- **Código mayor:** se ubica en el subárbol derecho.
- **Código duplicado:** la implementación actual rechaza los códigos repetidos mediante una excepción.

Esta organización permite recorrer el árbol siguiendo las comparaciones entre los códigos.

## Inserción y búsqueda recursivas

### Inserción

El método de inserción compara el código del producto con el código del nodo actual. Si el nuevo código es menor, continúa por la izquierda; si es mayor, continúa por la derecha.

El proceso se repite recursivamente hasta encontrar una posición vacía donde se pueda insertar el nuevo nodo.

### Búsqueda

El método de búsqueda compara el código solicitado con el código del nodo actual:

- Si los códigos coinciden, devuelve el producto encontrado.
- Si el código buscado es menor, continúa por la izquierda.
- Si es mayor, continúa por la derecha.
- Si llega a una referencia vacía (`null`), significa que el producto no existe en el catálogo.

El programa también permite mostrar las comparaciones realizadas y el camino seguido durante la búsqueda.

## Comparación de los árboles

El programa construye dos árboles a partir de los mismos productos:

1. **Árbol de inserción aleatoria:** los productos se insertan en un orden mezclado. Se utiliza una semilla fija (`24`) para que el orden aleatorio sea reproducible en las ejecuciones.
2. **Árbol de inserción ordenada:** los productos se insertan desde el código menor hasta el mayor.

Después se comparan las alturas y los resultados de búsqueda de ambos árboles.

Cuando los datos se insertan en orden ascendente, el BST puede degenerar en una estructura similar a una lista enlazada. Esto aumenta la cantidad de comparaciones necesarias para buscar un producto.

## Convención de altura

Para calcular la altura del árbol se utiliza la siguiente convención:

- Árbol vacío: `-1`.
- Nodo hoja: `0`.
- Altura del árbol: número máximo de aristas desde la raíz hasta una hoja.

La altura se calcula recursivamente, obteniendo la altura de los subárboles izquierdo y derecho y tomando el mayor de los dos.

## Productos de prueba

El catálogo contiene 15 productos tecnológicos, identificados por códigos únicos. Entre ellos se encuentran teclados, ratones, monitores, memorias, discos SSD, componentes, dispositivos de red, computadores y accesorios.

El programa prueba la búsqueda de un producto existente, como el teclado mecánico con código `120`, y de un código inexistente, como `725`.

## Cómo compilar el proyecto

Abre la terminal de Visual Studio Code en la carpeta donde se encuentran los archivos `.java` y ejecuta:

```bash
javac Producto.java NodoProducto.java ResultadoBusqueda.java ArbolBSTCatalogo.java Main.java
```

Si no aparecen errores, los archivos se compilaron correctamente.

## Cómo ejecutar el proyecto

Después de compilar, ejecuta:

```bash
java Main
```

El programa mostrará los órdenes de inserción, las estructuras de los árboles, sus alturas, los resultados de las búsquedas y el listado de productos ordenado por código.

## Conclusiones

Los árboles binarios de búsqueda permiten organizar datos y realizar búsquedas mediante comparaciones entre claves. Su eficiencia depende de la forma en que se distribuyen los nodos.

Un árbol equilibrado puede realizar búsquedas en un tiempo aproximado de `O(log n)`, mientras que un árbol degenerado puede necesitar hasta `O(n)` operaciones.

Por esta razón, comparar la inserción aleatoria con la inserción ordenada permite observar cómo la estructura del árbol influye en su altura y en el rendimiento de las búsquedas.
