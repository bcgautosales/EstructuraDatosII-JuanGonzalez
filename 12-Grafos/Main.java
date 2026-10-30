import java.util.List;

/**
 * Ejemplo sencillo de un grafo para representar rutas entre ciudades.
 *
 * <p><b>Dominio:</b> transporte terrestre entre 10 ciudades de Colombia.<br>
 * <b>Vértices:</b> 10 ciudades. <b>Aristas:</b> 17 rutas (12 de doble vía, no
 * dirigidas, y 5 expresos de un solo sentido, dirigidos).<br>
 * <b>Peso:</b> distancia aproximada por carretera en km (valores referenciales
 * con fines académicos).</p>
 *
 * <p>Compilar: {@code javac -encoding UTF-8 *.java}<br>
 * Ejecutar: {@code java Main}</p>
 */
public class Main {

    public static void main(String[] args) {
        Grafo grafoRutas = construirRedDeTransporte();

        imprimirTablaVertices(grafoRutas);
        imprimirTablaAristas(grafoRutas);
        imprimirClasificacion(grafoRutas);
        imprimirEjercicios(grafoRutas);
    }

    /** Construye el grafo del dominio de transporte (10 vértices, 17 aristas). */
    static Grafo construirRedDeTransporte() {
        Grafo grafo = new Grafo();

        // Creamos las 10 ciudades que serán los vértices del grafo.
        grafo.agregarVertice(new Vertice("Pereira", "Risaralda"));
        grafo.agregarVertice(new Vertice("Armenia", "Quindío"));
        grafo.agregarVertice(new Vertice("Manizales", "Caldas"));
        grafo.agregarVertice(new Vertice("Cartago", "Valle del Cauca"));
        grafo.agregarVertice(new Vertice("Cali", "Valle del Cauca"));
        grafo.agregarVertice(new Vertice("Ibagué", "Tolima"));
        grafo.agregarVertice(new Vertice("Medellín", "Antioquia"));
        grafo.agregarVertice(new Vertice("La Dorada", "Caldas"));
        grafo.agregarVertice(new Vertice("Honda", "Tolima"));
        grafo.agregarVertice(new Vertice("Bogotá", "Cundinamarca"));

        // Rutas de doble vía: se pueden recorrer en ambos sentidos. El número es la distancia en km.
        grafo.agregarArista(new Arista("Pereira", "Armenia", 44, false));
        grafo.agregarArista(new Arista("Pereira", "Manizales", 52, false));
        grafo.agregarArista(new Arista("Pereira", "Cartago", 40, false));
        grafo.agregarArista(new Arista("Armenia", "Ibagué", 105, false));
        grafo.agregarArista(new Arista("Armenia", "Cali", 190, false));
        grafo.agregarArista(new Arista("Cartago", "Cali", 190, false));
        grafo.agregarArista(new Arista("Manizales", "Medellín", 215, false));
        grafo.agregarArista(new Arista("Pereira", "Medellín", 220, false));
        grafo.agregarArista(new Arista("Manizales", "La Dorada", 125, false));
        grafo.agregarArista(new Arista("La Dorada", "Honda", 35, false));
        grafo.agregarArista(new Arista("Honda", "Bogotá", 170, false));
        grafo.agregarArista(new Arista("Ibagué", "Bogotá", 200, false));

        // Rutas de un solo sentido: solo se puede viajar del origen al destino.
        grafo.agregarArista(new Arista("Medellín", "Bogotá", 415, true));
        grafo.agregarArista(new Arista("Bogotá", "Cali", 460, true));
        grafo.agregarArista(new Arista("Cali", "Pereira", 215, true));
        grafo.agregarArista(new Arista("La Dorada", "Medellín", 180, true));
        grafo.agregarArista(new Arista("Honda", "Ibagué", 110, true));

        return grafo;
    }

    // ------------------------------------------------------------------
    // Salida por consola (evidencias para el informe)
    // ------------------------------------------------------------------

