package algoritmo;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Toom_Cook {
	
	private static ArrayList<String> procedimiento;
	
	public Toom_Cook() {
		procedimiento=new ArrayList<String>();
		
	}
	
	public final static String GOOGLEPLEX="10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	public static String Toom(String A,String B){
		int neg=0;
		 //////////////
		  StringBuilder bloque=new StringBuilder();
	      bloque.append("Toom-3(");
	      bloque.append(A);
	      bloque.append(",");
	      bloque.append(B);
	      bloque.append(")\n");
	      //////////////
	      if(A.equals("0")||B.equals("0")) {
	    	  //////////////
			  bloque.append("La multiplicacion por algun cero es igual a cero\n");
			  bloque.append("respuesta: 0");
			  bloque.append("\n");
			  procedimiento.add(bloque.toString());
	          //////////////
	    	  return "0";
	    	  
	      }
		if(A.charAt(0)=='-' || B.charAt(0)=='-'){
			if(A.charAt(0)=='-' && B.charAt(0)=='-'){
				A=A.substring(1);
				B=B.substring(1);
			}else{
				if(A.charAt(0)=='-'){
					A=A.substring(1);
				}else{
					B=B.substring(1);
				}
				neg=1;				
			}
			}
	if(A.length()<7 && B.length()<7){
		
		if(neg==1){
			  //////////////
			  bloque.append("No vale la pena multiplicar con Toom-Cook en este caso dado que son numeros muy cortos\n");
			  bloque.append("respuesta: "+-1*Long.parseLong(A)*Long.parseLong(B));
			  bloque.append("\n");
			  procedimiento.add(bloque.toString());
	          //////////////
			return (-1*Long.parseLong(A)*Long.parseLong(B))+"";
			 
		}else{
			  //////////////
			  bloque.append("No vale la pena multiplicar con Toom-Cook en este caso dado que son numeros muy cortos\n");
			  bloque.append("respuesta: "+Long.parseLong(A)*Long.parseLong(B));
			  bloque.append("\n");
			  procedimiento.add(bloque.toString());
	          //////////////
			return (Long.parseLong(A)*Long.parseLong(B))+"";	}
		}
	  //////////////
	  bloque.append("Sean A=");bloque.append(A);bloque.append(" y ");
	  bloque.append("B=");bloque.append(B+"\n");
	  procedimiento.add(bloque.toString());
	  //////////////
	
			int TheMain=0;
			
			int TheA=(OperacionBasica.log10(A)/3);
			
			int TheB=(OperacionBasica.log10(B)/3);
			
			if(TheB<TheA){
			TheMain=TheA;}
			else{
			TheMain=TheB;
	}
			TheMain++;
			 //////////////
			  bloque.append("Separamos los numeros A y B cada---->"+TheMain+"digitos\n");
			  //////////////
			
			String a0,a1,a2,b0,b1,b2;
			
			String[] partitionsA=split(A,TheMain);
			String[] partitionsB=split(B,TheMain);
			
			
			a2=partitionsA[2];
			a1=partitionsA[1];
			a0=partitionsA[0];
			
			  //////////////
			  bloque.append("Generamos el polinomio A(x)...\n");
			  bloque.append("A(x)="+a2+"x^2"+a1+"x"+a0+"\n");
			  //////////////
			
			b2=partitionsB[2];
			b1=partitionsB[1];
			b0=partitionsB[0];
			
			 //////////////
			  bloque.append("Generamos el polinomio B(x)...\n");
			  bloque.append("A(x)="+b2+"x^2"+b1+"x"+b0+"\n");
			  //////////////
			  
			  
			  //////////////
			  bloque.append("Ahora nos dedicamos a generar este producto y lo llamamos R(x) \n");
			  bloque.append("R(x)=A(x)*B(x) \n");
			  //////////////
			String control=OperacionBasica.sumaGeneral(a0,a2) ;
			String AdeCero=a0;
			String AdeUno=OperacionBasica.sumaGeneral(control,a1);
			String AdeMenosUno=OperacionBasica.sumaGeneral(control, "-"+a1);
			String first=OperacionBasica.sumaGeneral(AdeMenosUno, a2);
			String second=OperacionBasica.sumaGeneral(first, first);
			String AdeMenosDos=OperacionBasica.sumaGeneral(second, "-"+a0);
			String AdeInfinito=a2;
			
			String Bcontrol= OperacionBasica.sumaGeneral(b0,b2);
			String BdeCero=b0;
			
			String BdeUno=OperacionBasica.sumaGeneral(Bcontrol,b1);
			String BdeMenosUno=OperacionBasica.sumaGeneral(Bcontrol, "-"+b1);
			String Bfirst=OperacionBasica.sumaGeneral(BdeMenosUno, b2);
			String Bsecond=OperacionBasica.sumaGeneral(Bfirst,Bfirst);
			String BdeMenosDos=OperacionBasica.sumaGeneral(Bsecond, "-"+b0);
			String BdeInfinito=b2;
			
			
			//llamados recursivos.
			
			String rCero=Toom(AdeCero,BdeCero);
			String rUno =Toom(AdeUno,BdeUno );
			String rMenosUno =Toom(AdeMenosUno,BdeMenosUno );
			String rMenosDos =Toom(AdeMenosDos, BdeMenosDos);
			String rInfinito =Toom(AdeInfinito,BdeInfinito );
			
			//bodrato trick
			String cero=rCero;
			String cuatro=rInfinito;
			
			String tres=OperacionBasica.divisionByN(OperacionBasica.sumaGeneral(rMenosDos, "-"+rUno), 3);
			
			String uno=OperacionBasica.divisionByN(OperacionBasica.sumaGeneral(rUno, "-"+rMenosUno), 2);			
			String dos=OperacionBasica.sumaGeneral(rMenosUno, "-"+rCero);
			
			String dobleInfinito=OperacionBasica.sumaGeneral(rInfinito, rInfinito);
			String res=OperacionBasica.sumaGeneral(dos,"-"+tres);
			tres=OperacionBasica.sumaGeneral(OperacionBasica.divisionByN(res, 2), dobleInfinito);
			
			String save=OperacionBasica.sumaGeneral(dos, uno);
			dos=OperacionBasica.sumaGeneral(save, "-"+cuatro);
			uno=OperacionBasica.sumaGeneral(uno, "-"+tres);
			
			 //////////////
			  bloque.append("El polinomio R(x) es encontrado tras una serie de sumas y 5 llamados recursivos \n");
			  bloque.append("R(x)="+cuatro+"x^4"+tres+"x^3"+dos+"x^2"+uno+"x"+cero+"\n");
			  //////////////
			
			  //////////////
			  bloque.append("Por ultimo se hace R(10^i) \n");
			  bloque.append("Siendo i="+ TheMain+"\n");
			  //////////////
			
			String aAlaCuatro=addZeroes(cuatro, (int)TheMain*4);
			String aAlaTres=addZeroes(tres, (int)TheMain*3);
			String aAlaDos=addZeroes(dos, (int)TheMain*2);
			String aAlaUno=addZeroes(uno, (int)TheMain);
			String aAlaCero=cero;
			
			
			
			String suma=OperacionBasica.sumaGeneral(aAlaCuatro, aAlaTres);
			suma=OperacionBasica.sumaGeneral(suma,aAlaDos);
			suma=OperacionBasica.sumaGeneral(suma,aAlaUno);
			suma=OperacionBasica.sumaGeneral(suma,aAlaCero);
			
			if(neg==1){
				  //////////////
				
				bloque.append("Siendo el resultado final "+ "-"+suma+"\n");
				  //////////////
				  procedimiento.add(bloque.toString());
				return "-"+suma;			
			}else{
				  //////////////
				  bloque.append("Siendo el resultado final "+ suma+"\n");  
				  //////////////
				  procedimiento.add(bloque.toString());
				return suma;
			}
			
			//metodo
			}
	private static String[] split(String a, int k) {
		int counter=0;
		String[] arr=new String[3];
		Arrays.fill(arr,"");
		int indice=0;
		for (int i = a.length()-1; i >=0; i--) {
			counter++;
			arr[indice]=a.charAt(i)+arr[indice];
			if(counter%k==0){
				indice++;
			}
		}
		if(arr[0].equals("")) {
			arr[0]="0";
		}
        if(arr[1].equals("")) {
        	   arr[1]="0";
		}
        if(arr[2].equals("")) {
        	    arr[2]="0";
		}
		return arr;
	}
	
	private static String addZeroes(String a, int i) {
		for (int j = 0; j < i; j++) {
			a=a+"0";
		}
		return a;
		}
	
	public ArrayList<String> getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(ArrayList<String> procedimiento) {
		this.procedimiento = procedimiento;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A="123456789123456789";
		String B="0";
		
		
		BigInteger a = new BigInteger(A);
		BigInteger b = new BigInteger(B);
		long i=System.nanoTime();
		System.out.println("el primer numero tien un largo de "+A.length()+" Y el segundo de "+B.length());
		System.out.println("Resultado artesanal: "+Toom(A,B));
		long f=System.nanoTime();
		System.out.println("It took: "+(f-i));
		//i=System.nanoTime();
		//System.out.println("Resultado BigInetegger: "+a.multiply(b)+"\n");
		//f=System.nanoTime();
		//System.out.println("It took: "+(f-i));
		
	}
	
}
