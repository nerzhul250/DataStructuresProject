package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelVisualizacion extends JPanel{
	private ArrayList<String> texty;
	int height=4000;
	public PanelVisualizacion() {
		texty=new ArrayList<String>();
		setPreferredSize(new Dimension(1000,height));
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0,0,getWidth(),getHeight());
		g2d.setColor(Color.BLACK);
		g2d.drawRect(1,1,getWidth()-4,getHeight()-4);
		int x=25;
		int y=25;
		Font f = new Font("Comic Sans MS", Font.BOLD,16);
		Font f2=new Font("Comic Sans MS", Font.PLAIN,12);
		for (int i=texty.size()-1; i >= 0; i--) {
		     g2d.setFont(f);
			for (String line : texty.get(i).split("\n")){
		        g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());
		        g2d.setFont(f2);
			}
			y+=10;
		}
		if(y>=height){
			height+=50;
			setPreferredSize(new Dimension(4000,height));
		}
	}
	public ArrayList<String> getTexty() {
		return texty;
	}
	public void setTexty(ArrayList<String> texty) {
		this.texty = texty;
	}
}
