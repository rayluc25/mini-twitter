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
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class MainUIFrame extends JFrame implements TreeSelectionListener{
	// Uses Singleton design pattern
	
	private static MainUIFrame mainUiInstance = null;
	
	public static MainUIFrame getInstance() {
		synchronized(MainUIFrame.class) {
			if (mainUiInstance == null) {
				mainUiInstance = new MainUIFrame();
			}
		}
		return mainUiInstance;
	}
	
	private MainUIFrame() {
		
		// Set layout manager
		setLayout(new GridBagLayout());
		Container pane = getContentPane();
		
		//Create tree component to represent users and user groups
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		JTree tree = new JTree(root);
		
		// Allow one selection at a time in the tree
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(this);

		// Create other Swing components
		JScrollPane treeView = new JScrollPane(tree);
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
		
		// Add behaviors
		
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
