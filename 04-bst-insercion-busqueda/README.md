
# Catálogo Inteligente - Árbol Binario de Búsqueda

## Asignatura
Estructura de Datos II

Ingeniería de Software / Ingeniería de Sistemas
Semestre IV

## Objetivo
Implementar inserción y búsqueda recursiva mediante un
árbol binario de búsqueda (BST), y analizar su eficiencia
con códigos de productos en distintos órdenes.

## Estructura
- NodoArbol.java: representa cada nodo del árbol.
- ArbolBST.java: implementa inserción, búsqueda y altura.
- Main.java: ejecuta pruebas y presenta los resultados.

## Propiedad BST
Los valores menores que un nodo se ubican a la izquierda.
Los valores mayores o iguales se ubican a la derecha.

## Pruebas realizadas
Se utilizan 15 códigos de productos para construir dos
árboles con los mismos datos:

1. Inserción en un orden no ascendente ni descendente.
2. Inserción en orden ascendente.

Se ejecutan cinco búsquedas: cuatro códigos existentes
y uno inexistente.

## Resultados
El árbol de inserción aleatoria alcanza una altura de
4 niveles y un promedio de 4,2 comparaciones.

El árbol de inserción ordenada alcanza una altura de
15 niveles y un promedio de 10,6 comparaciones.

Los resultados muestran que el orden de inserción puede
afectar considerablemente la estructura y el rendimiento.

## Complejidad
- Inserción: O(log n) promedio en árboles equilibrados.
- Búsqueda: O(log n) promedio en árboles equilibrados.
- Inserción y búsqueda: O(n) en el peor caso degenerado.
- Cálculo de altura: O(n), porque se visitan los nodos.

## Conclusión
Un BST permite organizar y localizar códigos siguiendo
un único camino. Sin embargo, si los datos se insertan
ordenadamente, el árbol puede degenerarse y perder
eficiencia. Un árbol balanceado ayuda a mantener
operaciones más eficientes.
