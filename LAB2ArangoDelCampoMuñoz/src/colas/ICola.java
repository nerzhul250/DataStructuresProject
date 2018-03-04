package colas;


public interface ICola<T> {
	public T unQueue() throws ColaVaciaException;
	public boolean queue(T t);
	public boolean isEmpty();
	public T front();
}
