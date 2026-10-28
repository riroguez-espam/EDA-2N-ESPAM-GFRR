import java.util.EmptyStackException;

/**
 * Implementación de Pila (Stack) bajo política LIFO (Last-In, First-Out)
 * con control de estados (Stack Overflow / Stack Underflow).
 */
public class PilaLIFO<T> {

    private final Object[] elementos;
    private final int capacidad;
    private int tope;

    public PilaLIFO(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero.");
        }
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.tope = -1; // -1 indica pila vacía
    }

    // Inserta un elemento en la cima de la pila: O(1)
    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException("Desbordamiento de Pila (Stack Overflow): Capacidad agotada.");
        }
        tope++;
        elementos[tope] = item;
    }

    // Extrae y retorna el elemento en la cima de la pila: O(1)
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) elementos[tope];
        elementos[tope] = null; // libera referencia para el Garbage Collector
        tope--;
        return item;
    }

    // Consulta el elemento en la cima sin extraerlo: O(1)
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elementos[tope];
    }

    // Control de estado: verifica si la pila está vacía: O(1)
    public boolean isEmpty() {
        return tope == -1;
    }

    // Control de estado: verifica si la pila está llena: O(1)
    public boolean isFull() {
        return tope == capacidad - 1;
    }

    // Retorna la cantidad actual de elementos apilados: O(1)
    public int size() {
        return tope + 1;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Muestra el estado actual de la pila desde la cima hasta la base: O(n)
    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("[Pila vacía]");
            return;
        }
        System.out.print("Cima -> ");
        for (int i = tope; i >= 0; i--) {
            System.out.print("[" + elementos[i] + "] ");
        }
        System.out.println("<- Base (tamaño: " + size() + "/" + capacidad + ")");
    }
}

