package javaapplication15;

import java.util.LinkedList;

public class ListaCircularLinkedList {
    public static void main(String[] args) {

        LinkedList<String> lista = new LinkedList<>();

        lista.add("A");
        lista.add("B");
        lista.add("C");

        System.out.println("Lista normal: " + lista);
        System.out.println("\nRecorrido circular infinito mostrando letra por letra:");

        int i = 0;

        while (true) {
            int posicion = i % lista.size();
            String letra = lista.get(posicion);

            System.out.println(letra);
            i++;

            try { 
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    } 
} 

