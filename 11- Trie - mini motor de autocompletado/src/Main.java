import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada del programa.
 * Carga un diccionario, ejecuta pruebas y permite probar prefijos por consola.
 */
public class Main {

    public static void main(String[] args) {
        Trie diccionario = new Trie();

        // Diccionario de más de 30 palabras para probar el autocompletado.
        String[] palabras = {
            "arbol", "archivo", "arco", "arena", "armario",
            "avion", "aviso", "azul", "barco", "biblioteca",
            "bicicleta", "blanco", "boca", "bosque", "botella",
            "cable", "cafe", "caja", "calle", "camino",
            "camisa", "cancion", "casa", "casamiento", "casco",
            "celular", "cereza", "cielo", "ciudad", "clase",
            "cocina", "color", "comida", "computadora", "conejo",
            "corazon", "cuaderno", "deporte", "dinosaurio", "escuela",
            "estrella", "familia", "flor", "futbol", "gato",
            "guitarra", "helado", "historia", "internet", "jardin",
            "lapiz", "libro", "luna", "manzana", "mariposa",
            "mesa", "montana", "musica", "naranja", "nube",
            "oceano", "ordenador", "perro", "planeta", "planta",
            "puerta", "raton", "reloj", "rio", "robot",
            "silla", "sol", "telefono", "tigre", "universidad",
            "ventana", "viaje", "zapato"
        };

        // Insertamos todas las palabras en la estructura Trie.
        for (String palabra : palabras) {
            diccionario.insertar(palabra);
        }

        System.out.println("======================================");
        System.out.println("   TRIE: MINI MOTOR DE AUTOCOMPLETADO");
        System.out.println("======================================");
        System.out.println("Palabras cargadas: " + palabras.length);

        // Cinco pruebas de prefijos, como solicita la guía.
        System.out.println("\n--- Cinco pruebas de prefijos ---");
        List<String> prefijosPrueba = Arrays.asList("ca", "com", "ar", "bi", "za");
        for (String prefijo : prefijosPrueba) {
            System.out.println("Prefijo \"" + prefijo + "\": "
                    + diccionario.sugerir(prefijo, 5));
        }

        // Pruebas de búsqueda de palabras completas y prefijos.
        System.out.println("\n--- Pruebas de búsqueda ---");
        System.out.println("¿Existe 'casa'? " + diccionario.buscar("casa"));
        System.out.println("¿Existe 'cas'? " + diccionario.buscar("cas"));
        System.out.println("¿Hay palabras que empiecen por 'tel'? "
                + diccionario.empiezaCon("tel"));

        // Permite al usuario experimentar con sus propios prefijos.
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nEscribe un prefijo para obtener hasta 5 sugerencias.");
        System.out.println("Escribe 'salir' para terminar.");

        while (true) {
            System.out.print("\nPrefijo: ");
            String prefijo = teclado.nextLine().trim();

            if (prefijo.equalsIgnoreCase("salir")) {
                break;
            }

            List<String> sugerencias = diccionario.sugerir(prefijo, 5);

            if (sugerencias.isEmpty()) {
                System.out.println("No se encontraron sugerencias para ese prefijo.");
            } else {
                System.out.println("Sugerencias: " + sugerencias);
            }
        }

        teclado.close();
        System.out.println("Programa finalizado.");
    }
}
