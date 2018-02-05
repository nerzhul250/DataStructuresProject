package algoritmo;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Toom_Cook {
	
	public final static String GOOGLEPLEX="10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	public static String Toom(String A,String B){
		int neg=0;
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
			return (-1*Long.parseLong(A)*Long.parseLong(B))+"";
		}else{
			return (Long.parseLong(A)*Long.parseLong(B))+"";	}
		}
	
			int TheMain=0;
			
			int TheA=(OperacionBasica.log10(A)/3);
			
			int TheB=(OperacionBasica.log10(B)/3);
			
			if(TheB<TheA){
			TheMain=TheA;}
			else{
			TheMain=TheB;
	}
			TheMain++;
			
			String a0,a1,a2,b0,b1,b2;
			
			String[] partitionsA=split(A,TheMain);
			String[] partitionsB=split(B,TheMain);
			
			
			a2=partitionsA[2];
			a1=partitionsA[1];
			a0=partitionsA[0];
			
			b2=partitionsB[2];
			b1=partitionsB[1];
			b0=partitionsB[0];
			
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
			
			//por ultimo se computa el polinomio con las respuestas del bordato trick
			
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
				return "-"+suma;			
			}else{
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BigInteger a = new BigInteger("8");
		BigInteger b = new BigInteger("54334545442323");
		System.out.println("Resultado BigInetegger: "+a.multiply(b)+"\n");
		
		System.out.println("Resultado artesanal: "+Toom("8","54334545442323"));
	
	}
	
}
