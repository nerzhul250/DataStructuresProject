package algoritmo;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Toom_Cook {
	
	public final static String GOOGLEPLEX="10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	public static String Toom(String a,String b){
		int negative=0;
		a=cleanValue(a);
		b=cleanValue(b);

		
	if(Math.max(a.length(), b.length())<=3){
		long f=Long.parseLong(a);
		long s=Long.parseLong(b);
		return (f*s)+"";
	}else{	
		if(a.equals("0")||b.equals("0")){
			return "0";
		}else if(a.equals("1")) {
			return b;
		}else if(b.equals("1")){
			return a;
		}else {
			if(a.charAt(0)=='-'&&b.charAt(0)!='-'){
				negative=1;
				a=a.replace("-", "");
			}else if(b.charAt(0)=='-'&&a.charAt(0)!='-') {
				negative=1;
				b=b.replace("-", "");
			}else if(b.charAt(0)=='-'&&a.charAt(0)=='-'){
				b=b.replace("-","");
				a=a.replace("-","");
			}
			//here we goooooo
			if(a.charAt(0)=='0'){
				a=a.substring(1);
			}if(b.charAt(0)=='0') {
				b=b.substring(1);
			}
			int TheMain=0;
			
			int TheA=(OperacionBasica.log10(a)/3);
			
			int TheB=(OperacionBasica.log10(b)/3);
			
			if(TheB<TheA){
			TheMain=TheA;}
			else if(TheB>TheA) {
			TheMain=TheB;
			}else {
				TheMain=TheA;
			}
			
			
			TheMain=TheMain+1;
			
			
			String a0,a1,a2,b0,b1,b2;
			
			a2="0";
			a1="0";
			a0="0";
			
			b2="0";
			b1="0";
			b0="0";
			
			
			if(a.length()>3) {

			String[] partitionsA=cutter(a,TheMain);
			
			
			
			a2=cleanValue(partitionsA[2]);
			a1=cleanValue(partitionsA[1]);
			a0=cleanValue(partitionsA[0]);
			System.out.println("Valores a multiplicar; "+a+"*"+b);
			System.out.println("Separar cada "+TheMain+" digitos");
			System.out.println("Primer polinomio:");
			System.out.println("A(x)="+a2+"x^2+"+a1+"x+"+a0);
			}else if(a.length()==1) {
				
				a2=0+"";
				a1=0+"";
				a0=a.charAt(0)+"";
				
			}else if(a.length()==2) {
				a2=0+"";
				a1=a.charAt(1)+"";
				a0=a.charAt(0)+"";
				
			}else if(a.length()==3) {
				a2=a.charAt(2)+"";
				a1=a.charAt(1)+"";
				a0=a.charAt(0)+"";
				}
			
			
			if(b.length()>3) {
			String[] partitionsB=cutter(b,TheMain);
			b2=cleanValue(partitionsB[2]);
			b1=cleanValue(partitionsB[1]);
			b0=cleanValue(partitionsB[0]);
			System.out.println("Segundo polinomio:");
			System.out.println("B(x)="+b2+"x^2+"+b1+"x+"+b0+"\n");
			
			}else if(b.length()==1) {
				
				b2=0+"";
				b1=0+"";
				b0=b.charAt(0)+"";
				
			}else if(b.length()==2) {
				b2=0+"";
				b1=b.charAt(1)+"";
				b0=b.charAt(0)+"";
				
			}else if(b.length()==3) {
				a2=b.charAt(2)+"";
				a1=b.charAt(1)+"";
				a0=b.charAt(0)+"";
				}
		
			String control=OperacionBasica.sumaGeneral(a0,a2) ;
			String AdeCero=a0;
			String AdeUno=OperacionBasica.sumaGeneral(control,a1);
			String AdeMenosUno=OperacionBasica.sumaGeneral(control,"-"+a1);
			String first=OperacionBasica.sumaGeneral(AdeMenosUno, a2);
			String second=OperacionBasica.sumaGeneral(first, first);
			String AdeMenosDos=OperacionBasica.sumaGeneral(second,"-"+a0);
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

			
			
			String aAlaCuatro=concaternarCeros(cuatro, (int)TheMain*4);
			String aAlaTres=concaternarCeros(tres, (int)TheMain*3);
			String aAlaDos=concaternarCeros(dos, (int)TheMain*2);
			String aAlaUno=concaternarCeros(uno, (int)TheMain);
			String aAlaCero=cero;
			
			String suma=OperacionBasica.sumaGeneral(aAlaCuatro, aAlaTres);
			suma=OperacionBasica.sumaGeneral(suma,aAlaDos);
			suma=OperacionBasica.sumaGeneral(suma,aAlaUno);
			suma=OperacionBasica.sumaGeneral(suma,aAlaCero);
			
			if(negative==1){
				return "-"+suma;}
			else{
			return suma;
			}
			
		}
			
			
		}
		
	}
	
	private static String[] cutter(String string, long low) {
		
       char[] arreglo=string.toCharArray();
       
      String[] retorno=new String[3];
      int cuenta=0;
       int control=0;
       String anadir="";
        for(int i=string.length()-1;i>=0;i--) {
        	
        	anadir=arreglo[i]+anadir;
        	control++;
        	if(control==low&&cuenta<3){
        		retorno[cuenta]=anadir;
        		control=0;
        		anadir="";
        		cuenta++;
        	}
        }
     	if(!anadir.isEmpty()){
     		if(retorno[2]==null) {
     			retorno[2]=anadir;}else {

     		retorno[2]=anadir+retorno[2];}
    	}
     	

        return retorno;
		
		
    }
	
	public static String cleanValue(String a) {
		
		String retorno="0";
		if(a!=null){
			if(a.length()!=1){	
				if(a.charAt(0)=='0'){
					a="-"+a;
					a=a.replace("-0", "");
			
		}
		retorno=a;
		
		}
			retorno=a;
	}
		return retorno;
		
	}
	
	public static String concaternarCeros(String a, int expo) {
		String retorno=a;
		for(int i=0;i<expo;i++) {
			retorno=retorno+"0";
		}
		return retorno;
	}
	// solopara pruebas despues toca borrarlooooooooo
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a=System.nanoTime();
		System.out.println(Toom("1234567890123456789012","987654321987654321098"));
		long b=System.nanoTime();
		//double seconds = (double)b-a / 1000000000.0;
		

		System.out.println(b-a);
		
	}
}
