// Name: Ryan Muniz
// Email: rmuniz15@cnm.edu
// Class: CSCI 2260: Section R01
// Assignment: Week 8: Linked List
// Purpose: 
// FileName: "DoublyLinkedSortedList.java"
// Date: March 28, 2026

public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
        // Reference to the first and last node in list
        private Node first;
        private Node last;

        // Constructor
        // Creates an empty doubly linked sorted list
        public DoublyLinkedSortedList() {
            // Empty list starts with no first or last node
            first = null;
            last = null; 
        }
        /*
        getFirst
        Returns a reference to the first node in the list.
        */
        @Override
        public Node getFirst() {
            return first;
        }
        /*
        getLast
        Returns a reference to the last node in the list.
        */
        @Override
        public Node getLast() {
            return last;
        }
        /*
        insert
        Inserts a new HurricaneRowData object into the list in descending order by ACE.
        If two rows have the same ACE, the newly inserted one is placed before existing
        equal ACE values thus comparison uses >=.
        */
        @Override
        public void insert(HurricaneRowData newValue) {
            // Create a new node to hold the incoming HurricaneRowData
            Node newNode = new Node(newValue);

            // If list is empty this node becomes both first and last
            if (first == null) {
                first = newNode;
                last = newNode;
                return;
            }
            // If the new ACE is >= the ACE in the first node, insert at front of list
            if (newValue.getAce() >= first.getValue().getAce()) {
                // Link new node forward to the old first node
                newNode.setNext(first);
                // Link old first node back to the new node
                first.setPrevious(newNode);
                // Update first so new node becomes first
                first = newNode;
                return;
            }
            // Start searching from the first node
            Node current = first;
            // Move through list while:
            // 1. There is another node after current
            // 2. The next node's ACE is still greater than the new ACE
            // 3. Stop when we find the spot where new node belongs
            while (current.hasNext() &&
                current.getNext().getValue().getAce() > newValue.getAce()) {
                    // Move current one node forward
                    current = current.getNext();
                }
            // If current is the last node, insert at end
            if (!current.hasNext()) {
                // Link current forward to the new node.
                current.setNext(newNode);
                // Link new node back to current
                newNode.setPrevious(current);
                // Update last so the new node becomes the new tail
                last = newNode;
            }
            // Otherwise insert in the middle between current and the node that comes after
            else {
                // Save node that comes after current
                Node afterCurrent = current.getNext();
                // Link new node forward to the node after current
                newNode.setNext(afterCurrent);
                // Link new node backward to current
                newNode.setPrevious(current);
                // Link current forward to new node
                current.setNext(newNode);
                // Link the old next node backward to the new node.
                afterCurrent.setPrevious(newNode);
            }
        }
        /*
        remove
        Removes the first node whose value equals toRemove.
        Returns the removed node reference, or null if not found.
        */
        @Override
        public Node remove(HurricaneRowData toRemove) {
            // Start at first node
            Node current = first;
            // Search node by node until end of list
            while (current != null) {
                // If current node stores target value, remove this node from list
                if (current.getValue().equals(toRemove)) {
                    // 1. List only has one node
                    if (current == first && current == last) {
                        first = null;
                        last = null;
                    }
                    // 2. Removing the first node
                    else if (current == first) {
                        first = current.getNext();
                        first.setPrevious(null);
                    }
                    // 3. Removing the last node
                    else if (current == last) {
                        last = current.getPrevious();
                        last.setNext(null);
                    }
                    // 4. Removing a middle node
                    else {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    }
                    // Disconnect the removed node completely
                    current.setNext(null);
                    current.setPrevious(null);
                    // Remove the removed node
                    return current;
                }
                // Move to the next node in the search
                current = current.getNext();
            }
            // If value wasn't found return null
            return null;
        }
        /*
        contains method
        Returns true if the linked list contains the given value.
        Returns false otherwise.
        */
        public boolean contains(HurricaneRowData value) {
            return getByValue(value) != null;
        }
        /*
        getByValue method
        Returns the node whose value matches the given value.
        Returns null if value is not found.
        */
        public Node getByValue(HurricaneRowData value) {
            Node current = first;
            while (current != null) {
                if (current.getValue().equals(value)) {
                    return current;
                }
                current = current.getNext();
            }
            return null;
        }
    }