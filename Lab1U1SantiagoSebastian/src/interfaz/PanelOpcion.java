package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpcion extends JPanel implements ActionListener{
	
	private JButton option1;
	private JButton option2;
	private JButton option3;
	
	public PanelOpcion(){
		setLayout(new GridLayout(1,3));
		
		option1=new JButton("Karatsuba");
		option1.addActionListener(this);
		option2=new JButton("Toom Cook");
		option2.addActionListener(this);
		option3=new JButton("Algorithm 3");
		option3.addActionListener(this);

		add(option1);
		add(option2);
		add(option3);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
