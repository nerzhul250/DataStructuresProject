package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelVisualizacion extends JPanel{
	private String texty;
	public PanelVisualizacion() {
		setPreferredSize(new Dimension(4000,4000));
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0,0,getWidth(),getHeight());
		g2d.setColor(Color.BLACK);
		g2d.drawRect(1,1,getWidth()-4,getHeight()-4);
	}
}
