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
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
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
	
	// Create tree component to represent users and user groups
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
	DefaultTreeModel treeModel = new DefaultTreeModel(root);
	JTree tree = new JTree(treeModel);
	DefaultMutableTreeNode selected;
	
	private MainUIFrame() {
		// Set layout manager
		setLayout(new GridBagLayout());
		Container pane = getContentPane();
		
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
		treeView.setPreferredSize(new Dimension(200, 200));
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
		// addUserButton should add a new user with userIdArea input as id
		// and set the currently selected node as the parent
		addUserButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addUserButtonPressed();
			}

			private void addUserButtonPressed() {
				// If selected node is not a UserGroup or Root, cannot add User
				UserComponent object = null;
				if (!selected.isRoot()) {
					object = (UserComponent) selected.getUserObject();
				}
				if (object instanceof User) {
					return;
				}
				// Create the user
				User newUser = User.createUser(userIdArea.getText());
				// If null, id in use, do not add user
				if(newUser == null) {
					return;
				}
				// Create new node with newUser as object
				DefaultMutableTreeNode newUserNode = new DefaultMutableTreeNode(newUser);
				// Add the new user as child of selected node
				treeModel.insertNodeInto(newUserNode, selected, selected.getChildCount());
			}
		});
		
		// addGroupButton should add a new UserGroup with groupIdArea input as id
		// and set currently selected node as the parent
		addGroupButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addGroupButtonPressed();
			}
			
			private void addGroupButtonPressed() {
				// If selected node is User, cannot add children
				if (selected.getUserObject() instanceof User) {
					return;
				}
				// Create the userGroup
				UserGroup newUserGroup = UserGroup.createUserGroup(groupIdArea.getText());
				// If null, id in use, do not add UserGroup
				if (newUserGroup == null) {
					return;
				}
				// Create new node with newUserGroup as object
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newUserGroup);
				// Add the new user as child of selected node
				treeModel.insertNodeInto(newNode, selected, selected.getChildCount());
			}
		});
	}

	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// When a user selects a new user or group in the tree, hold that node
		TreePath tp = e.getNewLeadSelectionPath();  
	    if (tp != null) {
	    		selected = (DefaultMutableTreeNode) tp.getLastPathComponent(); 
	    }
	}
}
