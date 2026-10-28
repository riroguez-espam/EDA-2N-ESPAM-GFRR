public class Main {

    public static void main(String[] args) {
        System.out.println("=== SUITE DEMOSTRATIVA DE ESTRUCTURAS DE DATOS LINEALES ===");

        // 1. Demostración de Arreglo Estático (1D) y Matriz (2D)
        System.out.println("\n--- 1. ARREGLO LINEAL Y MATRICES ---");
        ArregloLineal arreglo = new ArregloLineal(5);
        arreglo.insertar(10);
        arreglo.insertar(20);
        arreglo.insertar(30);
        arreglo.insertarEnIndice(1, 15); // Desplazamiento a la derecha O(n)
        arreglo.mostrarArreglo();
        System.out.println("Acceso O(1) en índice 2: " + arreglo.obtener(2));
        System.out.println("Eliminado en índice 0: " + arreglo.eliminarEnIndice(0));
        arreglo.mostrarArreglo();

        int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("Matriz 2x3 original:");
        ArregloLineal.mostrarMatriz(matriz);
        System.out.println("Matriz Transpuesta 3x2:");
        ArregloLineal.mostrarMatriz(ArregloLineal.transponerMatriz(matriz));

        // 2. Demostración de Lista Simplemente Enlazada en el Heap
        System.out.println("\n--- 2. LISTA SIMPLEMENTE ENLAZADA (HEAP) ---");
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.insertarAlInicio("Nodo B"); // Inserción en cabeza O(1)
        lista.insertarAlInicio("Nodo A");
        lista.insertarAlFinal("Nodo C");  // Inserción al final O(n)
        lista.mostrarLista();
        System.out.println("Total de nodos en Heap: " + lista.contarNodos());
        System.out.println("¿Existe 'Nodo B'?: " + lista.buscar("Nodo B"));

        // 3. Demostración de Pila LIFO (Last-In, First-Out)
        System.out.println("\n--- 3. PILA LIFO (STACK) ---");
        PilaLIFO<String> pila = new PilaLIFO<>(3);
        pila.push("Accion 1: Escribir título");
        pila.push("Accion 2: Aplicar negrita");
        pila.push("Accion 3: Insertar imagen");
        pila.mostrarPila();
        System.out.println("Elemento en cima (peek O(1)): " + pila.peek());
        System.out.println("Desapilando (pop O(1)): " + pila.pop());
        pila.mostrarPila();

        // 4. Demostración de Cola Circular FIFO con aritmética modular
        System.out.println("\n--- 4. COLA CIRCULAR FIFO ---");
        ColaCircularFIFO<String> cola = new ColaCircularFIFO<>(3);
        cola.enqueue("Turno 01");
        cola.enqueue("Turno 02");
        cola.enqueue("Turno 03");
        System.out.println("Atendiendo (dequeue O(1)): " + cola.dequeue());
        cola.enqueue("Turno 04 (Reutiliza espacio con (rear + 1) % capacidad)");
        System.out.println("Frente actual (peek O(1)): " + cola.peek() + " | Tamaño: " + cola.size() + "/" + cola.getCapacidad());

        // 5. Demostración del Caso del Foro (Grupo 3: Playlist Doblemente Enlazada Circular)
        System.out.println("\n--- 5. CASO FORO GRUPO 3: PLAYLIST CON BUCLE CONTINUO ---");
        CasoForo playlist = new CasoForo();
        playlist.agregar("1. Bohemian Rhapsody - Queen");     // Inserción al final O(1)
        playlist.agregar("2. Hotel California - Eagles");
        playlist.agregar("3. Imagine - John Lennon");
        playlist.mostrarPlaylist();
        System.out.println("Reproduciendo ahora: " + playlist.reproduciendoActual());
        System.out.println("Siguiente pista O(1): " + playlist.siguiente());
        System.out.println("Siguiente pista O(1): " + playlist.siguiente());
        System.out.println("Siguiente pista O(1) (Retorno circular al inicio): " + playlist.siguiente());
        System.out.println("Pista anterior O(1) (Retorno circular al final): " + playlist.anterior());
        playlist.mostrarPlaylist();
    }
}

