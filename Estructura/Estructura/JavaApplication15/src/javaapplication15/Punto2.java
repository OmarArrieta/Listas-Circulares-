package javaapplication15;

public class Punto2 {
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int d) {
            dato = d;
        }
    }

    public static void main(String[] args) {
        Nodo n1 = new Nodo(10);
        Nodo n2 = new Nodo(20);
        Nodo n3 = new Nodo(30);

        // Enlazamos los nodos en forma circular
        n1.siguiente = n2;
        n2.siguiente = n3;
        n3.siguiente = n1;

        Nodo cabeza = n1;

        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("Recorrido infinito mostrando número por número:");
        Nodo temp = cabeza;

        while (true) {
            System.out.println(temp.dato); // Muestra el dato actual
            temp = temp.siguiente;         // Avanza al siguiente nodo

            // Pausa de 1 segundo entre cada número (opcional)
            try {
                Thread.sleep(1000); // 1000 ms = 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

