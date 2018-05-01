package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import world.Domain;

public class OptionPane extends JPanel implements MouseListener, ActionListener{
	
	public final static String GOTODOMAIN="GOTODOMAIN";
	public final static String FINDREDUNDANCIES="REDUNDANCIES";
	
	private JList<Domain> domainList;
	private DefaultListModel<Domain> modelDomain;
	
	private JTextField destineDomain;
	
	private WebGUI gui;
	public OptionPane(WebGUI wb) {
		gui=wb;
		
		setLayout(new GridLayout(3,1));
		
		modelDomain = new DefaultListModel<Domain>();
		domainList = new JList<Domain>(modelDomain);
		domainList.addMouseListener(this);

		JScrollPane scroll = new JScrollPane(domainList);
		scroll.setBackground(Color.WHITE);
		scroll.setPreferredSize(new Dimension(200,0));
		
		add(scroll);
		
		JPanel auxPane=new JPanel();
		auxPane.setBorder(new TitledBorder("Find shortest path to domain"));
		auxPane.setLayout(new GridLayout(1,2));
		destineDomain=new JTextField("Insert destine here");
		JButton but1=new JButton("GO!");
		but1.addActionListener(this);
		but1.setActionCommand(GOTODOMAIN);
		auxPane.add(destineDomain);
		auxPane.add(but1);
		
		add(auxPane);
		
		auxPane=new JPanel();
		auxPane.setBorder(new TitledBorder("Find Cycles of Domain"));
		auxPane.setLayout(new GridLayout(1,1));
		but1=new JButton("GO!");
		but1.addActionListener(this);
		but1.setActionCommand(FINDREDUNDANCIES);
		auxPane.add(but1);
		
		add(auxPane);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1){
			if(!domainList.isSelectionEmpty()){
				gui.refreshGraph(domainList.getSelectedValue());
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals(GOTODOMAIN)) {
			gui.findShortestPath(domainList.getSelectedValue(),destineDomain.getText());
		}else {
			gui.findCycles(domainList.getSelectedValue());
		}
	}
}
