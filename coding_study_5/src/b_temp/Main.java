package b_temp;

import java.util.Random;

public class Main {
	
	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void InsertionSort(int[] arr)
	{
	   for(int i = 1 ; i < arr.length ; i++){ 
	      int temp = arr[i];
	      int prev = i - 1;
	      while( (prev >= 0) && (arr[prev] > temp) ) {  
	         arr[prev+1] = arr[prev];
	         prev--;
	      }
	      arr[prev + 1] = temp;         
	   }
	}
	
	public static void DualPivotQuickSort(int arr[], int left, int right) {
	    if(left <= right){
	        if(arr[left] > arr[right])
	            swap(arr, left, right); 
	        
	        int p1 = arr[left]; 	// left pivot
	        int p2 = arr[right]; 	// right pivot
	        int l = left + 1; 
	        int k = left + 1;
	        int g = right - 1;	      
	        
		    while(k <= g){ //서로 만날때까지
		    	if(arr[k] < p1){
		    		swap(arr, k, l);
		    		l++;
		    	}else {
		    		if(arr[k] > p2){
		    			while(arr[g] > p2 && k < g)
		    				g--;
	                
		    			swap(arr, k, g);
		    			g--;
		    			if(arr[k] < p1){
		    				swap(arr, k, l);
		    				l++;
		    			}
		    		}
		    	}
	        k++;
	    }
		    l--; g++;
		    
		    swap(arr, left, l);
		    swap(arr, right, g);
		    DualPivotQuickSort(arr, left, l - 1);
		    DualPivotQuickSort(arr, l + 1, g-1);
		    DualPivotQuickSort(arr, g + 1, right);
	    }
	}

	public static void main(String[] args) {
		Random r = new Random();
		int n = 17, Asize = 10;
		int[] A = new int[Asize];
		for(int i = 0; i < Asize; i++)
			A[i] = r.nextInt(Asize);
		
		System.out.println("정렬 전");
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		
		System.out.println("\n정렬 후");
		
		if(A.length > n)
			DualPivotQuickSort(A, 0, Asize-1);
		else
			InsertionSort(A);

		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}
}
