package tablasHash;

public interface ITablaHash<K,V> {
	
	public boolean isEmpty();
	public boolean insert(K llave, V valor);
	public V find(K llave);
	public V delete(K llave);
	public int hash(K llave);
}	
