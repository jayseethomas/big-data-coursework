package data_min_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.FloatBuffer;
import java.util.Scanner;

public class dtree {
	
	public static double log2(double x)
	{
	    return (double) (Math.log(x) / Math.log(2));
	}
	
	
	
	
	public static void infocalc() throws FileNotFoundException {
		double intItem;
		
		Scanner infile1 = new Scanner(new FileReader("Untitled 2"));

		int x; // # of opts (simple+cop=2)
		int y; // max # (5simple,3compound = 5)
		
		intItem = infile1.nextInt();
		x = (int) intItem;
		intItem = infile1.nextInt();
		y = (int) intItem;
		
		
		// [0] = opp
		// [1] = x
		// [2] = alt
		
		double[][] arr; 
		arr = new double[x][y];
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				intItem = infile1.nextInt();
				arr[i][j] = intItem;
			}
		}
		
		for(int i = 0; i < x; i++) {
			System.out.print("values_"+i+" :	");			
			for(int j = 0; j < y; j++) {
				System.out.print(arr[i][j] + ", ");			
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println();
		

		
		double[][] arrtotal;
		arrtotal = new double [x][1];
		for(int i = 0; i < x; i++) {
			double sum = 0;
			for(int j = 0; j < y; j++) {
				
				sum = sum +arr[i][j]	;
			}
			arrtotal[i][0] = sum;
			System.out.println("totalsum_"+i+ ":	" + sum);
			sum=0;
		}
		
		System.out.println();
		System.out.println();
		

		
		double[][] itotal;
		itotal = new double [x][1];
		for(int i = 0; i < x; i++) {
			System.out.print("ivalues_"+i+" :	");			

			double info = 0;
			for(int j = 0; j < y; j++) {
				
				if((arr[i][j]!= 0) && (arr[i][j]!= 0.0)) {
					
					info = info + ( (arr[i][j]/arrtotal[i][0]) * log2(1/( (arr[i][j]/arrtotal[i][0]))))	;
					System.out.print(info + ", ");

			}
			}
			itotal[i][0] = info;
			System.out.println();

			System.out.println("infototal_"+i+ ":	" + info);
			info=0;
			System.out.println();

		}
		
		System.out.println();
		System.out.println();
		
		
		
		double total_end = 0.0;
		for(int i = 0; i < arrtotal.length;  i++) {
			total_end = total_end+ arrtotal[i][0];
		}
		System.out.println("the total of all is:	" + total_end);
		System.out.println("can be used to fact check");


		System.out.println();
		System.out.println();
		
		
		
		
		
		
		double etotal = 0;
		for(int i = 0; i < x; i++) {
			System.out.print("evalues_"+i+" :	");			

			for(int j = 0; j < y; j++) {
				
				if((arr[i][j]!= 0) && (arr[i][j]!= 0.0)) {
					
					etotal = etotal + ( (arr[i][j]/total_end) * log2(1/( (arr[i][j]/arrtotal[i][0]))))	;
					System.out.print(etotal + ", ");

			}
			}
			
			System.out.println();

		}
		System.out.println();

		System.out.println("etotal_:	" + etotal);

		
		System.out.println();
		System.out.println();
		
		
		
		
	}
	
	    
	    
	  public static void summcalc() throws FileNotFoundException {
		  	double x0t0;
			double x0t1; 
			double x1t0;
			double x1tt;
			
			
			
			double intItem;
			
			Scanner infile1 = new Scanner(new FileReader("Untitled 4"));

			
			int z; //rows
			int w; //col
			
			intItem = infile1.nextInt();
			z = (int) intItem;
			intItem = infile1.nextInt();
			w = (int) intItem;
			
			// [0] = x
			// [1] = y
			// [2] = z
			// [3] = type
			// [4] count
			
			double[][] arr; 
			arr = new double[z][w];
			for(int i = 0; i < z; i++) {
				for(int j = 0; j < w; j++) {
					intItem = infile1.nextInt();
					arr[i][j] = intItem;
				}
			}
			
			for(int i = 0; i < z; i++) {
				System.out.print("values_"+i+" :	");			
				for(int j = 0; j < w; j++) {
					System.out.print(arr[i][j] + ", ");			
				}
				System.out.println();
			}
			
			
			System.out.println();
			System.out.println();
			
			
			// 6 choose 1
			// have four options and we choose 1 = 6
			
			/*
			 * x0y0t1
			 * x0y1t1
			 * x0y1t0
			 * x1y1t1
			 * x1y1t0
			 * x1y011
			 * 
			 */
			
			// looking at col 0, col 1 and 3
			int x = 0;
			int y = 1;
			int zz = 2;
			int t = 3;
			int counter = 4;
			int choose = 8;
			double[][] arr_temp = new double[choose][1];
			for(int i = 0; i < z; i++) {
				
				if((arr[i][x]==0.0) && (arr[i][y]==0.0) && (arr[i][t]==0.0)) {
					arr_temp[0][0]+= arr[i][counter];
				}
				else if((arr[i][x]==0.0) && (arr[i][y]==0.0) && (arr[i][t]==1.0)) {
					arr_temp[1][0]+= arr[i][counter];
				}
				else if((arr[i][x]==0.0) && (arr[i][y]==1.0) && (arr[i][t]==0.0)) {
					arr_temp[2][0]+= arr[i][counter];
				}
				else if((arr[i][x]==0.0) && (arr[i][y]==1.0) && (arr[i][t]==1.0)) {
					arr_temp[3][0]+= arr[i][counter];
				}
				else if((arr[i][x]==1.0) && (arr[i][y]==0.0) && (arr[i][t]==0.0)) {
					arr_temp[4][0]+= arr[i][counter];
				}
				else if((arr[i][x]==1.0) && (arr[i][y]==0.0) && (arr[i][t]==1.0)) {
					arr_temp[5][0]+= arr[i][counter];
				}
				else if((arr[i][x]==1.0) && (arr[i][y]==1.0) && (arr[i][t]==0.0)) {
					arr_temp[6][0]+= arr[i][counter];
				}
				else if((arr[i][x]==1.0) && (arr[i][y]==1.0) && (arr[i][t]==1.0)) {
					arr_temp[7][0]+= arr[i][counter];
				}
				System.out.println(arr[i][counter]);
			}
			
			System.out.println();
			System.out.println();
			
			double sum2=0;
			for(int i = 0; i < arr_temp.length; i++) {
				System.out.print("values_"+i+" :	");			
				for(int j = 0; j < arr_temp[0].length; j++) {
					sum2 = arr_temp[i][j]+sum2;
					System.out.print(arr_temp[i][j] + ", ");			
				}
				System.out.println();
			}
			System.out.println("sum2	 " +sum2);
	
			
		
		}
	public static void main(String[] args) throws FileNotFoundException {
		
		
	summcalc();
	//infocalc();

		

}
}