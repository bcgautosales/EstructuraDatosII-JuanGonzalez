# Laboratorio: Mi primer árbol binario

**Objetivo:** construir cuatro árboles binarios enlazando referencias izquierda y derecha con `NodoArbol<T>` y mostrar su estructura en Java.

## Clasificación y diagramas

### 1. Árbol lleno
Cada nodo tiene cero o dos hijos.

```text
      A
     / \\
    B   C
   / \\
  D   E
```

### 2. Árbol completo
Todos los niveles anteriores al último están llenos y el último se ocupa de izquierda a derecha.

```text
      A
     / \\
    B   C
   / \\ /
  D  E F
```

### 3. Árbol perfecto
Todos los nodos internos tienen dos hijos y todas las hojas están al mismo nivel.

```text
        A
      /   \\
     B     C
    / \\   / \\
   D   E  F   G
```

### 4. Árbol degenerado
Cada nodo tiene como máximo un hijo; se parece a una lista enlazada.

```text
A
 \\
  B
   \\
    C
     \\
      D
       \\
        E
```

## Archivos
- `NodoArbol.java`: nodo genérico con dato, referencias izquierda/derecha, constructor, getters, setters y métodos básicos.
- `ArbolBinario.java`: operaciones para mostrar el árbol, contar nodos, contar hojas y calcular la altura.
- `Main.java`: construye y ejecuta los cuatro ejemplos usando los apellidos Lamprea León, González, Gómez Villarreal y Sanabria Rojas; algunos se repiten para completar la cantidad de nodos de cada árbol.

## Cómo ejecutar
1. Instala un JDK de Java.
2. Abre una terminal en la carpeta del proyecto.
3. Compila: `javac *.java`
4. Ejecuta: `java Main`

También puedes abrir la carpeta en NetBeans o IntelliJ y ejecutar la clase `Main`.

## Pruebas esperadas
- Árbol lleno: 5 nodos, 3 hojas, altura 2.
- Árbol completo: 6 nodos, 3 hojas, altura 2.
- Árbol perfecto: 7 nodos, 4 hojas, altura 2.
- Árbol degenerado: 5 nodos, 1 hoja, altura 4.

## GitHub
Desde esta carpeta puedes registrar el proyecto con:

```bash
git init
git add .
git commit -m "Implementa cuatro clasificaciones de arboles binarios"
```

Después crea un repositorio vacío en GitHub y sigue las instrucciones que GitHub muestre para conectar y subir el repositorio. No se incluye una captura real de ejecución ni un commit remoto porque deben generarse desde tu equipo y tu cuenta.
