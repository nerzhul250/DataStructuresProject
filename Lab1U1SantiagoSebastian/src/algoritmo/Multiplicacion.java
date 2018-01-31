package algoritmo;

import java.util.Arrays;

public class Multiplicacion {
	private String procedimiento;
	public String[] splitAt(String A,int k){
		String[] ke=new String[2];
		if(A.length()==1){
			 ke[0]="0";
			 ke[1]=A;
		}else{
			k=(A.length()-1)-k;
			if(k<0){
				ke[0]="0";
				ke[1]=A;
			}else{
				ke[0]=A.substring(0,k+1);
				ke[1]=A.substring(k+1,A.length());
			}
		}
		return ke;
	}
	public String karatsuba(String A,String B){
		  if(A.length()==1 && B.length()==1){
			  int a=Integer.parseInt(A);
			  int b=Integer.parseInt(B);
			  return a*b+"";
		  }
		  int m =(A.length()>B.length())?A.length():B.length();
		  int m2 = m/2;
		  //S.length-(S.length/2) 0 high, 1 low
		  String[] ex1=splitAt(A, m2);			  
		  String[] ex2=splitAt(B, m2);			  
		  /* 3 calls made to numbers approximately half the size */
		  String z0 = karatsuba(ex1[1],ex2[1]);
		  String z1 = karatsuba(OperacionBasica.sum(ex1[0],ex1[1]),OperacionBasica.sum(ex2[0],ex2[1]));
		  String z2 = karatsuba(ex1[0],ex2[0]);
		  
		  StringBuilder sb=new StringBuilder();
		  sb.append(OperacionBasica.substract(z1,OperacionBasica.sum(z2,z0)));
		  for (int i = 0; i < m2; i++) {
				sb.append("0");
		  }
		  String za=sb.toString();
		  
		  sb=new StringBuilder();
		  sb.append(z2);
		  for (int i = 0; i < m2*2; i++) {
			sb.append("0");
		  }
		  z2=sb.toString();
		 
		  return OperacionBasica.sum(OperacionBasica.sum(z2,za),z0);
	}
	
	public Multiplicacion(){
		
	}
}