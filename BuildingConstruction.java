/**
 * 
 */
package com.greatLearning.gradedProject2;

import java.util.Scanner;

/**
 * @author Shreyas
 *
 */
public class BuildingConstruction {

	/**
	 * @param args
	 */
	
	int floors;
	int arr[];
	
	Scanner sc = new Scanner(System.in);
	
	public void noOfFloors() {
		System.out.println("Enter the number of floors for the building : ");
		floors = sc.nextInt();
		arr = new int[floors];
	}
	
	public void floorPlan() {
		noOfFloors();
		for(int i = 0; i < floors; i++) {
			System.out.println("Enter the floor size on Day "+(i+1));
			arr[i] = sc.nextInt();
		}
		int count = 1;
		int maxOfArr = getMaxFromArr();
		for(int i = 0; i < floors; i++) {
			System.out.println("Day "+count);
			if(arr[i] == maxOfArr) {
				int k = i;
				while(k >= 0 && arr[k] == maxOfArr) {
					System.out.print(arr[k]+" ");
					arr[k] = 0;
					maxOfArr = getMaxFromArr();
					k--;
				}
				System.out.println();
			}else {
				System.out.println();
			}
			count++;
		}
	}
	
	public int getMaxFromArr() {
		int max= Integer.MIN_VALUE;
		for(int k = 0; k < floors; k++) {
			if(arr[k] > max) {
				max = arr[k];
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuildingConstruction buildPlan =  new BuildingConstruction();
		buildPlan.floorPlan();

	}

}
