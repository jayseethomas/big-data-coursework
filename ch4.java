package datamin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class ch4 {
	
	

	public double[][] firstAry;
	public double[] firstAry2;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner infile1 = new Scanner(new FileReader("/Users/JJThomas/Downloads/data.txt"));
		int n = 2;
		ch4 item4 = new ch4();
		
		/*
		 * 
		 * TO get entropy 
		 * 1. put the pr values into firstAry2
		 * 2. call enteropy func
		 * 3. n can be ignored
		 */
		item4.firstAry2 = new double[] {2d/8, 1d/8, 2d/8, 2d/8};
		item4.entropy(n,item4.firstAry2);
		
		
		
	
		
		// ch3 divergence
		// PG 70 in book
		double[] p1 = {.8, .1, .1};
		double[] q2 = {.1, .2, .7};
		item4.klDivergence(q2, p1);
		
		
		
		
		
		
		//woe
		double h1 = 3;
		double h2 = 3;
		double b_h1 = 3;
		double b_h2 = 2; // count
		double ss = 2*3*4*2; // sample space
		item4.woe(b_h1, b_h2, h1, h2, ss);
		

	}
	
	
	
	
	
	
	/*
	 * 
	 * weight of evidence
	 * can look in notebook for notes
	 * pr(b&h1), 	pr(b&2), 	pr(h1), 	pr(h2), sample space
	 * 
	 * 
	 * 
	 * double h1 = 3;
		double h2 = 3;
		double b_h1 = 3;
		double b_h2 = 2; // count
		double ss = 2*3*4*2; // sample space
		item4.woe(b_h1, b_h2, h1, h2, ss);
	 * 
	 */
	
	
	private void woe(double b_h1, double b_h2, double h1, double h2, double ss) {
		double pr_bh1 = b_h1/ss;
		double pr_bh2 = b_h2/ss;
		
		double div_top = pr_bh1/h1;
		double div_bot = pr_bh2/h2;
		
		double div = div_top/div_bot;
		System.out.println("weight of evidence is: 		" +log2(div));
		
	}





	
	
	

			/*
			 * enteropy
			 * example can be found in books and notes
			 * 
			 * 	item4.firstAry2 = new double[] {2d/8, 1d/8, 2d/8, 2d/8};
				item4.entropy(n,item4.firstAry2);
			 * 
			 * 		// = Sum (p_i * log2(1/p_i))

			 * 
			 * 
			 */


	private void entropy(int n, double[] firstAry) {
		
		double sum = 0;
		for(int i = 0; i< firstAry.length; i++) {
			sum = sum+(firstAry[i]) * log2(1/firstAry[i]);

		}
		
		System.out.println("the entropy is: 	" +sum);
		
	}
	
	
	
	
	
	
	public static double log2(double x)
	{
	    return (double) (Math.log(x) / Math.log(2));
	}
	
	
	
	
	
	

	public double[][] loadImg(Scanner infile1, double[][] firstAry3) {
		int intItem;
		for (int row = 1; row < firstAry3.length - 1; row++) {
			for (int col = 1; col < firstAry3[0].length - 1; col++) {
				intItem = infile1.nextInt();
				firstAry3[row][col] = intItem;

			}
		}

		return firstAry3;
	}
	
	
	
	
	
	
	
	
	  /**
     * 
     * this is relative entropy
     * 
     * Returns the KL divergence, K(p1 || p2).
     *
     * The log is w.r.t. base 2. <p>
     *
     * *Note*: If any value in <tt>p2</tt> is <tt>0.0</tt> then the KL-divergence
     * is <tt>infinite</tt>. Limin changes it to zero instead of infinite. 
     * 
     */
    public void klDivergence(double[] p1, double[] q2) {


      double klDiv = 0.0;

      for (int i = 0; i < p1.length; ++i) {
        if (p1[i] == 0.0) { continue; }
        if (q2[i] == 0.0) { continue; } // Limin

      klDiv += p1[i] * (log2(p1[i]/q2[i]));
      System.out.println(klDiv);
      }

       System.out.println("the kl div is:		" + (klDiv));
      // moved this division out of the loop -DM
    }
}

