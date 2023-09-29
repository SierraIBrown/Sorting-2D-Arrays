package edu.iastate.cs228.hw2;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
import java.io.FileNotFoundException;

/**
*@author Sierra Izumi Brown
*/

/**
* Abstract class is extended by SelectionSort, InsertionSort, MergeSort, and QuickSort
*/
public abstract class AbstractSorter{
  protected Point[] points;
  protected String algorithm = null;
  protected Comparator<Point> pointComparator = null;

  protected AbstractSorter(){
    //
  }

  protected AbstractSorter(Point[] pts) throws IllegalArgumentException{
    if(pts == null || pts.length == 0){
      throw new IllegalArgumentException();
    }
    else{
      getPoints(pts);
    }
  }

  public void setComparator(int order) throws IllegalArgumentException{
    if(order < 0 || order > 1){
      throw new IllegalArgumentException();
    }
    else{
      if(order == 0){
        Point.setXorY(true);
      }
      else{
        Point.setXorY(false);
      }
    }
  }

  public abstract sort();

  public Point getMedian(){
    return points[points.length/2];
  }

  public void getPoints(Point[] pts){
    points = pts;
  }

  protected void swap(int i, int j){
    Point temp = points[i];
    points[i] = points[j];
    points[j] = temp;
  }
}
