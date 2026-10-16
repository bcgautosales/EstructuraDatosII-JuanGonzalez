import java.util.ArrayList;
import java.util.List;

class NodoGeneral<T> {
    private final T dato;
    private final List<NodoGeneral<T>> hijos = new ArrayList<>();

    public NodoGeneral(T dato) {
        this.dato = dato;
    }

    public void agregarHijo(NodoGeneral<T> hijo) {
        if (hijo == null) {
            throw new IllegalArgumentException("El hijo no puede ser null.");
        }
        hijos.add(hijo);
    }

    public T getDato() {
        return dato;
    }

    public List<NodoGeneral<T>> getHijos() {
        return List.copyOf(hijos);
    }

    public boolean esHoja() {
        return hijos.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        // Nivel 0: raíz
        NodoGeneral<String> gerente = new NodoGeneral<>("Gerente general");

        // Nivel 1: áreas de la empresa
        NodoGeneral<String> administrativa = new NodoGeneral<>("Área administrativa");
        NodoGeneral<String> comercial = new NodoGeneral<>("Área comercial");
        NodoGeneral<String> tecnica = new NodoGeneral<>("Área técnica");

        gerente.agregarHijo(administrativa);
        gerente.agregarHijo(comercial);
        gerente.agregarHijo(tecnica);

        // Nivel 2: departamentos
        administrativa.agregarHijo(new NodoGeneral<>("Contabilidad"));
        administrativa.agregarHijo(new NodoGeneral<>("Recursos humanos"));

        comercial.agregarHijo(new NodoGeneral<>("Ventas"));
        comercial.agregarHijo(new NodoGeneral<>("Marketing"));

        tecnica.agregarHijo(new NodoGeneral<>("Soporte"));
        tecnica.agregarHijo(new NodoGeneral<>("Desarrollo"));

        System.out.println("=== ORGANIGRAMA EMPRESARIAL ===");
        imprimirArbol(gerente, 0);

        System.out.println("\nCantidad total de nodos: " + contarNodos(gerente));
        System.out.println("Cantidad de áreas: " + gerente.getHijos().size());
        System.out.println("Cantidad de departamentos/hojas: " + contarHojas(gerente));

        System.out.println("\n=== RECORRIDO EN PREORDEN ===");
        imprimirPreorden(gerente);
        System.out.println();

        System.out.println("\n=== DOS VENTAJAS DEL ÁRBOL FRENTE A UNA LISTA ===");
        System.out.println("1. Muestra visualmente quién dirige cada área y qué departamentos dependen de ella.");
        System.out.println("2. Permite recorrer o consultar una rama de la empresa sin perder la jerarquía.");
    }

    public static <T> void imprimirArbol(NodoGeneral<T> nodo, int nivel) {
        System.out.println("    ".repeat(nivel) + "- " + nodo.getDato());
        for (NodoGeneral<T> hijo : nodo.getHijos()) {
            imprimirArbol(hijo, nivel + 1);
        }
    }

    public static <T> int contarNodos(NodoGeneral<T> nodo) {
        int total = 1;
        for (NodoGeneral<T> hijo : nodo.getHijos()) {
            total += contarNodos(hijo);
        }
        return total;
    }

    public static <T> int contarHojas(NodoGeneral<T> nodo) {
        if (nodo.esHoja()) {
            return 1;
        }
        int total = 0;
        for (NodoGeneral<T> hijo : nodo.getHijos()) {
            total += contarHojas(hijo);
        }
        return total;
    }

    public static <T> void imprimirPreorden(NodoGeneral<T> nodo) {
        System.out.print(nodo.getDato() + " | ");
        for (NodoGeneral<T> hijo : nodo.getHijos()) {
            imprimirPreorden(hijo);
        }
    }
}
