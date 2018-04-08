package mundo;

public interface InterfazABB <K extends Comparable<K>, V> {

	public void insertar(K key, V value);
	public boolean eliminar (K key);
}
