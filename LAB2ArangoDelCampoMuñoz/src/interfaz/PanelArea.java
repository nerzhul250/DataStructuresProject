package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelArea extends JPanel implements ActionListener{
	private JTextArea a;
	private JButton b;
	private InterfazParqueadero in;
	public PanelArea(InterfazParqueadero i) {
		in=i;
		setLayout(new BorderLayout());
		a=new JTextArea("HI\nFucker");
		b=new JButton("ClickMe");
		b.addActionListener(this);
		b.setActionCommand("FUCK");
		add(new JScrollPane(a),BorderLayout.CENTER);
		add(b,BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		in.sendInfo(a.getText());
	}
}
