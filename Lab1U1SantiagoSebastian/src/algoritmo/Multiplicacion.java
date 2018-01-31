package algoritmo;

import java.util.ArrayList;
import java.util.Arrays;

public class Multiplicacion {
	private ArrayList<String> procedimiento;
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
		
		  //////////////
		  StringBuilder bloque=new StringBuilder();
	      bloque.append("Karatsuba(");
	      bloque.append(A);
	      bloque.append(",");
	      bloque.append(B);
	      bloque.append(")\n");
	      //////////////
	      
		  if(A.length()==1 || B.length()==1){
			  if(A.length()==1 && A.charAt(0)=='0' ||
					  B.length()==1 && B.charAt(0)=='0'){
				  bloque.append("respuesta: 0");
				  bloque.append("\n");
				  procedimiento.add(bloque.toString());
				  return "0";
			  }
			  if(A.length()==1 && B.length()==1){
				  int a=Integer.parseInt(A);
				  int b=Integer.parseInt(B);
				  String respuesta= (a*b)+"";
				  bloque.append("respuesta: ");
				  bloque.append(respuesta);
				  bloque.append("\n");
				  procedimiento.add(bloque.toString());
				  return respuesta;
			  }
		  }
		  
		  //////////////
		  bloque.append("Sean X=");bloque.append(A);bloque.append(" y ");
		  bloque.append("Y=");bloque.append(B+"\n");
		  //////////////
		  
		  int m =(A.length()>B.length())?A.length():B.length();
		  int m2 = m/2;
		  //S.length-(S.length/2) 0 high, 1 low
		  String[] ex1=splitAt(A, m2);			  
		  String[] ex2=splitAt(B, m2);
		  
          //////////////
		  bloque.append("Los partimos a la mitad...\n");
		  bloque.append("X_h="+ex1[0]+", X_l="+ex1[1]+"\n");
		  bloque.append("Y_h="+ex2[0]+", Y_l="+ex2[1]+"\n");
		  //////////////
		  
		  /* 3 calls made to numbers approximately half the size */
		  String z0 = karatsuba(ex1[1],ex2[1]);
		  String sam1=OperacionBasica.sum(ex1[0],ex1[1]);
		  String sam2=OperacionBasica.sum(ex2[0],ex2[1]);
		  String z1 = karatsuba(sam1,sam2);
		  String z2 = karatsuba(ex1[0],ex2[0]);
		  
          //////////////
		  bloque.append("Hacemos tres multiplicaciones...\n");
		  bloque.append("Sea A=X_h*Y_h=Karatsuba("+ex1[0]+","+ex2[0]+")\n");
		  bloque.append("Sea B=X_l*Y_l=Karatsuba("+ex1[1]+","+ex2[1]+")\n");
		  bloque.append("Sea C=(X_h+X_l)*(Y_h+Y_l)=Karatsuba("+sam1+","+sam2+")\n");
		  //////////////
		  
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
		  
		  String respuesta=OperacionBasica.sum(OperacionBasica.sum(z2,za),z0);
		 
          //////////////
		  bloque.append("Finalmente...\n");
		  bloque.append("X*Y=A*10^(2*M2)+(C-A-B)*10^M2+B\n");
		  bloque.append("Respuesta: "+respuesta+"\n");
		  //////////////
		  
		  procedimiento.add(bloque.toString());
		  
		  return respuesta;
	}
	
	public ArrayList<String> getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(ArrayList<String> procedimiento) {
		this.procedimiento = procedimiento;
	}
	public Multiplicacion(){
		procedimiento=new ArrayList<String>();
	}
}