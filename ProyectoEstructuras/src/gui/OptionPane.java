package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import world.Domain;

public class OptionPane extends JPanel implements ActionListener{
	
	public final static String GOTODOMAIN="GOTODOMAIN";
	public final static String FINDREDUNDANCIES="REDUNDANCIES";
	public final static String EXPANDGRAPH="EXPANDGRAPH";
	public final static String CHANGEIMPLEMENTATION="CHANGEIMPLEMENTATION";
	public final static String UPDATE="UPDATE";
	
	private JList<Domain> domainList;
	private DefaultListModel<Domain> modelDomain;
	
	private JComboBox<Domain> comboDomain;
	private  DefaultComboBoxModel<Domain> comboModel;
	
	private JComboBox<Integer> comboDepth;
	
	private JButton butUpdateDomainList;
	private WebGUI gui;
	public OptionPane(WebGUI wb) {
		gui=wb;
		
		setLayout(new GridLayout(6,1));
		
		modelDomain = new DefaultListModel<Domain>();
		domainList = new JList<Domain>(modelDomain);
		
		JScrollPane scroll = new JScrollPane(domainList);
		scroll.setBackground(Color.WHITE);
		
		add(scroll);
		
		butUpdateDomainList=new JButton("Update Domain List");
		butUpdateDomainList.addActionListener(this);
		butUpdateDomainList.setActionCommand(UPDATE);
		
		add(butUpdateDomainList);
		
		JPanel auxPane=new JPanel();
		auxPane.setBorder(new TitledBorder("Find shortest path to domain"));
		auxPane.setLayout(new GridLayout(2,1));
		comboModel=new DefaultComboBoxModel<Domain>();
		comboDomain=new JComboBox<Domain>(comboModel);
		JButton but1=new JButton("Go to domain!");
		but1.addActionListener(this);
		but1.setActionCommand(GOTODOMAIN);
		auxPane.add(comboDomain);
		auxPane.add(but1);
		
		add(auxPane);
		
		auxPane=new JPanel();
		auxPane.setBorder(new TitledBorder("Find Cycles of Domain"));
		auxPane.setLayout(new GridLayout(1,1));
		but1=new JButton("Find Cycles!");
		but1.addActionListener(this);
		but1.setActionCommand(FINDREDUNDANCIES);
		auxPane.add(but1);
		
		add(auxPane);
		
		auxPane=new JPanel();
		auxPane.setBorder(new TitledBorder("Expand Graph"));
		auxPane.setLayout(new GridLayout(0,2));
		but1=new JButton("Expand Graph");
		but1.addActionListener(this);
		but1.setActionCommand(EXPANDGRAPH);
		Integer[] objs= {1,2,3,4,5,6,7,8,9,10};
		comboDepth=new JComboBox<Integer>(objs);
		auxPane.add(new JLabel("Exploration Depth"));
		auxPane.add(comboDepth);
		auxPane.add(but1);

		add(auxPane);
		
		auxPane=new JPanel();
		auxPane.setBorder(new TitledBorder("Change Graph implementation"));
		but1=new JButton("Change");
		but1.addActionListener(this);
		but1.setActionCommand(CHANGEIMPLEMENTATION);
		auxPane.add(but1);
		
		add(auxPane);
		
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200,0);
	}
	public void refreshDomainList(ArrayList<Domain>domains) {
		Collections.sort(domains);
		modelDomain.removeAllElements();
		comboModel=new DefaultComboBoxModel<Domain>();
		for (int i = 0; i <domains.size(); i++) {
			modelDomain.addElement(domains.get(i));
			comboModel.addElement(domains.get(i));
		}
		comboDomain.setModel(comboModel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals(CHANGEIMPLEMENTATION)) {
			gui.changeGraphImplementation();
		}else if(command.equals(UPDATE)) {
			gui.updateList();
		} else if(!domainList.isSelectionEmpty()) {
			if(command.equals(GOTODOMAIN)) {
				Domain d1=domainList.getSelectedValue();
				Domain d2=(Domain)comboDomain.getSelectedItem();
				if(!d1.toString().equals(d2.toString())) {
					gui.findShortestPath(d1,d2);									
				}else {
					JOptionPane.showMessageDialog(gui,"destination and origin should be different");			
				}
			}else if(command.equals(FINDREDUNDANCIES)) {
				gui.findCycles(domainList.getSelectedValue());
			}else if(command.equals(EXPANDGRAPH)) {
				gui.expandGraph(domainList.getSelectedValue(),(int)comboDepth.getSelectedItem());
			}
		}else {
			JOptionPane.showMessageDialog(gui,"Select a starting domain");			
		}
	}
}
