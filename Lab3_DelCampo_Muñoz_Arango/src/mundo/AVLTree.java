package mundo;

public class AVLTree<K extends Comparable,V> extends ABB<K,V> {
	private AVLNode<K,V> raiz;
	
	@Override
	public void insertar(K key, V value) {
		AVLNode<K,V> z=new AVLNode<K,V>(key,value);
		insertar(z,null);
		insertarFixeUp(z);
	}
	@Override
	public boolean eliminar(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	private void insertarFixeUp(AVLNode<K, V> z) {
		AVLNode<K,V> N=z;
		AVLNode<K,V> P=(AVLNode<K, V>) z.getPadre();
		while(P!=null){
			 // P.balanceFactor() has not yet been updated!
			 if (N == P.getIzquierdo()) { // the left subtree increases
			 if (P.balanceFactor() == 1) { // The left column in the picture
			 // ==> the temporary P.balanceFactor() == 2 ==> rebalancing is required.
			 if (N.balanceFactor() == -1) { // Left Right Case
			 leftRotate(N,null); // Reduce to Left Left Case
			 }
			 // Left Left Case
			 rightRotate(P,null);
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
			 rightRotate(N,null); // Reduce to Right Right Case
			 }
			 // Right Right Case
			 leftRotate(P,null);
			 break; // Leave the loop
			 }
			 if (P.balanceFactor() == 1) {
			 P.setBalanceFactor(0); // N’s height increase is absorbed at P.
			 break; // Leave the loop
			 }
			 P.setBalanceFactor(-1); // Height increases at P
			 }
			 N = P;
			 P = (AVLNode<K, V>) N.getPadre();
		}
	}
}
