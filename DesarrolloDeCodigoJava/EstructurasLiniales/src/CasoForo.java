/**
 * Caso Asignado en el Foro (Grupo 3):
 * Lista de Reproducción Multimedia con Bucle Continuo (Playlist)
 * implementada mediante una Lista Doblemente Enlazada Circular en el Heap.
 *
 * Foco Técnico:
 * - Inserción al final en O(1) usando cabeza.anterior (sin recorrer la lista).
 * - Navegación bidireccional (siguiente y anterior) en tiempo constante O(1).
 * - Retorno circular transparente sin punteros null (bucle continuo).
 */
public class CasoForo {

    // Nodo doblemente enlazado alojado dinámicamente en el Heap
    private static class Nodo {
        String cancion;
        Nodo siguiente;
        Nodo anterior;

        Nodo(String cancion) {
            this.cancion = cancion;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    private Nodo cabeza;
    private Nodo actual;
    private int tamanio;

    public CasoForo() {
        this.cabeza = null;
        this.actual = null;
        this.tamanio = 0;
    }

    // Inserción al final en O(1) obteniendo la cola directamente con cabeza.anterior
    public void agregar(String cancion) {
        Nodo n = new Nodo(cancion);
        if (cabeza == null) {
            cabeza = n;
            n.siguiente = n;
            n.anterior = n;
            actual = n;
        } else {
            Nodo cola = cabeza.anterior; // acceso directo en O(1) sin recorrer
            cola.siguiente = n;
            n.anterior = cola;
            n.siguiente = cabeza;
            cabeza.anterior = n;
        }
        tamanio++;
    }

    // Avanza a la siguiente canción en O(1) (bucle continuo automático)
    public String siguiente() {
        if (actual == null) {
            throw new IllegalStateException("La playlist está vacía.");
        }
        actual = actual.siguiente; // O(1)
        return actual.cancion;
    }

    // Retrocede a la canción anterior en O(1) (bucle continuo inverso automático)
    public String anterior() {
        if (actual == null) {
            throw new IllegalStateException("La playlist está vacía.");
        }
        actual = actual.anterior; // O(1)
        return actual.cancion;
    }

    // Retorna la canción que se está reproduciendo actualmente: O(1)
    public String reproduciendoActual() {
        if (actual == null) {
            return "Ninguna (Playlist vacía)";
        }
        return actual.cancion;
    }

    // Elimina una canción de la playlist manteniendo los enlaces circulares dobles: O(n)
    public boolean eliminar(String cancion) {
        if (cabeza == null) {
            return false;
        }
        Nodo temp = cabeza;
        for (int i = 0; i < tamanio; i++) {
            if (temp.cancion.equalsIgnoreCase(cancion)) {
                if (tamanio == 1) {
                    cabeza = null;
                    actual = null;
                } else {
                    temp.anterior.siguiente = temp.siguiente;
                    temp.siguiente.anterior = temp.anterior;
                    if (temp == cabeza) {
                        cabeza = temp.siguiente;
                    }
                    if (temp == actual) {
                        actual = temp.siguiente;
                    }
                }
                tamanio--;
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }

    // Muestra el estado completo de la lista doblemente enlazada circular: O(n)
    public void mostrarPlaylist() {
        if (cabeza == null) {
            System.out.println("[Playlist vacía]");
            return;
        }
        System.out.print("(Cola: " + cabeza.anterior.cancion + ") <-> ");
        Nodo temp = cabeza;
        for (int i = 0; i < tamanio; i++) {
            if (temp == actual) {
                System.out.print("[▶ " + temp.cancion + "] <-> ");
            } else {
                System.out.print("[" + temp.cancion + "] <-> ");
            }
            temp = temp.siguiente;
        }
        System.out.println("(Cabeza: " + cabeza.cancion + ") | Total: " + tamanio + " pistas");
    }

    public boolean isEmpty() {
        return tamanio == 0;
    }

    public int size() {
        return tamanio;
    }
}

