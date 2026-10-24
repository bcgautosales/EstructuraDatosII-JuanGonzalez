// Clase principal: aquí empieza la ejecución del programa.
public class Main {
    public static void main(String[] args) {
        // Creamos el árbol vacío donde vamos a guardar los productos.
        ArbolBSTProducto arbol = new ArbolBSTProducto();

        // Insertamos productos. El primer número es el código,
        // luego va el nombre y por último el precio.
        // El código determina dónde queda ubicado cada producto.
        arbol.insertar(new Producto(50, "Laptop", 2500)); // Será la raíz del árbol.
        arbol.insertar(new Producto(30, "Monitor", 800)); // Menor que 50: va a la izquierda.
        arbol.insertar(new Producto(70, "Tablet", 1200)); // Mayor que 50: va a la derecha.
        arbol.insertar(new Producto(20, "Teclado", 300));
        arbol.insertar(new Producto(40, "Impresora", 650));
        arbol.insertar(new Producto(60, "Cámara web", 950));
        arbol.insertar(new Producto(80, "Celular", 1450));
        arbol.insertar(new Producto(10, "Mouse", 150));
        arbol.insertar(new Producto(25, "Audífonos", 250));

        // Título que aparece en la consola al ejecutar el programa.
        System.out.println("========================================");
        System.out.println(" EXPLORADORES DEL ARBOL - PRODUCTOS");
        System.out.println(" Recorridos de un arbol binario de busqueda");
        System.out.println("========================================");

        // Cada método visita los mismos productos, pero en un orden distinto.
        arbol.preorden();   // Raíz, izquierda, derecha.
        arbol.inorden();    // Izquierda, raíz, derecha; los códigos quedan ordenados.
        arbol.postorden();  // Izquierda, derecha, raíz.
        arbol.porNiveles(); // Desde arriba hacia abajo, de izquierda a derecha.

        // Al final comprobamos automáticamente si Inorden dejó los códigos ordenados.
        System.out.println("\n¿Inorden devuelve las claves ordenadas?");
        if (arbol.comprobarInorden()) {
            System.out.println("Correcto: los códigos están ordenados de menor a mayor.");
        } else {
            System.out.println("Revisar: los códigos no están en orden ascendente.");
        }
    }
}
