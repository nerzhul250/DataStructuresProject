package auxiliarDataStructures;

public class Pair<K,V> {
	private K key;
	private V value;
	
	public Pair(K k,V v) {
		key=k;
		value=v;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return (key.hashCode()+value.hashCode())%Integer.MAX_VALUE;
	}
	@Override
	public boolean equals(Object obj) {
		Pair<K,V> p=(Pair<K,V>)obj;
		if((key.equals(p.key)&&value.equals(p.value)) || (key.equals(p.value)&&value.equals(p.key))) {
			return true;
		}
		return false;
	}
	
}
