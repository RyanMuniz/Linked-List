// Name: Ryan Muniz
// Email: rmuniz15@cnm.edu
// Class: CSCI 2260: Section R01
// Assignment: Week 8: Linked List
// Purpose: Defines the required methods for a doubly linked sorted list,
// including insertion, removal, and access operations.
// FileName: "DoublyLinkedSortedListInterface.java"
// Date: March 28, 2026

public interface DoublyLinkedSortedListInterface {
    // Return reference to the first and last node in the list
    public Node getFirst();
    public Node getLast();
    // Remove the Node that has toRemove as its value
    public Node remove(HurricaneRowData toRemove);
    // Insert a new Node with the given newValue into the list in order.
    public void insert(HurricaneRowData newValue);
    // Return the entire list as a multi-line String
    public String toString();
}
