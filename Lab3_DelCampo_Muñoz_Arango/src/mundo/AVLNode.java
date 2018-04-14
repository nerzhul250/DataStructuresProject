package mundo;

public class AVLNode<K,V> extends NodoABB {
	
	private int balanceFactor;
	
	public AVLNode(K llave, V valor){
		super((Comparable) llave,valor);
	}
	public int balanceFactor() {
		return balanceFactor;
	}
	public void setBalanceFactor(int t){
		balanceFactor=t;
	}

}
