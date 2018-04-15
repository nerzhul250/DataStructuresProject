package mundo;

enum Color{
	BLACK,RED
}
public class RBTNode<K extends Comparable,V> extends NodoABB {
	
	private Color color;
	public RBTNode(K llave, V valor){
		super(llave,valor);
		color=Color.RED;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}