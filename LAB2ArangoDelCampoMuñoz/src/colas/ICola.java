package colas;


public interface ICola<T> {
	public T unQueue();
	public boolean queue(T t);
	public boolean isEmpty();
	public T front();
}
