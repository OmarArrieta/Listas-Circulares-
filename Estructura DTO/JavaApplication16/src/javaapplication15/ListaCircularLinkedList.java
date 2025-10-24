package javaapplication15;

import java.util.LinkedList;
import java.util.Scanner;

public class ListaCircularLinkedList {
    public static void main(String[] args) {

        // Se crea una lista enlazada (LinkedList) que simulará una lista circular
        LinkedList<String> lista = new LinkedList<>();

        // Agregamos elementos iniciales
        lista.add("A");
        lista.add("B");
        lista.add("C");

        // Muestra el contenido actual de la lista
        System.out.println("Lista inicial: " + lista);

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ LISTA CIRCULAR ---");
            System.out.println("1. Mostrar lista circular");
            System.out.println("2. Actualizar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    recorrerListaCircular(lista);
                    break;

                case 2:
                    System.out.print("Ingrese el valor a actualizar: ");
                    String antiguo = sc.nextLine();

                    System.out.print("Ingrese el nuevo valor: ");
                    String nuevo = sc.nextLine();

                    actualizarElemento(lista, antiguo, nuevo);
                    break;

                case 3:
                    System.out.print("Ingrese el valor a eliminar: ");
                    String eliminar = sc.nextLine();

                    eliminarElemento(lista, eliminar);
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }

    // 🔹 Método para recorrer la lista de forma circular (muestra elementos infinitamente)
    public static void recorrerListaCircular(LinkedList<String> lista) {
        System.out.println("\nRecorrido circular infinito mostrando letra por letra:");
        int i = 0;

        while (true) {
            int posicion = i % lista.size(); // Reinicia el índice al llegar al final
            String letra = lista.get(posicion);
            System.out.println(letra);
            i++;

            try {
                Thread.sleep(1000); // Espera 1 segundo entre cada elemento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 🔹 Método para actualizar un elemento en la lista
    public static void actualizarElemento(LinkedList<String> lista, String antiguo, String nuevo) {
        int indice = lista.indexOf(antiguo); // Busca la posición del elemento a reemplazar
        if (indice != -1) {
            lista.set(indice, nuevo); // Reemplaza el valor
            System.out.println("Elemento actualizado correctamente.");
            System.out.println("Lista actualizada: " + lista);
        } else {
            System.out.println("El elemento '" + antiguo + "' no se encuentra en la lista.");
        }
    }

    // 🔹 Método para eliminar un elemento de la lista
    public static void eliminarElemento(LinkedList<String> lista, String valor) {
        if (lista.remove(valor)) { // remove devuelve true si elimina correctamente
            System.out.println("Elemento eliminado correctamente.");
            System.out.println("Lista actualizada: " + lista);
        } else {
            System.out.println("El elemento '" + valor + "' no se encuentra en la lista.");
        }
    }
}