// Name: Ryan Muniz
// Email: rmuniz15@cnm.edu
// Class: CSCI 2260: Section R01
// Assignment: Week 8: Linked List
// Purpose: 
// FileName: "Node.java"
// Date: March 28, 2026

public class Node {
    // The HurricaneRowData value stored inside this node
    private HurricaneRowData value;
    // Reference to the next and previous node in the list
    private Node next;
    private Node previous;

    // Constructor
    // Creates a node w/ the given HurricaneRowData value
    // Next and previous start as null
    public Node(HurricaneRowData value) {
        // Store the data object in this node
        this.value = value;
        // At creation, next and previous is null until connected
        this.next = null;
        this.previous = null;
    } 
    /*
    getValue method
    Returns the HurricaneRowData stored in this node.
    */
   public HurricaneRowData getValue() {
    return value;
   }
   /*
   setValue method
   Replaces the HurricaneRowData stored in this node.
   */
   public void setValue(HurricaneRowData value) {
    this.value = value;
   }
   /*
   hasNext method
   Returns true if this node has a next node.
   */
  public boolean hasNext() {
    return next != null;
  }
  /*
  getNext method
  Returns the next node reference.
  */
  public Node getNext() {
    return next;
  }
  /*
  setNext method
  Sets the next node reference.
  */
  public void setNext(Node next) {
    this.next = next;
  }
  /*
  hasPrevious
  Returns true if this node has a previous node.
  */
 public Node hasPrevious() {
    return previous;
 }
 /*
 setPrevious method
 Sets the previous node reference.
 */
 public void setPrevious(Node previous) {
    this.previous = previous;
 }
}
