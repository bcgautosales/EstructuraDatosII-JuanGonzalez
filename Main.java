
public class Main {

    public static void main(String[] args) {

        int[] codigosAleatorios = {
            45, 20, 70, 10, 30,
            60, 80, 25, 35, 55,
            65, 75, 90, 15, 50
        };

        int[] codigosOrdenados = {
            10, 15, 20, 25, 30,
            35, 45, 50, 55, 60,
            65, 70, 75, 80, 90
        };

        ArbolBST aleatorio = crearArbol(codigosAleatorios);
        ArbolBST ordenado = crearArbol(codigosOrdenados);

        System.out.println("CATALOGO INTELIGENTE - BST");
        System.out.println("====================================");

        System.out.println("\nARBOL CON INSERCION ALEATORIA");
        System.out.println("Altura: " + aleatorio.altura());

        System.out.println("\nARBOL CON INSERCION ORDENADA");
        System.out.println("Altura: " + ordenado.altura());

        int[] pruebas = {25, 65, 50, 90, 100};

        System.out.println("\nBUSQUEDAS EN AMBOS ARBOLES");
        System.out.println("------------------------------------");

        int totalAleatorio = 0;
        int totalOrdenado = 0;

        for (int codigo : pruebas) {
            System.out.println("\nBuscar " + codigo + ":");

            String detalleAleatorio =
                aleatorio.buscarDetallado(codigo);

            String detalleOrdenado =
                ordenado.buscarDetallado(codigo);

            System.out.println("Aleatorio: " + detalleAleatorio);
            System.out.println("Ordenado:  " + detalleOrdenado);

            totalAleatorio += contarComparaciones(detalleAleatorio);
            totalOrdenado += contarComparaciones(detalleOrdenado);
        }

        System.out.println("\nTABLA COMPARATIVA");
        System.out.println("------------------------------------");
        System.out.printf("%-22s %10s %15s%n",
            "Tipo de arbol", "Altura", "Prom. comparaciones");

        System.out.printf("%-22s %10d %15.2f%n",
            "Aleatorio",
            aleatorio.altura(),
            totalAleatorio / (double) pruebas.length);

        System.out.printf("%-22s %10d %15.2f%n",
            "Ordenado",
            ordenado.altura(),
            totalOrdenado / (double) pruebas.length);

        System.out.println("\nCONCLUSION");
        System.out.println(
            "El orden de insercion afecta la forma y eficiencia del BST.");
    }

    private static ArbolBST crearArbol(int[] codigos) {
        ArbolBST arbol = new ArbolBST();

        for (int codigo : codigos) {
            arbol.insertar(codigo);
        }

        return arbol;
    }

    private static int contarComparaciones(String detalle) {
        String etiqueta = "Comparaciones: ";
        int inicio = detalle.lastIndexOf(etiqueta);

        return Integer.parseInt(
            detalle.substring(inicio + etiqueta.length()).trim()
        );
    }
}
