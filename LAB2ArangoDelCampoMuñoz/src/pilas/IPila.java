package pilas;

public interface IPila<T> {
	public T pop() throws PilaVaciaException;
	public boolean push(T t);
	public boolean isEmpty();
	public T top();
}
