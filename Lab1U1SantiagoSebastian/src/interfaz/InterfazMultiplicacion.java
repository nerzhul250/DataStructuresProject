package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import algoritmo.Fibonacci;
import algoritmo.Karatsuba;
import algoritmo.Toom_Cook;

public class InterfazMultiplicacion extends JFrame{
	
	private Karatsuba mundo;
	private Toom_Cook toom;
	private Fibonacci fibo;
	private PanelVisualizacion pv;
	private PanelOpcion po;
	
	public InterfazMultiplicacion(){
		setTitle("MultiPliDynamic");
		setLayout(new BorderLayout());
		
		mundo=new Karatsuba();
		toom=new Toom_Cook();
		fibo = new Fibonacci();
		po=new PanelOpcion(this);
		pv=new PanelVisualizacion();
		
		
		JScrollPane scroll=new JScrollPane(pv);
		scroll.setPreferredSize(new Dimension(1150,600));
		
		add(scroll,BorderLayout.NORTH);
		add(po,BorderLayout.SOUTH);
		pack();
	}
	
	public static void main(String[] args) {
		InterfazMultiplicacion mg=new InterfazMultiplicacion();
		mg.setVisible(true);
		mg.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void multiplicarToom(String num1,String num2) {
		try{
			Toom_Cook.Toom(num1, num2);
			ArrayList<String>pro=toom.getProcedimiento();
			pv.setTexty(pro);
			pv.repaint();
			toom.setProcedimiento(new ArrayList<String>());;
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Toom: Parece ser, que eres, un usuario ma�oso\n"
					+ "espero que no pruebes este algoritmo con numeritos");
		}
	}
	public void multiplicarConKaratsuba(String num1, String num2) {
		try{
			mundo.karatsuba(num1, num2);
			ArrayList<String>pro=mundo.getProcedimiento();
			pv.setTexty(pro);
			pv.repaint();
			mundo.setProcedimiento(new ArrayList<String>());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Karatsuba: Parece ser, que eres, un usuario ma�oso\n"
					+ "�No quieres ver como parto en dos mis numeros?");
		}
	}

	public void multiplicarFibo(String text, String text2) {
		try{
			fibo.multiplicacion(text, text2);
			ArrayList<String>pro=fibo.getProcedimiento();
			pv.setTexty(pro);
			pv.repaint();
			fibo.setProcedimiento(new ArrayList<String>());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Parece ser, que eres un usuario ma�oso\n"
					+ "Ya ver�s por qu� soy tan ineficiente, pero sencillo");
		}
	}

}
