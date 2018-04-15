package mundo;

public class AVLNode<K,V> extends NodoABB {
	
	private int balanceFactor;
	
	public AVLNode(K llave, V valor){
		super((Comparable) llave,valor);
		balanceFactor=0;
	}
	public int balanceFactor() {
		if(derecho==null && izquierdo==null) {
			
		}
		return balanceFactor;
	}
	public void setBalanceFactor(int t){
		balanceFactor=t;
	}
	public void actualizarFactorBalance() {
		if(derecho==null && izquierdo==null) {
			balanceFactor=0;
		}else if(derecho==null) {
			balanceFactor=izquierdo.altura;
		}else if(izquierdo==null) {
			balanceFactor=-derecho.altura;
		}else {
			balanceFactor=izquierdo.altura-derecho.altura;
		}
	}

}
