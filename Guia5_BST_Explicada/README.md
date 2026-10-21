# Guía 5: Árbol binario de búsqueda (BST)

**Tema:** eliminar nodos en Java.

## ¿Qué hace el programa?
Crea un árbol, busca números, los elimina y comprueba que el árbol siga ordenado.

Regla fácil de recordar:
- Los números menores van a la izquierda.
- Los números mayores van a la derecha.

## Pruebas que realiza

### 1. Eliminar una hoja
Se elimina el `15`. Como no tiene hijos, simplemente se quita del árbol.

### 2. Eliminar un nodo con un hijo
Se elimina el `55`, que tiene como hijo al `58`. En vez del `55`, el árbol conecta directamente con el `58`.

### 3. Eliminar un nodo con dos hijos (la raíz)
Se elimina el `45`. Como tiene dos hijos, se busca el número más pequeño del lado derecho: `55`. Ese número reemplaza al `45` y luego se elimina su ubicación original.

### 4. Eliminar un número que no existe
Se intenta eliminar el `999`. Como no está en el árbol, nada cambia.

## ¿Para qué sirve cada archivo?
- `Main.java`: ejecuta las pruebas y muestra los resultados.
- `ArbolBST.java`: contiene las operaciones del árbol, incluida la eliminación.
- `NodoArbol.java`: representa cada número y sus conexiones con los hijos.
- `Resultado.txt`: ejemplo de lo que aparece en consola.

## Cómo ejecutar
Abre una terminal dentro de esta carpeta y escribe:

```bash
javac NodoArbol.java ArbolBST.java Main.java
java Main
```

## Explicación sencilla para el profesor
“Este programa muestra tres formas de eliminar en un árbol binario de búsqueda. Si el nodo no tiene hijos, se quita. Si tiene un solo hijo, ese hijo ocupa su lugar. Si tiene dos hijos, se reemplaza por el menor número del lado derecho. Al final se comprueba que el árbol siga ordenado y que el número eliminado ya no aparezca.”
