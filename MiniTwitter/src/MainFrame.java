import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		
		// Set layout manager
		setLayout(new GridBagLayout());
		Container pane = getContentPane();

		// Create Swing components
		JScrollPane treeView = new JScrollPane();
		JTextArea userIdArea = new JTextArea();
		JTextArea groupIdArea = new JTextArea();
		JButton addUserButton = new JButton("Add User");
		JButton addGroupButton = new JButton("Add Group");
		JButton userViewButton = new JButton("Open User View");
		JButton userTotalButton = new JButton("Show User Total");
		JButton groupTotalButton = new JButton("Show Group Total");
		JButton messagesTotalButton = new JButton("Show Messages Total");
		JButton showPositiveButton = new JButton("Show Positive Percentage");
		
		// Set constraints and add components to content pane
		GridBagConstraints treeCons = new GridBagConstraints();
		treeCons.fill = GridBagConstraints.VERTICAL;
		treeCons.gridx = 0;
		treeCons.gridy = 0;
		treeCons.gridheight = 7;
		treeView.setPreferredSize(new Dimension(100, 100));
		pane.add(treeView, treeCons);
		
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 0;
		pane.add(userIdArea, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 2;
		cons.gridy = 0;
		pane.add(addUserButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 1;
		pane.add(groupIdArea, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 2;
		cons.gridy = 1;
		pane.add(addGroupButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 2;
		pane.add(userViewButton, cons);

		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 5;
		pane.add(userTotalButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 2;
		cons.gridy = 5;
		pane.add(groupTotalButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 6;
		pane.add(messagesTotalButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 2;
		cons.gridy = 6;
		pane.add(showPositiveButton, cons);
		
		// Add behavior
		
	}
}
