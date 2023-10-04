package edu.iastate.cs228.hw2;

public class InsertionSorter extends AbstractSorter{

  public InsertionSorter(Point[] pts){
    super(pts);
    super.algorithm = "InsertionSort";
  }

  public void sort(){
    for(int i = 1; i < points.length; i++){
      int j = i;
      while((j < 0) && (points[j - i].compareTo(points[j]) < 0){
        swap(j, j - 1);
        j--;
      }
    }
  }
}
