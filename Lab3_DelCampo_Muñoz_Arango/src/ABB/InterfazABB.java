package ABB;

public interface InterfazABB <K extends Comparable, V> {

	void agregar(K key, V value);
	V buscar(K key);
	boolean eliminar (K key);
}
