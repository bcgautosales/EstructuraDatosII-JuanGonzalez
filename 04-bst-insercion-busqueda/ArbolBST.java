
public class ArbolBST {

    private NodoArbol<Integer> raiz;

    public ArbolBST() {
        raiz = null;
    }

    public void insertar(int codigo) {
        raiz = insertarRec(raiz, codigo);
    }

    private NodoArbol<Integer> insertarRec(
            NodoArbol<Integer> nodo, int codigo) {

        if (nodo == null) {
            return new NodoArbol<>(codigo);
        }

        if (codigo < nodo.getDato()) {
            nodo.setIzquierdo(
                insertarRec(nodo.getIzquierdo(), codigo));
        } else {
            // Los valores iguales se ubican a la derecha.
            nodo.setDerecho(
                insertarRec(nodo.getDerecho(), codigo));
        }

        return nodo;
    }

    public boolean buscar(int codigo) {
        return buscarRec(raiz, codigo);
    }

    private boolean buscarRec(
            NodoArbol<Integer> nodo, int codigo) {

        if (nodo == null) {
            return false;
        }

        if (codigo == nodo.getDato()) {
            return true;
        }

        if (codigo < nodo.getDato()) {
            return buscarRec(nodo.getIzquierdo(), codigo);
        }

        return buscarRec(nodo.getDerecho(), codigo);
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol<Integer> nodo) {
        if (nodo == null) {
            return 0;
        }

        int izquierda = alturaRec(nodo.getIzquierdo());
        int derecha = alturaRec(nodo.getDerecho());

        return 1 + Math.max(izquierda, derecha);
    }

    public String buscarDetallado(int codigo) {
        StringBuilder camino = new StringBuilder();
        int[] comparaciones = {0};

        boolean encontrado = buscarDetalleRec(
            raiz, codigo, camino, comparaciones);

        return "Código: " + codigo
            + " | Resultado: "
            + (encontrado ? "Encontrado" : "No encontrado")
            + " | Camino: " + camino
            + " | Comparaciones: " + comparaciones[0];
    }

    private boolean buscarDetalleRec(
            NodoArbol<Integer> nodo,
            int codigo,
            StringBuilder camino,
            int[] comparaciones) {

        if (nodo == null) {
            camino.append("null");
            return false;
        }

        if (camino.length() > 0) {
            camino.append(" -> ");
        }

        camino.append(nodo.getDato());
        comparaciones[0]++;

        if (codigo == nodo.getDato()) {
            return true;
        }

        if (codigo < nodo.getDato()) {
            return buscarDetalleRec(
                nodo.getIzquierdo(), codigo,
                camino, comparaciones);
        }

        return buscarDetalleRec(
            nodo.getDerecho(), codigo,
            camino, comparaciones);
    }
}
