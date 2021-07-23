package lag;
import no.geosoft.cc.math.calculus.LagrangeInterpolation;
import java.lang.Math;


import Jama.*;


public class lag {
	
	
	 
	public static double abs(double a) {
		if (a  <= 0) {
			return (- a);
		}
		else return (a);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		double[] x = {1.2, 2.3, 3.1, 4.4, 5.8, 6.5, 7.6, 8.6};
		double[] y =  {10.4, 11.3, 12.5, 13.24, 14.12, 15.19, 16.16, 17.16 };
		
		double[] formula = LagrangeInterpolation.findPolynomialFactors(x, y);
		
		int count = formula.length;
		for(int i = 0; i < formula.length; i++) {
			System.out.println(formula[i]+ " x^"+  (count-1)  +" "); 
			count--;
		}

		
		
		double sol=1.2;
		double calc1 = 0.00065987 * Math.pow(sol, 7);
		double calc2 = -0.029600142181501844 * Math.pow(sol, 6);
		double calc3 = 0.3572421360031249 * Math.pow(sol, 5);
		double calc4 = -2.1452343927935664 * Math.pow(sol, 4);
		double calc5 = 6.643910373172446 * Math.pow(sol, 3);
		double calc6 = -9.854625348715214 * Math.pow(sol, 2);
		double calc7 = 6.302076135380213 * Math.pow(sol, 1);
		double calc8 = 9.191841543319532 * Math.pow(sol, 0);


		System.out.println();
		System.out.println("the value for x =" +sol +" is " +(calc1+calc2+calc3+calc4+calc5+calc6+calc7+calc8));
		
		
		System.out.println(Math.abs(-1+2));
		
		

	}

	}
	


