// Name: Ryan Muniz
// Email: rmuniz15@student.cnm.edu
// Class: CSCI 2260: Section R01
// Assignment: Week 8: Linked List
// Purpose: 
// FileName: "SortedTreeSetInterface.java"
// Date: March 19, 2026

public interface SortedTreeSetInterface {
    public Person getPerson();

    public boolean hasLeft();
    public void setLeft(SortedTreeSet left);
    public SortedTreeSet getLeft();

    public boolean hasRight();
    public void setRight(SortedTreeSet right);
    public SortedTreeSet getRight();

    public void add(Person p);
}
