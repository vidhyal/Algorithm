/*
 * This program implements the closest-pair algorithm as in lecture with essentially 1 change; 
 * the measuring distance used is Manhattan distance as opposed to Euclidean distance in the lecture.
 * The difference is denoted by the method dist() that takes in two 2D integral points and returns an 
 * integer (the Manhattan distance between the points). Since Euclidean distance could be a floating 
 * point value but Manhattan distance is always integral for integral start and end points, all metrics 
 * used by the program are integral.  
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
public static int closestDist(Point arrayX[], Point arrayY[],int start, int n){
	if (n<=3){
		return bruteForceClosest(arrayX,n);
	}
	
	int minDist =0; 
	int mid = (n-start)/2;
	Point midPoint = arrayX[mid];
	int dL = closestDist(arrayX, arrayY, 0,mid);
	int dR = closestDist(arrayX, arrayY,mid, n-mid);
	int d = min(dL, dR);
	Point block[] = new Point[n];
	int bInd=0;
	for (int i=start; i<n; i++){
		if (abs(arrayY[i].x - midPoint.x)<d){
			block[bInd] = arrayY[i];
			bInd++;
		}
	}
	minDist = min(d,closestinBlock(block,bInd,d));
	return minDist;
}

private static int bruteForceClosest(Point[] array, int n) {
	int min = Integer.MAX_VALUE;
	for (int i=0; i<n-1; i++){
		for (int j =i+1; j<n; j++){
			int distance =dist(array[i],array[j]); 
			if (distance<min)
				min = distance; 
		}
	}
	return min;
}

private static int closestinBlock(Point[] block, int n, int d) {
	int min = d;
	for (int i=0; i<n-1; i++){
		for (int j=i+1; j<n; j++){
			if(abs(block[i].y-block[j].y) > d)
				break;
			int distance = dist(block[i],block[j]);
			if (distance<min){
				min = distance;
			}
		}
	}
	return min;
}

private static int dist(Point point1, Point point2) {
	int distance = abs((point2.x -point1.x)) + abs((point2.y - point1.y));
	return distance;
}

private static int abs(int i) {
	if (i<0)
		return (i*-1);
	else return i;
}

public static int min(int a, int b){
	if (a<b)
		return a;
	else return b;
}

public static void main(String args[]) throws IOException{
	
	if(args.length <0){
    	System.out.println("please specify an argument");
    }
	// inFile is the input test file, in the format as mentioned in the homework description
    File inFile = new File(args[0]);
    BufferedReader br = new BufferedReader(new FileReader(inFile));
    
    int numOfCases =Integer.parseInt((br.readLine().split("\n"))[0]);
    for (int i =0; i<numOfCases; i++){
    	int n = Integer.parseInt(br.readLine().split("\n")[0]);
    	if (n<=0){
    		System.out.println("Case "+(i+1)+": "+0);
    	}
    	else{
    		
    	Point p[] = new Point[n];
        String points[] = br.readLine().split(" ");
        int k=0;
        for (int j =0; j<points.length; j=j+2){
        	p[k] = new Point(Integer.parseInt(points[j]), Integer.parseInt(points[j+1]));
        	k++;
        }
        if (n==1){System.out.println("Case "+(i+1)+": "+0);}
        else{
        int dist = closest(p, n);
    	System.out.println("Case "+(i+1)+": "+dist);}}
       
    }
	
}



private static int closest(Point[] p, int n) {
	
	if (n<3){
		return bruteForceClosest(p, n);
	}
	Point arrayX[] = new Point[n];
	Point arrayY[] = new Point[n];
	for (int i=0; i<n; i++){
		arrayX[i] = new Point(p[i].x,p[i].y);
		arrayY[i] = new Point(p[i].x,p[i].y);
	}
	MergeSort(arrayX, 0);
	MergeSort(arrayY, 1);
	return closestDist(arrayX, arrayY,0,n);
}


public static void MergeSort(Point arr[], int ind){
	Sort(arr,0,arr.length-1, ind);
}

/* 
 * This method divides the input array into two equal ( size differing by at 
 * most 1) sub-arrays, calls itself recursively to sort the sub-arrays and 
 * merges them back, returning a sorted portion ( a[l] to a[r]) of the array.
 */
public static void Sort(Point arr[], int l, int r, int ind){
	if (l<r){
		int m = (l+r)/2;
		Sort(arr,l,m, ind);
		Sort (arr, m+1, r, ind);
		Merge(arr,l,m,r, ind);
	}
}

/*
 * This method takes as input an array and three indices l, m and r. It assumes that 
 * the element of the array from indices l to m ( left sub-array) are sorted in 
 * ascending order and so are the elements in the region m+1 to r (right sub-array). 
 * It then starts by comparing from left to right, the elements of the left sub-array 
 * against those of the right sub-array and starts filling the actual array in sorted order.
 */
public static void Merge(Point arr[],int l, int m, int r, int ind){
	int len1 = m-l+1;
	int len2 = r-m;
	
	Point left[] = new Point[len1];
	Point right[] = new Point[len2];
	
	for (int i=0; i<len1; i++){
		left[i] = arr[l+i];
	}
	for (int i=0; i<len2; i++){
		right[i]= arr[m+1+i];
	}
	
	int i=0, j=0, k=l;
	// if ind ==0, compare 'x' values, else compare 'y' values.
	if (ind ==0){
	while(i<len1 && j<len2){
		if (left[i].x<right[j].x){
			arr[k] = left[i];
			i++;
		}
		else{
			arr[k]= right[j];
			j++;
		}
		k++;
	}
	}
	else if (ind ==1){
		while(i<len1 && j<len2){
			if (left[i].y<right[j].y){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k]= right[j];
				j++;
			}
			k++;
		}
		}
	
	/*
	 *  when all the elements of the array 'right' have been added to arr, but still 
	 *  some from left are remaining.
	 */
	while (i<len1){
		arr[k] = left[i];
		i++;
		k++;
	}
	/*
	 *  when all the elements of the array 'left' have been added to arr, but still 
	 *  some from right are remaining.
	 */
	while (j<len2){
		arr[k] = right[j];
		j++;
		k++;
	}
}


}