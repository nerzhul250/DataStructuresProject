package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBMS {
	public final static String directorioTabla ="./Tabla";
	
	public String[] camposActuales;
	private HashMap<Integer,Integer>camposRapidos;
	private int numeroRegistros;
	
	private RedBlackTree<String,Integer> arbolito1;
	private RedBlackTree<String,Integer> arbolito2;
	private AVLTree<String,Integer> arbolito3;
	
	public DBMS(){
	}
	/**
	 * @param archivo, es el file con el csv en el
	 * <pre>Los campos deben de estar en la primera linea del CSV
	 * @return
	 */
	public String[] cargarTabla(File archivo){
		numeroRegistros=0;
		File dirTabla =new File(directorioTabla);
		for(File file: dirTabla.listFiles()) 
		    if (!file.isDirectory()) 
		        file.delete();
		try {
			int r=1;
			BufferedReader fr=new BufferedReader(new FileReader(archivo));
			BufferedWriter fw=null;
			camposActuales=fr.readLine().split(",");
			String A=fr.readLine();
			while(A!=null && !A.isEmpty()){
				fw=new BufferedWriter(new FileWriter("./Tabla/R"+r+".txt"));
				fw.write(A+"\n");
				numeroRegistros++;
				A=fr.readLine();
				r++;
				fw.close();
			}
			fr.close();
		} catch (Exception e) {
			return null;
		}
		return camposActuales;
	}
	/**
	 * Ese metodo inicializa los arboles con toda la informacion que deben de tener
	 * debe de ser llamado despues de haber inicializado la tabla de un archivo csv
	 * @param c1 primer campo rapido(INDICE EN CAMPOSACTUALES)
	 * @param c2 segundo campo rapido(INDICE EN CAMPOSACTUALES)
	 * @param c3 tercer campo rapido(INDICE EN CAMPOSACTUALES)
	 * @throws IOException
	 */
	public void definirCamposRapidos(int c1,int c2,int c3) throws IOException{
		arbolito1=new RedBlackTree<>(); arbolito2=new RedBlackTree<>();
		arbolito3=new AVLTree<>(); camposRapidos=new HashMap<>();
		camposRapidos.put(c1,1); camposRapidos.put(c2,2); camposRapidos.put(c3,3);
		BufferedReader fr=null;
		for (int i = 1; i <=numeroRegistros ; i++) {
			fr=new BufferedReader(new FileReader("./Tabla/R"+i+".txt"));
			String[] A=fr.readLine().split(",");
			arbolito1.insertar(A[c1],i);
			arbolito2.insertar(A[c2],i);
			arbolito3.insertar(A[c3],i);
		}
		fr.close();
	}
	/**
	 * Es el tipico metodo de consulta, null si no se encuentra y algun valor si se encontro
	 * te da todos los registros en una lista de arreglos de strings, donde en la posicion 0
	 * se encuentra el valor del campo 1 y asi sucesivamente.
	 * @param campo
	 * @param llave
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String[]> consulta(int campo,String llave) throws IOException{
		if(camposRapidos.containsKey(campo)){
			int arbol=camposRapidos.get(campo);
			ArrayList<Integer>registros=new ArrayList<Integer>();
			RBTNode<String,Integer> n=null;
			AVLNode<String,Integer> a=null;
			switch(arbol){
				case 1:
					n=arbolito1.consultar(llave);
					if(n==null){
						registros=null;
					}else{
						while(n!=null){
							registros.add(n.getValor());
							n=n.getClon();
						}
					}
					break;
				case 2:
					n=arbolito2.consultar(llave);
					if(n==null){
						registros=null;
					}else{
						while(n!=null){
							registros.add(n.getValor());
							n=n.getClon();
						}
					}
					break;
				case 3:
					a=arbolito3.consultar(llave);
					if(a==null){
						registros=null;
					}else{
						while(a!=null){
							registros.add(a.getValor());
							a=a.getClon();
						}
					}
					break;
			}
			if(registros==null){
				return null;
			}else{
				BufferedReader fr=null;
				ArrayList<String[]> registro=new ArrayList<String[]>();
				for (int i = 0;i<registros.size() ; i++) {
					fr=new BufferedReader(new FileReader("./Tabla/R"+registros.get(i)+".txt"));
					registro.add(fr.readLine().split(","));
				}
				fr.close();
				return registro;
			}
		}else{
			BufferedReader fr=null;
			ArrayList<String[]> registro=new ArrayList<String[]>();
			for (int i = 1;i<=numeroRegistros; i++) {
				fr=new BufferedReader(new FileReader("./Tabla/R"+i+".txt"));
				String[] A=fr.readLine().split(",");
				if(A[campo].equals(llave)){
					registro.add(A);
				}
			}
			fr.close();
			if(registro.size()==0){
				return null;
			}else{
				return registro;
			}
		}
	}
}