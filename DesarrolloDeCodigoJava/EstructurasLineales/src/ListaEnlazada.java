public class ListaEnlazada<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> cabeza; // primer nodo de la lista

    public ListaEnlazada() {
        this.cabeza = null; // lista vacía
    }

    // Inserción al inicio: O(1)
    public void insertarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza; // el nuevo apunta al que era el primero
        cabeza = nuevo;           // ahora el nuevo es el primero
    }

    // Inserción al final: O(n)
    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) { // lista vacía; el nuevo es la cabeza
            cabeza = nuevo;
            return;
        }
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) { // avanzar hasta el último
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo; // el último apunta al nuevo
    }

    // Recorrido: O(n)
    public void mostrarLista() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Contar nodos: O(n)
    public int contarNodos() {
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Búsqueda lineal: O(n)
    public boolean buscar(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(valor)) {
                return true; // lo encontró, termina de inmediato
            }
            actual = actual.siguiente;
        }
        return false; // llegó a null sin encontrarlo
    }
}
