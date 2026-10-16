public class Main {

    public static void main(String[] args) {

        // ============================================================
        // 1. CREACION DE LOS NODOS
        // ============================================================

        // RAIZ: nodo principal del arbol.
        NodoGeneral<String> empresa =
                new NodoGeneral<>("PIXEL STUDIOS");

        // Nivel 1: areas principales de la empresa.
        NodoGeneral<String> desarrollo =
                new NodoGeneral<>("Desarrollo de Videojuegos");

        NodoGeneral<String> diseno =
                new NodoGeneral<>("Diseno y Arte");

        NodoGeneral<String> sonido =
                new NodoGeneral<>("Audio y Sonido");

        // Nivel 2: equipos de cada area.
        NodoGeneral<String> programacion =
                new NodoGeneral<>("Programacion");

        NodoGeneral<String> pruebas =
                new NodoGeneral<>("Pruebas y Calidad");

        NodoGeneral<String> modelado =
                new NodoGeneral<>("Modelado 3D");

        NodoGeneral<String> animacion =
                new NodoGeneral<>("Animacion");

        NodoGeneral<String> musica =
                new NodoGeneral<>("Musica");

        NodoGeneral<String> efectos =
                new NodoGeneral<>("Efectos de Sonido");

        // Nivel 3: proyectos y equipos especializados.
        NodoGeneral<String> inteligenciaArtificial =
                new NodoGeneral<>("Inteligencia Artificial");

        NodoGeneral<String> multijugador =
                new NodoGeneral<>("Modo Multijugador");

        NodoGeneral<String> personajes =
                new NodoGeneral<>("Personajes 3D");

        NodoGeneral<String> escenarios =
                new NodoGeneral<>("Escenarios Virtuales");

        NodoGeneral<String> bandaSonora =
                new NodoGeneral<>("Banda Sonora");

        // CAMBIO 1: nodo adicional para probar un nuevo nivel.
        NodoGeneral<String> proyectoIA =
                new NodoGeneral<>("Proyecto IA Generativa");

        // ============================================================
        // 2. CONSTRUCCION DE LA JERARQUIA
        // ============================================================

        empresa.agregarHijo(desarrollo);
        empresa.agregarHijo(diseno);
        empresa.agregarHijo(sonido);

        desarrollo.agregarHijo(programacion);
        desarrollo.agregarHijo(pruebas);

        diseno.agregarHijo(modelado);
        diseno.agregarHijo(animacion);

        sonido.agregarHijo(musica);
        sonido.agregarHijo(efectos);

        programacion.agregarHijo(inteligenciaArtificial);
        programacion.agregarHijo(multijugador);

        modelado.agregarHijo(personajes);
        modelado.agregarHijo(escenarios);

        musica.agregarHijo(bandaSonora);

        // CAMBIO 2: el nuevo proyecto se agrega como hijo
        // de Inteligencia Artificial, creando un nivel adicional.

        // Guardamos las metricas antes de agregar el nuevo nivel.
        int alturaInicial = MetricasArbol.altura(empresa);
        int nivelesIniciales = alturaInicial + 1;
        int nodosIniciales = MetricasArbol.contarNodos(empresa);

        // ============================================================
        // 3. MOSTRAR EL ARBOL ORIGINAL
        // ============================================================

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       ESTRUCTURA DE PIXEL STUDIOS");
        System.out.println("==============================================");

        MetricasArbol.mostrarArbol(empresa, 0);

        // ============================================================
        // 4. PROPIEDADES GENERALES
        // ============================================================

        System.out.println();
        System.out.println("==============================================");
        System.out.println("          PROPIEDADES DEL ARBOL");
        System.out.println("==============================================");

        System.out.println("Raiz: " + empresa.getDato());

        System.out.println(
                "Numero total de nodos: "
                        + MetricasArbol.contarNodos(empresa)
        );

        System.out.println(
                "Numero de hojas: "
                        + MetricasArbol.contarHojas(empresa)
        );

        System.out.println(
                "Numero de nodos internos: "
                        + (MetricasArbol.contarNodos(empresa)
                        - MetricasArbol.contarHojas(empresa))
        );

        System.out.println(
                "Grado del arbol: "
                        + MetricasArbol.gradoArbol(empresa)
        );

        System.out.println(
                "Altura del arbol: "
                        + MetricasArbol.altura(empresa)
        );

        System.out.println(
                "Numero de niveles: "
                        + (MetricasArbol.altura(empresa) + 1)
        );

        // ============================================================
        // 5. PROFUNDIDAD DE CINCO NODOS
        // ============================================================

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       PROFUNDIDAD DE CINCO NODOS");
        System.out.println("==============================================");

        mostrarProfundidad(empresa, desarrollo);
        mostrarProfundidad(empresa, programacion);
        mostrarProfundidad(empresa, inteligenciaArtificial);
        mostrarProfundidad(empresa, modelado);
        mostrarProfundidad(empresa, bandaSonora);

        // ============================================================
        // 6. GRADO DE ALGUNOS NODOS
        // ============================================================

        System.out.println();
        System.out.println("==============================================");
        System.out.println("             GRADO DE LOS NODOS");
        System.out.println("==============================================");

        mostrarGrado(empresa);
        mostrarGrado(desarrollo);
        mostrarGrado(programacion);
        mostrarGrado(modelado);
        mostrarGrado(inteligenciaArtificial);

        // ============================================================
        // 7. TABLA COMPLETA DE METRICAS
        // ============================================================

        System.out.println();
        System.out.println("==============================================");
        System.out.println("             TABLA DE METRICAS");
        System.out.println("==============================================");

        MetricasArbol.mostrarTablaMetricas(empresa);

        // ============================================================
        // 8. CAMINOS Y PROFUNDIDAD DE LAS HOJAS
        // ============================================================

        System.out.println();
        System.out.println("==============================================");
        System.out.println("               CAMINOS DEL ARBOL");
        System.out.println("==============================================");

        mostrarCamino(empresa, inteligenciaArtificial);
        mostrarCamino(empresa, escenarios);

        // CAMBIO 3: mostrar la profundidad de cada hoja.
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          PROFUNDIDAD DE TODAS LAS HOJAS");
        System.out.println("==============================================");

        mostrarProfundidadHojas(empresa, empresa);

        // ============================================================
        // 9. COMPARACION ANTES Y DESPUES
        // ============================================================

        // CAMBIO 4: agregamos el nuevo nivel despues de las
        // metricas iniciales para comparar ambos estados del arbol.
        inteligenciaArtificial.agregarHijo(proyectoIA);

        int alturaFinal = MetricasArbol.altura(empresa);
        int nivelesFinales = alturaFinal + 1;
        int nodosFinales = MetricasArbol.contarNodos(empresa);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("        COMPARACION DE ALTURAS");
        System.out.println("==============================================");

        System.out.println("Altura inicial: " + alturaInicial);
        System.out.println("Altura final: " + alturaFinal);

        System.out.println("Niveles iniciales: " + nivelesIniciales);
        System.out.println("Niveles finales: " + nivelesFinales);

        System.out.println("Nodos iniciales: " + nodosIniciales);
        System.out.println("Nodos finales: " + nodosFinales);

        System.out.println(
                alturaInicial == 3 && alturaFinal == 4
                        ? "Resultado: CORRECTO."
                        : "Resultado: REVISAR LAS ALTURAS."
        );

        System.out.println(
                "Conclusion: al agregar un nivel, la altura aumenta "
                        + "de " + alturaInicial + " a " + alturaFinal + "."
        );

        // CAMBIO 5: mostramos el arbol final actualizado.
        System.out.println();
        System.out.println("==============================================");
        System.out.println("             ARBOL ACTUALIZADO");
        System.out.println("==============================================");

        MetricasArbol.mostrarArbol(empresa, 0);
    }

    private static void mostrarProfundidad(
            NodoGeneral<?> raiz,
            NodoGeneral<?> nodo) {

        System.out.printf(
                "%-32s -> %d%n",
                nodo.getDato(),
                MetricasArbol.profundidad(raiz, nodo)
        );
    }

    private static void mostrarGrado(
            NodoGeneral<?> nodo) {

        System.out.printf(
                "%-32s -> %d%n",
                nodo.getDato(),
                MetricasArbol.gradoNodo(nodo)
        );
    }

    private static void mostrarCamino(
            NodoGeneral<?> raiz,
            NodoGeneral<?> destino) {

        var ruta = MetricasArbol.camino(raiz, destino);

        System.out.println(
                "Camino: " + MetricasArbol.rutaComoTexto(ruta)
        );

        System.out.println(
                "Longitud: "
                        + MetricasArbol.longitudCamino(raiz, destino)
                        + " aristas"
        );
    }

    // CAMBIO 6: metodo recursivo para recorrer todas las hojas.
    private static void mostrarProfundidadHojas(
            NodoGeneral<?> raiz,
            NodoGeneral<?> actual) {

        if (actual.esHoja()) {
            mostrarProfundidad(raiz, actual);
            return;
        }

        for (NodoGeneral<?> hijo : actual.getHijos()) {
            mostrarProfundidadHojas(raiz, hijo);
        }
    }
}
 
// Explicación para la profesora: el árbol representa
// la organización de una empresa de videojuegos.