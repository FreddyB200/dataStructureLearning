package com.datastructures.theory;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;     // Tamaño de la lista

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Agrega un elemento al final de la lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { // Lista vacía: head y tail apuntan al nuevo nodo
            head = newNode;
            tail = newNode;
        } else {
            // Conectamos el nuevo nodo al final de la lista
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    // Elimina el primer nodo que contenga el dato especificado
    public boolean remove(T data) {
        if (head == null) return false; // Lista vacía

        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                // Si es el nodo head
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.previous = null;
                    } else {
                        // La lista queda vacía
                        tail = null;
                    }
                }
                // Si es el nodo tail
                else if (current == tail) {
                    tail = current.previous;
                    tail.next = null;
                }
                // Nodo en el medio
                else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Imprime la lista desde head hasta tail
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Devuelve el tamaño de la lista
    public int size() {
        return size;
    }

    // Método para invertir la lista doblemente enlazada en su lugar
    public void reverse() {
        Node<T> current = head;
        Node<T> temp = null;
        // Guardamos el head original para asignarlo como tail luego
        Node<T> oldHead = head;

        // Recorremos la lista y para cada nodo intercambiamos sus punteros
        while (current != null) {
            // Guardamos el valor actual de previous
            temp = current.previous;
            // Intercambiamos previous y next
            current.previous = current.next;
            current.next = temp;
            // Avanzamos al siguiente nodo (que es current.previous tras el intercambio)
            current = current.previous;
        }
        // Si la lista no estaba vacía, temp terminará en el último nodo procesado
        if (temp != null) {
            head = temp.previous;
        }
        // El head original se convierte en tail
        tail = oldHead;
    }
}

