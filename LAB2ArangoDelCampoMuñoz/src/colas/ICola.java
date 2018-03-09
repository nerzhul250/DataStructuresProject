package colas;


public interface ICola<T> {
	public T deQueue();
	public boolean queue(T t);
	public boolean isEmpty();
	public T front();
}
