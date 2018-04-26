package mundo;

public interface InterfazABB <K extends Comparable, V> {

	public void insertar(K key, V value);
	public NodoABB<K,V>eliminar (K key);
}
