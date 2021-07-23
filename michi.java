package mutualifochi;


public class michi {
	/*
	 * 
	 * 
	 * to get associative patterns and chi
	 * 
	 * 
	 * 
	 */
	
	public static double log2(double x)
	{
	    return (double) (Math.log(x) / Math.log(2));
	}
	

	public static void main(String[] args) {
		
		// want to fill in
		int n = 5;
		int index = 0; // begins at 0!!!!
		double ss = (3*3);
		double order = 2;
		double maxcount = 3600d;
		double count[] = {600d,400,400,600,800};
	
		// pr array holden
		double pr[] = new double[n];
		for (int i = 0; i <pr.length;i++) {
			pr[i] = (count[i]/maxcount);
			System.out.println(pr[i]);
		}
		
		
		/*
		 * 
		 * 
		 * need to change
		 * 									pr x1=1 * pr x2=0, 	*	prx3=2, 	*	x4=0
		 * x1 = sum_p[1-i] where x1 = 1
		 * 
		 * 
		 */
		//add
		double x1 = (pr[0]);
		double x2 = (pr[1]);
		double x3 = (pr[2]);
		double x4 = (pr[3]);
		double x5 = (pr[4]);

		//multi
		double prod_p = (.15123); 


		
		
		
		
		
		
		
		
		double pr_this = pr[index];
		double count_q = count[index]; //
		double O_Exp = order/2;
		
		
		// hats	
		double e_prime = log2(ss);
		double e_hat = 0.0;
		for (int i = 0; i <count.length;i++) {
			e_hat += ((count[i]/maxcount) * log2((maxcount/count[i])));

		}
		System.out.println("orded is:	" +order);
		System.out.println("e_prime is:	" +e_prime);
		System.out.println("e_hat is:	" +e_hat);
		
		// (E'/E)^(O/2)}
		double e_div = e_hat/e_prime;
		double e_exp = Math.pow(e_div, O_Exp);

		System.out.println("pr(this):	" +pr_this);
		System.out.println("pr(prod):	" +prod_p);
		
		// CHI SQ
		double chi_2 = ((Math.pow((pr_this - prod_p), 2))/prod_p); 
		System.out.println("chi_squared:	" +chi_2);
		
		//{Chisquare / 2N}^{(E'/E)^(O/2)
		double chi_exp = Math.pow((chi_2/2), e_exp);
		System.out.println("chi_squared_pow:	" +chi_exp);
		
		//(1/PR){Chisquare / 2N}^{(E'/E)^(O/2)}
		double final_thing = (1/pr_this)*chi_exp;
		System.out.println("final lhs :	" +final_thing);


	
		
		System.out.print("rhs : " + log2(pr_this/prod_p));
		

	}

}
