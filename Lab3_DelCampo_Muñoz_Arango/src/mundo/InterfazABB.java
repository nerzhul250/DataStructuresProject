package mundo;

public interface InterfazABB <K extends Comparable, V> {

	public void insertar(K key, V value);
	public NodoABB eliminar (K key);
}