    static void imprimirTablaVertices(Grafo grafo) {
        System.out.println("=== TABLA DE VÉRTICES (V) ===");
        System.out.printf("%-4s %-12s %-16s %-7s %-7s %-7s%n",
                "N°", "Ciudad", "Departamento", "Grado", "G.sal", "G.ent");
        int i = 1;
        for (Vertice v : grafo.getVertices()) {
            System.out.printf("%-4d %-12s %-16s %-7d %-7d %-7d%n", i++, v.nombre, v.departamento,
                    grafo.gradoIncidente(v.nombre), grafo.gradoSalida(v.nombre), grafo.gradoEntrada(v.nombre));
        }
        System.out.println("|V| = " + grafo.numVertices());
        System.out.println();
    }

    static void imprimirTablaAristas(Grafo grafo) {
        System.out.println("=== TABLA DE ARISTAS (A) ===");
        System.out.printf("%-4s %-12s %-12s %-10s %-10s%n", "N°", "Origen", "Destino", "Peso (km)", "Tipo");
        int i = 1;
        for (Arista a : grafo.getAristas()) {
            System.out.printf("%-4d %-12s %-12s %-10.0f %-10s%n", i++, a.origen, a.destino, a.peso,
                    a.dirigida ? "Dirigida" : "No dirig.");
        }
        System.out.println("|A| = " + grafo.numAristas() + " (" + grafo.numNoDirigidas()
                + " no dirigidas + " + grafo.numDirigidas() + " dirigidas)");
        System.out.println();
    }

    static void imprimirClasificacion(Grafo grafo) {
        System.out.println("=== CLASIFICACIÓN FORMAL: G = (V, A) ===");
        System.out.println("Orden |V|          : " + grafo.numVertices());
        System.out.println("Tamaño |A|         : " + grafo.numAristas());
        System.out.println("Arcos reales       : " + grafo.numArcos() + " (dirigida = 1, no dirigida = 2)");
        System.out.println("Dirección          : " + grafo.tipoDireccion());
        System.out.println("Ponderado          : " + (grafo.esPonderado() ? "sí (km)" : "no"));
        System.out.println("Conexo (débil)     : " + (grafo.esConexo() ? "sí" : "no"));
        System.out.println("Fuertemente conexo : " + (grafo.esFuertementeConexo() ? "sí" : "no"));
        System.out.println("Cíclico            : " + (grafo.esCiclico() ? "sí" : "no (acíclico)"));
        System.out.printf("Densidad D         : %d / (%d·%d) = %.3f -> %s%n",
                grafo.numArcos(), grafo.numVertices(), grafo.numVertices() - 1, grafo.densidad(),
                grafo.esDenso() ? "DENSO" : "DISPERSO");
        System.out.printf("Peso total         : %.0f km%n", grafo.pesoTotal());
        System.out.println();
    }

    static void imprimirEjercicios(Grafo grafo) {
        System.out.println("=== EJERCICIOS ===");

        // Ejercicio 1: convertir cada ruta de doble vía en dos rutas dirigidas.
        Grafo grafoDirigido = grafo.convertirADirigido();
        System.out.println("1) Conversión a grafo dirigido:");
        System.out.println("   Original : " + grafo.numAristas() + " aristas ("
                + grafo.numNoDirigidas() + " no dirigidas, " + grafo.numDirigidas() + " dirigidas)");
        System.out.println("   Dirigido : " + grafoDirigido.numAristas() + " aristas (tipo: "
                + grafoDirigido.tipoDireccion() + ")");
        System.out.println("   Cada ruta de doble vía pasó a ser 2 rutas de un solo sentido.");

        // Ejercicio 2: buscar un recorrido que vuelva a un vértice ya visitado.
        List<String> ciclo = grafo.buscarCiclo();
        System.out.println("2) Ciclo encontrado: " + (ciclo.isEmpty() ? "ninguno" : String.join(" -> ", ciclo)));

        // Ejercicio 3: medir cuántas conexiones existen frente a las posibles.
        System.out.printf("3) Densidad = %.3f -> el grafo es %s (umbral %.1f)%n",
                grafo.densidad(), grafo.esDenso() ? "denso" : "disperso", Grafo.UMBRAL_DENSIDAD);
    }
}
