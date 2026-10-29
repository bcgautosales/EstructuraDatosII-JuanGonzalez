# 11- Trie - mini motor de autocompletado

**Asignatura:** Estructura de Datos II  
**Programa:** Ingeniería de Software / Ingeniería de Sistemas  
**Semestre:** IV  
**Lenguaje:** Java

## 1. Objetivo

Crear una estructura Trie propia para insertar palabras, buscar palabras completas,
comprobar prefijos y sugerir hasta cinco palabras que empiecen por un prefijo dado.

## 2. Estructura de carpetas

```text
11- Trie - mini motor de autocompletado/
├── src/
│   ├── Main.java
│   ├── NodoTrie.java
│   └── Trie.java
├── img/
│   └── diagrama-trie.png
└── README.md
```

## 3. ¿Qué es un Trie?

Un Trie es un árbol que guarda palabras compartiendo los caracteres iniciales.
Por ejemplo, las palabras `casa`, `casco` y `cama` comparten el primer carácter
`c`; las palabras `casa` y `casco` también comparten el camino `cas`.

Cada nodo tiene un mapa de hijos (`Map<Character, NodoTrie>`) y una marca
`finPalabra`. Esta marca permite diferenciar un prefijo de una palabra completa:
`cas` puede ser un prefijo válido aunque no esté guardado como palabra.

Consulta el dibujo en `img/diagrama-trie.png`.

## 4. Archivos principales

- **`NodoTrie.java`:** define cada nodo, sus hijos y la marca de fin de palabra.
- **`Trie.java`:** implementa inserción, búsqueda, validación de prefijos y sugerencias.
- **`Main.java`:** carga un diccionario de más de 30 palabras, ejecuta cinco pruebas
  de prefijos y permite probar el programa interactivamente.

## 5. Cómo ejecutar en Windows

Abre una terminal en la carpeta principal del proyecto. Comprueba que Java esté instalado:

```powershell
java -version
javac -version
```

Compila los archivos:

```powershell
javac -encoding UTF-8 -d out src\NodoTrie.java src\Trie.java src\Main.java
```

Ejecuta la aplicación:

```powershell
java -cp out Main
```

Cuando aparezca `Prefijo:`, escribe algo como `ca`, `com`, `ar`, `bi` o `za`.
Escribe `salir` para cerrar el programa.

## 6. Pruebas incluidas

Al iniciar, el programa muestra cinco pruebas:

| Prefijo | Ejemplos de resultados esperados |
|---|---|
| `ca` | caja, cable, cafe, calle, camino (máximo cinco) |
| `com` | comida, computadora |
| `ar` | arco, archivo, arena, armario, arbol |
| `bi` | biblioteca, bicicleta |
| `za` | zapato |

El orden de salida es alfabético. Las sugerencias están limitadas a cinco resultados.
También se prueba que `casa` exista como palabra completa, que `cas` no sea palabra
completa (aunque sí sea prefijo) y que existan palabras con el prefijo `tel`.

## 7. Complejidad

Sea **L** la longitud de la cadena buscada y **N** el número total de caracteres
almacenados en el Trie:

- **Insertar:** O(L) en promedio usando un mapa para cada nodo.
- **Buscar palabra:** O(L) en promedio; se revisan sus caracteres.
- **Comprobar prefijo:** O(L) en promedio.
- **Sugerir:** localizar el prefijo cuesta O(L); después se recorren los nodos
  descendientes necesarios para encontrar las sugerencias. El coste depende de la
  parte del árbol recorrida y de la longitud de las palabras devueltas.

Los costes de los mapas se consideran O(1) en promedio por acceso.

### Comparación con una lista de 1000 palabras

En una lista sin ordenar, buscar una palabra puede requerir revisar hasta 1000
elementos y comparar sus cadenas. Con el Trie, la búsqueda sigue los caracteres
de la palabra, por lo que su coste promedio depende principalmente de L y no de
cuántas palabras hay en el diccionario. Un Trie, sin embargo, puede consumir más
memoria porque mantiene nodos y mapas por carácter.

## 8. Evidencias para Moodle / GitHub

1. Captura de la ejecución donde se vean las cinco pruebas de prefijos.
2. Captura de una consulta manual, por ejemplo `ca`.
3. Captura de una búsqueda existente (`casa`) y otra no existente (`cas`).
4. Adjunta el diagrama `img/diagrama-trie.png`.
5. Sube los tres archivos Java y este README.

## 9. Ideas para explicar al docente

1. Los nodos comparten caminos cuando varias palabras empiezan igual.
2. `finPalabra` diferencia una palabra completa de un prefijo.
3. `sugerir` primero encuentra el nodo del prefijo y luego recorre sus descendientes.
4. El límite de cinco evita mostrar una lista excesiva de resultados.
