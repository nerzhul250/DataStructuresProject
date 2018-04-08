package mundo;

public class AVLTree<K extends Comparable<K>,V> implements InterfazABB<K, V> {
	private AVLNode<K,V> raiz;
	
	@Override
	public void insertar(K key, V value) {
		insertar(new AVLNode<K,V>(key,value));
	}
	private void insertar(AVLNode<K,V> z) {
		AVLNode<K,V> y=null;
		AVLNode<K,V> x=raiz;
		while(x!=null){
			y=x;
			if(x.compareTo(z)>0){
				x=x.getIzquierdo();
			}else if(x.compareTo(z)<0){
				x=x.getDerecho();
			}else{
				AVLNode<K,V> w=x.getClon();
				while(w!=null){
					x=w;
					w=w.getClon();
				}
				x.setClon(z);
				return;
			}
		}
		z.setPadre(y);
		if(y==null){
			raiz=z;
		}else if(y.compareTo(z)>0){
			y.setIzquierdo(z);
		}else{y.setDerecho(z);}
		insertarFixeUp(z);
	}
	public AVLNode<K,V> consultar(K llave) {
		AVLNode<K,V> y=null;
		AVLNode<K,V> x=raiz;
		while(x!=null){
			y=x;
			if(x.getKey().compareTo(llave)>0){
				x=x.getIzquierdo();
			}else if(x.getKey().compareTo(llave)<0){
				x=x.getDerecho();
			}else{
				return x;
			}
		}
		return null;
	}
	@Override
	public boolean eliminar(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	private void insertarFixeUp(AVLNode<K, V> z) {
		AVLNode<K,V> N=z;
		AVLNode<K,V> P=z.getPadre();
		while(P!=null){
			 // P.balanceFactor() has not yet been updated!
			 if (N == P.getIzquierdo()) { // the left subtree increases
			 if (P.balanceFactor() == 1) { // The left column in the picture
			 // ==> the temporary P.balanceFactor() == 2 ==> rebalancing is required.
			 if (N.balanceFactor() == -1) { // Left Right Case
			 leftRotate(N); // Reduce to Left Left Case
			 }
			 // Left Left Case
			 rightRotate(P);
			 break; // Leave the loop
			 }
			 if (P.balanceFactor() == -1) {
			 P.setBalanceFactor(0); // N’s height increase is absorbed at P.
			 break; // Leave the loop
			 }
			 P.setBalanceFactor(1); // Height increases at P
			 } else { // N == right_child(P), the child whose height increases by 1.
			 if (P.balanceFactor() == -1) { // The right column in the picture
			 // ==> the temporary P.balanceFactor() == -2 ==> rebalancing is required.
			 if (N.balanceFactor() == 1) { // Right Left Case
			 rightRotate(N); // Reduce to Right Right Case
			 }
			 // Right Right Case
			 leftRotate(P);
			 break; // Leave the loop
			 }
			 if (P.balanceFactor() == 1) {
			 P.setBalanceFactor(0); // N’s height increase is absorbed at P.
			 break; // Leave the loop
			 }
			 P.setBalanceFactor(-1); // Height increases at P
			 }
			 N = P;
			 P = N.getPadre();
		}
	}
	private void leftRotate(AVLNode<K, V> x){
		AVLNode<K, V> y=x.getDerecho();
		x.setDerecho(y.getIzquierdo());
		if(y.getIzquierdo()!=null){
			y.getIzquierdo().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if(x.getPadre()==null){
			raiz=y;
		}else if(x==x.getPadre().getIzquierdo()){
			x.getPadre().setIzquierdo(y);
		}else{
			x.getPadre().setDerecho(y);
		}
		y.setIzquierdo(x);
		x.setPadre(y);
	}
	private void rightRotate(AVLNode<K, V> x){
		AVLNode<K, V> y=x.getIzquierdo();
		x.setIzquierdo(y.getDerecho());
		if(y.getDerecho()!=null){
			y.getDerecho().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if(x.getPadre()==null){
			raiz=y;
		}else if(x==x.getPadre().getIzquierdo()){
			x.getPadre().setIzquierdo(y);
		}else{
			x.getPadre().setDerecho(y);
		}
		y.setDerecho(x);
		x.setPadre(y);
	}
}
