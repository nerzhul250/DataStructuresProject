package algoritmo;

import java.awt.List;
import java.util.ArrayList;

public class Toom_Cook {
	public static String Toom(String a,String b){
		if(a.equals("0")||b.equals(0)){
			return "0";
		}else if(a.equals("1")) {
			return b;
		}else if(a.equals("1")){
			return a;
		}else {
			//here we goooooo
			long asize=a.length();
			long bsize=b.length();
			
			long longest= Math.max(asize, bsize);
			
			long low=(longest+2)/3;
			
			String a0,a1,a2,b0,b1,b2;
			
			ArrayList<String> partitionsA=cutter(a,low);
			ArrayList<String> partitionsB=cutter(b,low);
			a2=partitionsA.get(2);
			a1=partitionsA.get(1);
			a0=partitionsA.get(0);
			
			System.out.println(a2);
			System.out.println(a1);
			System.out.println(a0);
			
			b2=partitionsB.get(2);
			b1=partitionsB.get(1);
			b0=partitionsB.get(0);
			
			String control= a0+a2;
			String AdeCero=a0;
			String AdeUno=OperacionBasica.sum(control,a1);
			String AdeMenosUno=OperacionBasica.substract(control, a1);
			String first=OperacionBasica.sum(AdeMenosUno, a2);
			String second=OperacionBasica.sum(first, first);
			String AdeMenosDos=OperacionBasica.substract(second, a0);
			String AdeInfinito=a2;
			
			String Bcontrol= b0+b2;
			String BdeCero=b0;
			String BdeUno=OperacionBasica.sum(Bcontrol,b1);
			String BdeMenosUno=OperacionBasica.substract(Bcontrol, b1);
			String Bfirst=OperacionBasica.sum(BdeMenosUno, b2);
			String Bsecond=OperacionBasica.sum(first, first);
			String BdeMenosDos=OperacionBasica.substract(second, b0);
			String BdeInfinito=b2;
			//llamados recursivos cichis
			
			String rCero=Toom(AdeCero,BdeCero);
			String rUno =Toom(AdeUno,BdeUno );
			String rMenosUno =Toom(AdeMenosUno,BdeMenosUno );
			String rMenosDos =Toom(AdeMenosDos, BdeMenosDos);
			String rInfinito =Toom(AdeInfinito,BdeInfinito );
			
			//bodrato trick
			String cero=rCero;
			String cuatro=rInfinito;
			//TODO
			//la linea de abajo se tiene que dividir entre tres
			String tres=OperacionBasica.substract(rMenosDos, rUno);
			String uno=OperacionBasica.substract(rUno, rMenosUno);
			String dos=OperacionBasica.substract(rMenosUno, rCero);
			//el de abajo es igual a (dos − tres)/2 + 2rInfinito
			//tres=;
			
			String save=OperacionBasica.sum(dos, uno);
			dos=OperacionBasica.substract(save, cuatro);
			uno=OperacionBasica.substract(uno, tres);
			
			//por ultimo s computa el polinomio con las respuestas del bordato trick
			
			
			return "termina tu work basurita";
			
			
		}
		
	}
	
	private static ArrayList<String> cutter(String string, long low) {
        ArrayList<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i=0; i<len; i+=low)
        {
            parts.add(string.substring(i, (int) Math.min(len, i + low)));
        }
        return parts;
    }
	// solopara pruebas despues toca borrarlooooooooo
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toom("1234567890123456789012","987654321987654321098");
	}
	

}
