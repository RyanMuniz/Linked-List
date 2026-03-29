// Name: Ryan Muniz
// Email: rmuniz15@cnm.edu
// Class: CSCI 2260: Section R01
// Assignment: Week 8: Linked List
// Purpose: 
// FileName: "HurricaneRowData.java"
// Date: March 28, 2026

// HurricaneRowData
// This class represents one row of hurricane data
// from the ace.csv file
public class HurricaneRowData {
	// Instance variables store data for one hurricane season
	// 5 private instances as required
	private int year;
	private double ace;
	private int storms;
	private int hurricanes;
	private int majorHurricanes;

	// Constructor
	// Initializes all instance variables when object is created
	public HurricaneRowData(int year, double ace, int storms,
	int hurricanes, int majorHurricanes) {
		this.year = year;
		this.ace = ace;
		this.storms = storms;
		this.hurricanes = hurricanes;
		this.majorHurricanes = majorHurricanes;
	}

	// Getter for year
	public int getYear() {
		return year;
	}

	// Getter for ACE
	public double getAce() {
		return ace;
	}

	// Getter for storms
	public int getStorms() {
		return storms;
	}

	// Getter for hurricanes
	public int getHurricanes() {
		return hurricanes;
	}

	// Getter for major hurricanes
	public int getMajorHurricanes() {
		return majorHurricanes;
	}
    /*
    equals method
    Returns true if every field in this object matches
    every field in the other HurricaneRowData object.
    */
    @Override
    public boolean equals(Object otherObject) {
        // If both references point to the same object, then they are equal
        if (this == otherObject) {
            return true;
        }
        // If the other object is null or not a HurricaneRowData, then not equal
        if (!(otherObject instanceof HurricaneRowData)) {
            return false;
        }
        // Type cast the Object reference into a HurricaneRowData reference
        HurricaneRowData other = (HurricaneRowData) otherObject;
        // Return true only if all fields match
        return this.year == other.year &&
            this.ace == other.ace &&
            this.storms == other.storms &&
            this.hurricanes == other.hurricanes &&
            this.majorHurricanes == other.majorHurricanes;
    }

	// toString
	// Returns a formatted String rep. of the object
	@Override
	public String toString() {
		return String.format("%10d%11.0f%11d%11d",
            year, ace, storms, hurricanes, majorHurricanes);
	}
 }