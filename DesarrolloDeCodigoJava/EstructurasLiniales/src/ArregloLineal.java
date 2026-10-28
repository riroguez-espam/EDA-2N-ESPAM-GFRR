/**
 * Implementación de operaciones sobre arreglos estáticos (1D) y matrices (2D)
 * en bloques contiguos de memoria.
 */
public class ArregloLineal {

    private final int[] arreglo;
    private final int capacidad;
    private int tamanio;

    public ArregloLineal(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero.");
        }
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.tamanio = 0;
    }

    // Inserción al final del arreglo estático: O(1)
    public void insertar(int valor) {
        if (tamanio == capacidad) {
            throw new IllegalStateException("Desbordamiento de Arreglo: Capacidad máxima alcanzada.");
        }
        arreglo[tamanio] = valor;
        tamanio++;
    }

    // Inserción en un índice específico con desplazamiento a la derecha: O(n)
    public void insertarEnIndice(int indice, int valor) {
        if (tamanio == capacidad) {
            throw new IllegalStateException("Desbordamiento de Arreglo: Capacidad máxima alcanzada.");
        }
        if (indice < 0 || indice > tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        for (int i = tamanio; i > indice; i--) {
            arreglo[i] = arreglo[i - 1];
        }
        arreglo[indice] = valor;
        tamanio++;
    }

    // Acceso aleatorio por índice (direccionamiento directo): O(1)
    public int obtener(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return arreglo[indice];
    }

    // Actualización por índice: O(1)
    public void actualizar(int indice, int nuevoValor) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        arreglo[indice] = nuevoValor;
    }

    // Eliminación por índice con desplazamiento a la izquierda: O(n)
    public int eliminarEnIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        int eliminado = arreglo[indice];
        for (int i = indice; i < tamanio - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
        arreglo[tamanio - 1] = 0;
        tamanio--;
        return eliminado;
    }

    // Búsqueda lineal sobre el arreglo: O(n)
    public int buscar(int valor) {
        for (int i = 0; i < tamanio; i++) {
            if (arreglo[i] == valor) {
                return i; // retorna la posición donde se encontró
            }
        }
        return -1; // no encontrado
    }

    // Recorrido e impresión del arreglo estático: O(n)
    public void mostrarArreglo() {
        System.out.print("[");
        for (int i = 0; i < tamanio; i++) {
            System.out.print(arreglo[i]);
            if (i < tamanio - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] (tamaño: " + tamanio + "/" + capacidad + ")");
    }

    public int getTamanio() {
        return tamanio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // ==================== OPERACIONES SOBRE MATRICES (2D) ====================

    // Recorrido e impresión de una matriz estática (filas x columnas): O(f * c)
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println("|");
        }
    }

    // Suma de dos matrices de iguales dimensiones: O(f * c)
    public static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        if (filas != matrizB.length || columnas != matrizB[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para sumarse.");
        }
        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return resultado;
    }

    // Transpuesta de una matriz: O(f * c)
    public static int[][] transponerMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    // Búsqueda secuencial en una matriz 2D: O(f * c)
    public static boolean buscarEnMatriz(int[][] matriz, int valor) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }
}

