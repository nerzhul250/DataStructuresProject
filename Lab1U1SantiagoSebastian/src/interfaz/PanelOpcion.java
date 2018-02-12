package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelOpcion extends JPanel implements ActionListener{
	
	private static final String FIBO = "Fibo";
	
	private JButton option1;
	private JButton option2;
	private JButton option3;
	
	private JTextField num1;
	private JTextField num2;
	
	private InterfazMultiplicacion im;
	
	public PanelOpcion(InterfazMultiplicacion im){
		
		this.im=im;
		
		setLayout(new GridLayout(2,3));
		
		option1=new JButton("Karatsuba");
		option1.addActionListener(this);
		option1.setActionCommand("KARA");
		option2=new JButton("Toom Cook");
		option2.addActionListener(this);
		option2.setActionCommand("Toom3");
		option3=new JButton("Fibonacci");
		option3.addActionListener(this);
		option3.setActionCommand(FIBO);
		
		num1=new JTextField();
		num2=new JTextField();
		
		add(option1);
		add(option2);
		add(option3);
		add(num1);
		add(num2);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("KARA")){
			im.multiplicarConKaratsuba(num1.getText(),num2.getText());
		}
		if(e.getActionCommand().equals("Toom3")) {
			im.multiplicarToom(num1.getText(),num2.getText());
		}
		if(e.getActionCommand().equals(FIBO)) {
			im.multiplicarFibo(num1.getText(),num2.getText());
		}
	}
}
