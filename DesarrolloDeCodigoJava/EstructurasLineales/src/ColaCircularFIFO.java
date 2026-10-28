import java.util.NoSuchElementException;

/**
 * Implementación de Cola Circular basada en arreglo de capacidad fija.
 * Aplica aritmética modular (rear + 1) % capacidad para evitar el falso desbordamiento.
 */
public class ColaCircularFIFO<T> {

    private final Object[] elementos;
    private final int capacidad;
    private int frente;
    private int finalCola;
    private int tamanio;

    public ColaCircularFIFO(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero.");
        }
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamanio = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Desbordamiento de Cola (Queue Overflow): Capacidad agotada.");
        }
        finalCola = (finalCola + 1) % capacidad;
        elementos[finalCola] = item;
        tamanio++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Subdesbordamiento de Cola (Queue Underflow): Cola vacía.");
        }
        T item = (T) elementos[frente];
        elementos[frente] = null;
        frente = (frente + 1) % capacidad;
        tamanio--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cola vacía.");
        }
        return (T) elementos[frente];
    }

    public boolean isEmpty() {
        return tamanio == 0;
    }

    public boolean isFull() {
        return tamanio == capacidad;
    }

    public int size() {
        return tamanio;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
