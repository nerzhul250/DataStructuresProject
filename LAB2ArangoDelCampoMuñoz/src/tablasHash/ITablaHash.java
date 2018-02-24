package tablasHash;

public interface ITablaHash<K,V> {
	
	public boolean estaVacio();
	public boolean insertar(K llave, V valor);
	public V buscar(K llave);
	public V eliminar(K llave);
	public int hash(K llave);
}	
