package world;

public class Edge<V, E> {

	private E label;
	private Vertex<V, E> origin;
	private Vertex<V, E> ending;

	/**
	 * 
	 * @param e
	 * @param v1
	 * @param v2
	 */
	public Edge(E e, Vertex<V,E> v1, Vertex<V,E> v2) {
		label=e;
		origin=v1;
		ending=v2;
	}

	public E getLabel() {
		return label;
	}

	public void setLabel(E label) {
		this.label = label;
	}

	public Vertex<V, E> getOrigin() {
		return origin;
	}

	public void setOrigin(Vertex<V, E> origin) {
		this.origin = origin;
	}

	public Vertex<V, E> getEnding() {
		return ending;
	}

	public void setEnding(Vertex<V, E> ending) {
		this.ending = ending;
	}

}