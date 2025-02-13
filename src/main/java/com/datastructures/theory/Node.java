package com.datastructures.theory;

public class Node<T> {
    T data;        // Dato almacenado en el nodo
    Node<T> next;  // Referencia al siguiente nodo

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

