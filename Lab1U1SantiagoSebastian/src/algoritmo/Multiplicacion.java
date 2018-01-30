package algoritmo;

public class Multiplicacion {
	public String sum(String A, String B){
		char[][] matrix=new char[4][A.length()];
		matrix[1]=A.toCharArray();
		matrix[2]=B.toCharArray();
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i]='0';
		}
		for (int i = matrix[0].length-1; i >=0; i--) {
			int a=0;
			for (int j = 0; j < matrix.length-1; j++) {
				a+=Integer.parseInt(matrix[j][i]+"");
			}
			String b=a+"";
			if(b.length()==2){
				matrix[0][i-1]=b.charAt(0);
				matrix[3][i]=b.charAt(1);
			}else{
				matrix[3][i]=b.charAt(0);
			}
		}
		return matrix[3].toString();
	}
	public String substract(String A, String B){
		//easypeasy
		return "";
	}
	public String karatsuba(String A,String B){
		  if(A.length()==1 || B.length()==1){
			  int a=Integer.parseInt(A);
			  int b=Integer.parseInt(B);
			  return a*b+"";
		  }
		  int m =(A.length()>B.length())?A.length():B.length();
		  int m2 = m/2;
		  if(A.length()!=m){
			  StringBuilder sb=new StringBuilder();
			  int dif=m-A.length();
			  for (int i = 0; i < dif; i++) {
				sb.append("0");
			  }
			  A=sb.toString()+A;
		  }else{
			  StringBuilder sb=new StringBuilder();
			  int dif=m-B.length();
			  for (int i = 0; i < dif; i++) {
				sb.append("0");
			  }
			  B=sb.toString()+B;
		  }
		  //S.length-(S.length/2) 0 high, 1 low
		  String[] ex1= splitAt(A, m2);
		  String[] ex2= splitAt(B, m2);
		  /* 3 calls made to numbers approximately half the size */
		  String z0 = karatsuba(ex1[1],ex2[1]);
		  String z1 = karatsuba((ex1[0]+ex1[1]),(ex2[0]+ex2[1]));
		  String z2 = karatsuba(ex1[0],ex2[0]);
		  return z2+substract(z1,sum(z2,z0))+z0;
	}
	public String[] splitAt(String A,int k){
		String[] ke=new String[2];
		k=A.length()-k;
		ke[0]=A.substring(0,k);
		ke[1]=A.substring(k,A.length());
		return ke;
	}
}
//No borrar
//tabla de sustracion, j-i mod 10 es el indice donde se encuentra el resultado de
// una sustracion elemental en el arreglo {0 9 8 7 6 5 4 3 2 1}, i es el numero al que se le resta j.
