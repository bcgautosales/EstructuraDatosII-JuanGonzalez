/**
 * Laboratorio: Mi primer árbol binario.
 * Construye y muestra cuatro clasificaciones: lleno, completo,
 * perfecto y degenerado.
 */
public class Main {
    public static void main(String[] args) {
        mostrar("ÁRBOL LLENO", crearArbolLleno());
        mostrar("ÁRBOL COMPLETO", crearArbolCompleto());
        mostrar("ÁRBOL PERFECTO", crearArbolPerfecto());
        mostrar("ÁRBOL DEGENERADO", crearArbolDegenerado());
    }

    // Cada nodo tiene cero o dos hijos.
    private static ArbolBinario<String> crearArbolLleno() {
        NodoArbol<String> a = nodo("Lamprea León");
        NodoArbol<String> b = nodo("González");
        NodoArbol<String> c = nodo("Gómez Villarreal");
        NodoArbol<String> d = nodo("Sanabria Rojas");
        NodoArbol<String> e = nodo("Lamprea León");
        a.setIzquierdo(b); a.setDerecho(c);
        b.setIzquierdo(d); b.setDerecho(e);
        return new ArbolBinario<>(a);
    }

    // Todos los niveles están llenos salvo quizá el último,
    // que se ocupa de izquierda a derecha.
    private static ArbolBinario<String> crearArbolCompleto() {
        NodoArbol<String> a = nodo("Lamprea León");
        NodoArbol<String> b = nodo("González");
        NodoArbol<String> c = nodo("Gómez Villarreal");
        NodoArbol<String> d = nodo("Sanabria Rojas");
        NodoArbol<String> e = nodo("Lamprea León");
        NodoArbol<String> f = nodo("González");
        a.setIzquierdo(b); a.setDerecho(c);
        b.setIzquierdo(d); b.setDerecho(e);
        c.setIzquierdo(f);
        return new ArbolBinario<>(a);
    }

    // Todos los nodos internos tienen dos hijos y todas las hojas
    // se encuentran al mismo nivel.
    private static ArbolBinario<String> crearArbolPerfecto() {
        NodoArbol<String> a = nodo("Lamprea León");
        NodoArbol<String> b = nodo("González");
        NodoArbol<String> c = nodo("Gómez Villarreal");
        NodoArbol<String> d = nodo("Sanabria Rojas");
        NodoArbol<String> e = nodo("Lamprea León");
        NodoArbol<String> f = nodo("González");
        NodoArbol<String> g = nodo("Sanabria Rojas");
        a.setIzquierdo(b); a.setDerecho(c);
        b.setIzquierdo(d); b.setDerecho(e);
        c.setIzquierdo(f); c.setDerecho(g);
        return new ArbolBinario<>(a);
    }

    // Cada nodo tiene como máximo un hijo; forma de lista.
    private static ArbolBinario<String> crearArbolDegenerado() {
        NodoArbol<String> a = nodo("Lamprea León");
        NodoArbol<String> b = nodo("González");
        NodoArbol<String> c = nodo("Gómez Villarreal");
        NodoArbol<String> d = nodo("Sanabria Rojas");
        NodoArbol<String> e = nodo("Lamprea León");
        a.setDerecho(b); b.setDerecho(c); c.setDerecho(d); d.setDerecho(e);
        return new ArbolBinario<>(a);
    }

    private static NodoArbol<String> nodo(String dato) {
        return new NodoArbol<>(dato);
    }

    private static void mostrar(String titulo, ArbolBinario<String> arbol) {
        System.out.println("\n========== " + titulo + " ==========");
        arbol.imprimirRaizYHijos();
        System.out.println("Estructura:");
        arbol.imprimirArbol();
        System.out.println("Cantidad de nodos: " + arbol.contarNodos());
        System.out.println("Cantidad de hojas: " + arbol.contarHojas());
        System.out.println("Altura: " + arbol.altura());
    }
}
