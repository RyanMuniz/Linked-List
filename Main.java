// Name: Ryan Muniz
// Email: rmuniz15@cnm.edu
// Class: CSCI 2260: Section R01
// Assignment: Week 8: Linked List
// Purpose: 
// FileName: "Main.java"
// Date: March 28, 2026

// Import utilities
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// Driver class of the program
// Execution begins here
public class Main {
    // Tests to see output
    runLinkedListTests();
    /*
    main method
    This method:
    1. Runs the linked list tests
    2. Reads ace.csv
    3. Creates HurricaneRowData objects for each row
    4. Inserts each object into the doubly linked sorted list.
    5. Prints the year with the highest ACE
    6. Prints all hurrican data in sorted order by ACE
    */
	public static void main(String[] args) {
		// Create the doubly linked sorted list that will store all
        // HurricaneRowData objects in sorted order as they are added
		DoublyLinkedSortedList hurricaneDataList = new DoublyLinkedSortedList();

		// File input
		// Scanner reads ace.csv file line by line
		try (Scanner scanner = new Scanner(new File("ace.csv"))) {
			// Skip header row that has the column titles
			scanner.nextLine();
			// Continue reading while there are more lines in the file
			while (scanner.hasNextLine()) {
				// Read one full line from the CSV file
				String line = scanner.nextLine();

				// Split the line into individual column values using commas
				String[] values = line.split(",");

				// Parse each column into its correct data type
				int year = Integer.parseInt(values[0]);
				double ace = Double.parseDouble(values[1]);
				int storms = Integer.parseInt(values[2]);
				int hurricanes = Integer.parseInt(values[3]);
				int majorHurricanes = Integer.parseInt(values[4]);

				// Create HurricaneRowData object from the parsed data
				HurricaneRowData hurricaneRowData = 
						new HurricaneRowData(year, ace, storms,
							hurricanes, majorHurricanes);

				// Add object to the linked list
                // List places it in the proper sorted position so it is always sorted
						hurricaneDataList.insert(hurricaneRowData);
			}
		} catch (FileNotFoundException e) {
			// If file cannot be found, display an error and stop
			System.out.println("Error! ace.csv file not found.");
			return;
		}

		// Get first node in the list
        // The first node will be maximum ACE year
        Node firstLink = hurricaneDataList.getFirst();
        // Check for empty list
        if (firstLink == null) {
            System.out.println("No hurricane data was loaded.");
            return;
        }
        // Get the HurricaneRowData object stored in first node
		HurricaneRowData maxAceData = firstLink.getValue();
        // Extract the year from that HurricaneRowData object
        int maxYear = maxAceData.getYear();

		// Display results to console
		System.out.println("Year of max ACE: " + maxYear);
		System.out.println("All data in order of Ace:");
		System.out.print(hurricaneDataList);
	}
    /*
    runLinkedListTests method
    Runs two linked list tests and displays PASS or FAIL
    */
   public static void runLinkedListTests() {
    // Store the result of the first test
    boolean test1Passed = testInsertKeepsListSorted();
    // Display first test result
    System.out.println("Test 1 - insert keeps list sorted: " 
        + (test1Passed ? "PASS" : "FAIL"));
    // Store the result of the second test
    boolean test2Passed = testRemoveContainsAndGetByValue();
    // Display first test result
    System.out.println("Test 2 - remove / contains / getByValue: " 
        + (test2Passed ? "PASS" : "FAIL"));
    // Print blank line to seperate test from output
    System.out.println();
   }
   /*
   testInsertKeepsListSorted method
   Tests whether items are inserted in the proper sorted order.
   Returns true if:
   first node is highest ACE,
   middle node is next highest,
   last node is lowest ACE
   */
   public static boolean testInsertKeepsListSorted() {
    // Create a new empty test list
    DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
    // Create three rows with intentionally mixed ACE values
    HurricaneRowData row1 = new HurricaneRowData(2000, 50, 10, 5, 2);
    HurricaneRowData row2 = new HurricaneRowData(2001, 100, 11, 6, 3);
    HurricaneRowData row3 = new HurricaneRowData(2002, 75, 12, 7, 4);
    // Insert them in unsorted order
    testList.insert(row1);
    testList.insert(row2);
    testList.insert(row3);
    // If the list sorting works correctly, the order should be:
    // row2(100), row3(75), row1(50)
    
    // Check first and last nodes are not null before checking values
    if (testList.getFirst() == null || testList.getLast() == null) {
        return false;
    }
    // Check first node value
    boolean firstCorrect = testList.getFirst().getValue().equals(row2);
    // Check middle node exists and has correct value.
    boolean middleCorrect = 
        testList.getFirst().getNext() != null &&
        testList.getFirst().getNext().getValue().equals(row3);
    // Check last node value
    boolean lastCorrect = testList.getLast().getValue().equals(row1);
    // Return true only if all checks passed
    return firstCorrect && middleCorrect && lastCorrect;
   }
   /*
   testRemoveContainsAndGetByValue method
   Tests:
   1. contains and finds an inserted value
   2. getByValue returns the correct node
   3. remove takes the item out of the list
   */
   public static boolean testRemoveContainsAndGetByValue() {
    // Create a new empty test list
    DoublyLinkedSortedList testList = new DoublyLinkedSortedList();
    // Create three rows with intentionally mixed ACE values
    HurricaneRowData row1 = new HurricaneRowData(2000, 50, 10, 5, 2);
    HurricaneRowData row2 = new HurricaneRowData(2001, 100, 11, 6, 3);
    HurricaneRowData row3 = new HurricaneRowData(2002, 75, 12, 7, 4);
    // Insert all three rows
    testList.insert(row1);
    testList.insert(row2);
    testList.insert(row3);
    // Check whether the list reports that it contains row3
    boolean containsBeforeRemove = testList.contains(row3);
    // Try to locate row3 by value
    Node foundNode = testList.getByValue(row3);
    // Remove row3 from the list
    Node removedNode = testList.remove(row3);
    // After removing row3, the list should no longer contain it
    boolean containsAfterRemove = testList.contains(row3);
    // Build each correct condition
    boolean foundCorrectNode = foundNode != null && foundNode.getValue().equals(row3);
    boolean removedCorrectNode = foundNode != null && removedNode.getValue().equals(row3);
    boolean removedSuccessfully = !containsAfterRemove;
    // Return true only if every expected behavior occurred.
    return containsBeforeRemove &&
        foundCorrectNode &&
        removedCorrectNode &&
        removedSuccessfully;
   }
}