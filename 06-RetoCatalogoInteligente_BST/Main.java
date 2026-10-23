
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Ejecuta las pruebas del catálogo tecnológico implementado con un BST.
 *
 * Compara el efecto de insertar productos en orden aleatorio y ascendente,
 * mide la altura de los árboles y analiza el comportamiento de las búsquedas.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos recibidos desde la terminal
     */
    public static void main(String[] args) {

        // Creamos la colección inicial de productos de nuestro catálogo.
        List<Producto> productos = crearProductos();

        // -----------------------------------------------------
        // ESCENARIO 1: INSERCIÓN EN ORDEN ALEATORIO
        // -----------------------------------------------------

        // Copiamos la lista para no alterar la colección original.
        List<Producto> aleatorios = new ArrayList<>(productos);

        // Usamos una semilla fija para repetir las mismas pruebas.
        Collections.shuffle(aleatorios, new Random(24));

        // Creamos el árbol que recibirá los productos aleatorios.
        ArbolBSTCatalogo bstAleatorio = new ArbolBSTCatalogo();

        // Insertamos cada producto en el árbol.
        for (Producto producto : aleatorios) {
            bstAleatorio.insertar(producto);
        }

        // -----------------------------------------------------
        // ESCENARIO 2: INSERCIÓN EN ORDEN ASCENDENTE
        // -----------------------------------------------------

        // Creamos otra copia independiente de la lista.
        List<Producto> ordenados = new ArrayList<>(productos);

        // Organizamos los productos desde el código menor al mayor.
        ordenados.sort(
                (a, b) -> Integer.compare(
                        a.getCodigo(),
                        b.getCodigo()
                )
        );

        // Construimos un segundo árbol para comparar los resultados.
        ArbolBSTCatalogo bstOrdenado = new ArbolBSTCatalogo();

        // Insertamos los productos siguiendo el orden ascendente.
        for (Producto producto : ordenados) {
            bstOrdenado.insertar(producto);
        }

        // -----------------------------------------------------
        // MOSTRAR LOS ÓRDENES DE INSERCIÓN
        // -----------------------------------------------------

        System.out.println("========================================");
        System.out.println("   INVENTARIO TECNOLÓGICO - BST");
        System.out.println("========================================");

        System.out.println("\nSecuencia de inserción aleatoria:");
        imprimirCodigos(aleatorios);

        System.out.println("\nSecuencia de inserción ascendente:");
        imprimirCodigos(ordenados);

        // -----------------------------------------------------
        // MOSTRAR LA FORMA Y ALTURA DE LOS ÁRBOLES
        // -----------------------------------------------------

        System.out.println("\n--- ÁRBOL CON INSERCIÓN ALEATORIA ---");
        bstAleatorio.imprimirArbol();
        System.out.println("Altura del árbol: " + bstAleatorio.altura());

        System.out.println("\n--- ÁRBOL CON INSERCIÓN ASCENDENTE ---");
        bstOrdenado.imprimirArbol();
        System.out.println("Altura del árbol: " + bstOrdenado.altura());

        // -----------------------------------------------------
        // REALIZAR BÚSQUEDAS EN AMBOS ÁRBOLES
        // -----------------------------------------------------

        // Código de un producto que sí existe en el catálogo.
        int codigoExistente = 120;

        // Código que no existe en el catálogo.
        int codigoInexistente = 725;

        System.out.println("\n--- BÚSQUEDAS: ÁRBOL ALEATORIO ---");
        mostrarBusqueda(bstAleatorio, codigoExistente);
        mostrarBusqueda(bstAleatorio, codigoInexistente);

        System.out.println("\n--- BÚSQUEDAS: ÁRBOL ASCENDENTE ---");
        mostrarBusqueda(bstOrdenado, codigoExistente);
        mostrarBusqueda(bstOrdenado, codigoInexistente);

        // -----------------------------------------------------
        // COMPARAR LOS RESULTADOS
        // -----------------------------------------------------

        int alturaAleatoria = bstAleatorio.altura();
        int alturaAscendente = bstOrdenado.altura();

        System.out.println("\n========================================");
        System.out.println("       RESUMEN DE LA COMPARACIÓN");
        System.out.println("========================================");

        System.out.println(
                "Altura del árbol aleatorio: " + alturaAleatoria
        );

        System.out.println(
                "Altura del árbol ascendente: " + alturaAscendente
        );

        // Una altura mayor indica un recorrido máximo potencialmente mayor.
        if (alturaAleatoria < alturaAscendente) {
            System.out.println(
                    "El árbol aleatorio obtuvo una altura menor."
            );
        } else if (alturaAleatoria > alturaAscendente) {
            System.out.println(
                    "El árbol aleatorio obtuvo una altura mayor."
            );
        } else {
            System.out.println(
                    "Los dos árboles tienen la misma altura."
            );
        }

        System.out.println(
                "\nConclusión: el orden de inserción influye en la forma "
                + "del árbol BST. Cuando los códigos se insertan en orden "
                + "ascendente, cada nuevo código puede quedar a la derecha "
                + "del anterior. Esto genera un árbol parecido a una lista "
                + "y puede hacer que las búsquedas sean más lentas."
        );

        // -----------------------------------------------------
        // MOSTRAR LOS PRODUCTOS ORDENADOS POR CÓDIGO
        // -----------------------------------------------------

        System.out.println("\n--- CATÁLOGO EN ORDEN DE CÓDIGO ---");
        bstAleatorio.mostrarInorden();
    }

    /**
     * Busca un código y muestra el resultado detallado.
     *
     * @param arbol árbol en el que se realizará la búsqueda
     * @param codigo código que se desea localizar
     */
    private static void mostrarBusqueda(
            ArbolBSTCatalogo arbol,
            int codigo) {

        // Ejecutamos la búsqueda que registra el recorrido y las comparaciones.
        ResultadoBusqueda resultado = arbol.buscarConTraza(codigo);

        System.out.println("\nCódigo consultado: " + codigo);
        System.out.println("¿Encontrado?: " + resultado.encontrado());

        System.out.println(
                "Nodos comparados: " + resultado.getComparaciones()
        );

        System.out.println(
                "Recorrido: " + resultado.getCamino()
        );

        // Solo mostramos los detalles si el producto existe.
        if (resultado.encontrado()) {
            System.out.println(
                    "Datos del producto: " + resultado.getProducto()
            );
        }
    }

    /**
     * Imprime los códigos en el mismo orden en que aparecen en la lista.
     *
     * @param productos lista de productos que se desea mostrar
     */
    private static void imprimirCodigos(List<Producto> productos) {

        for (Producto producto : productos) {
            System.out.print(producto.getCodigo() + " ");
        }

        // Finalizamos la línea después de imprimir todos los códigos.
        System.out.println();
    }

    /**
     * Crea los datos de prueba del inventario tecnológico.
     *
     * @return lista inicial de productos del catálogo
     */
    private static List<Producto> crearProductos() {

        List<Producto> lista = new ArrayList<>();

        // Código, nombre, categoría y precio de cada producto.
        lista.add(new Producto(120, "Teclado mecánico", "Periféricos", 185000));
        lista.add(new Producto(60, "Mouse inalámbrico", "Periféricos", 72000));
        lista.add(new Producto(180, "Monitor LED", "Pantallas", 640000));
        lista.add(new Producto(40, "Memoria USB", "Almacenamiento", 35000));
        lista.add(new Producto(90, "Disco SSD", "Almacenamiento", 245000));
        lista.add(new Producto(220, "Memoria RAM", "Componentes", 160000));
        lista.add(new Producto(200, "Fuente de poder", "Componentes", 275000));
        lista.add(new Producto(320, "Router Wi-Fi", "Redes", 210000));
        lista.add(new Producto(280, "Adaptador de red", "Redes", 65000));
        lista.add(new Producto(400, "Portátil", "Computadores", 2850000));
        lista.add(new Producto(360, "Tableta gráfica", "Accesorios", 430000));
        lista.add(new Producto(460, "Impresora láser", "Oficina", 780000));
        lista.add(new Producto(440, "Cámara web HD", "Periféricos", 135000));
        lista.add(new Producto(520, "Proyector", "Presentación", 1150000));
        lista.add(new Producto(480, "Audífonos USB", "Audio", 98000));

        return lista;
    }
}
