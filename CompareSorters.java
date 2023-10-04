package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class CompareSorters{
  
  public static void main(String[] args) throws FileNotFoundException{
    PointScanner[] scanners = new PointScanner[4];
    Random rand = new Random();
    Scanner scn = new Scanner(System.in);

    System.out.println("Performances of Four Sorting Algorithms in Point Scanning");
    int choices = 0;
    int trial = 1;

    while(choices != 3){
      System.out.println("Keys: 1(Random Integers) 2(File Input) 3(Exit)");
      choices = scn.nextInt();

      if(choices == 1){
        System.out.println("Trial " + trial + ": " + choices);
        System.out.println("Enter number of random points: ");
        int randPoints = scn.nextInt();
        randPoint(randPoints, rand, scanners);
        trial++;
      }
      if(choices == 2){
        System.out.println("Trial " + trial + ": " + choices);
        System.out.println("Points from a file");
        System.out.println("File name: ");
        String file = scn.next();
        filePoint(file, scanners);
        scanners[3].writeMCPToFile();
        trial++;
      }
    }
    scn.close();
  }

  public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException{
    if(numPts < 1){
      throw new IllegalArgumentException();
    }

    Point[] randPoints = new Point[numPts];

    for(int i = 0; i < numPts; i++){
      Point p = new Point(rand.nextInt(101) - 50, rand.nextInt(101) - 50);
      randPoints[i] = p;
    }
    return randPoints;
  }

  public static void randPoint(int numPts, Random rand, PointScanner[] scanners){
    scanners[0] = new PointScanner(generateRandomPoints(numPts, rand), Algorithm.SelectionSort);
    scanners[1] = new PointScanner(generateRandomPoints(numPts, rand), Algorithm.InsertionSort);
		scanners[2] = new PointScanner(generateRandomPoints(numPts, rand), Algorithm.MergeSort);
		scanners[3] = new PointScanner(generateRandomPoints(numPts, rand), Algorithm.QuickSort);
		
		System.out.println("Algorithm size time (ns): ");
		System.out.println("-----------------------------------");
		for(int i = 0; i < 4; i++) {
			scanners[i].scan();
			System.out.println(scanners[i].stats());
		}
		System.out.println("-----------------------------------");
	}

  public static void filePoint(String file, PointScanner[] scanners) throws FileNotFoundException{
		scanners[0] = new PointScanner(file, Algorithm.SelectionSort);
		scanners[1] = new PointScanner(file, Algorithm.InsertionSort);
		scanners[2] = new PointScanner(file, Algorithm.MergeSort);
		scanners[3] = new PointScanner(file, Algorithm.QuickSort);
		
		System.out.println("Algorithm size time (ns): ");
		System.out.println("-----------------------------------");
		for(int i = 0; i < 4; i++) {
			scanners[i].scan();
			System.out.println(scanners[i].stats());
		}
		System.out.println("-----------------------------------");
	}
}
