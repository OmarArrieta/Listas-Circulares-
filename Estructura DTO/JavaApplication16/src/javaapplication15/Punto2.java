package javaapplication15;

import java.util.Scanner;

public class Punto2 {
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int d) {
            dato = d;
        }
    }

    static Nodo cabeza = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ LISTA CIRCULAR ---");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Actualizar nodo");
            System.out.println("4. Eliminar nodo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    int valor = sc.nextInt();
                    insertar(valor);
                    break;

                case 2:
                    mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese el valor a actualizar: ");
                    int antiguo = sc.nextInt();
                    System.out.print("Ingrese el nuevo valor: ");
                    int nuevo = sc.nextInt();
                    actualizar(antiguo, nuevo);
                    break;

                case 4:
                    System.out.print("Ingrese el valor a eliminar: ");
                    int eliminar = sc.nextInt();
                    eliminarNodo(eliminar);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
    }

    // 🔹 Insertar nodo al final de la lista circular
    public static void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza; // apunta a sí mismo
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        System.out.println("Nodo insertado correctamente.");
    }

    // 🔹 Mostrar todos los elementos de la lista (una vuelta)
    public static void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo temp = cabeza;
        System.out.println("Contenido de la lista circular:");
        do {
            System.out.print(temp.dato + " → ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        System.out.println("(vuelve a inicio)");
    }

    // 🔹 Actualizar el valor de un nodo
    public static void actualizar(int antiguo, int nuevo) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo temp = cabeza;
        boolean encontrado = false;

        do {
            if (temp.dato == antiguo) {
                temp.dato = nuevo;
                encontrado = true;
                break;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        if (encontrado)
            System.out.println("Nodo actualizado correctamente.");
        else
            System.out.println("No se encontró el valor " + antiguo + " en la lista.");
    }

    // 🔹 Eliminar un nodo de la lista circular
    public static void eliminarNodo(int valor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        do {
            if (actual.dato == valor) {
                if (anterior != null) {
                    anterior.siguiente = actual.siguiente;
                } else { // si se elimina la cabeza
                    Nodo temp = cabeza;
                    while (temp.siguiente != cabeza) {
                        temp = temp.siguiente;
                    }
                    cabeza = cabeza.siguiente;
                    temp.siguiente = cabeza;
                }
                System.out.println("Nodo eliminado correctamente.");
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("No se encontró el valor " + valor + " en la lista.");
    }
}