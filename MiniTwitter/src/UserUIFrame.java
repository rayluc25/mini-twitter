import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UserUIFrame extends JFrame {

	public UserUIFrame(User currentUser) {
		// Set UserUI attributes
		this.setSize(750, 600);
		this.setVisible(true);

		// Set layout manager
		setLayout(new GridBagLayout());
		Container pane = getContentPane();
		
		// Create the swing components
		JTextArea userIdArea = new JTextArea("User ID", 1, 15);
		JButton followButton = new JButton("Follow User");
		JLabel currentlyFollowingLabel = new JLabel("Currently following:");
		
		DefaultListModel listModel = new DefaultListModel();
		List<String> followingList = currentUser.getFollowingList();
		String[] followingArray = followingList.toArray(new String[followingList.size()]);
		JList followingJList = new JList(listModel);
		for (String id : followingArray) {
			listModel.addElement(id);
		}
		//JList followingJList = new JList<String>(followingArray);
		followingJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		JScrollPane followingPane = new JScrollPane(followingJList);
		
		JTextArea tweetArea = new JTextArea("Tweet a message!", 1, 15);
		JButton postButton = new JButton("Post tweet");
		JLabel newsFeedLabel = new JLabel("Your feed:");
		
		DefaultListModel feedModel = new DefaultListModel();
		
		Vector<Post> newsFeedVector = currentUser.getFeedVector();
		JList newsFeedJList = new JList(feedModel);
		for (Post post : newsFeedVector) {
			feedModel.addElement(post);
		}
		newsFeedJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		JScrollPane newsFeedPane = new JScrollPane(newsFeedJList);
		
		
		// Set constraints and add components to content pane
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 0;
		pane.add(userIdArea, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 0;
		pane.add(followButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 1;
		pane.add(currentlyFollowingLabel, cons);
		
		GridBagConstraints listCons = new GridBagConstraints();
		listCons.fill = GridBagConstraints.HORIZONTAL;
		listCons.gridx = 0;
		listCons.gridy = 2;
		listCons.gridwidth = 2;
		followingPane.setPreferredSize(new Dimension(300, 100));
		pane.add(followingPane, listCons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 3;
		pane.add(tweetArea, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 1;
		cons.gridy = 3;
		pane.add(postButton, cons);
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 4;
		pane.add(newsFeedLabel, cons);
		
		GridBagConstraints feedCons = new GridBagConstraints();
		feedCons.fill = GridBagConstraints.HORIZONTAL;
		feedCons.gridx = 0;
		feedCons.gridy = 5;
		feedCons.gridwidth = 2;
		newsFeedPane.setPreferredSize(new Dimension(300, 200));
		pane.add(newsFeedPane, feedCons);
		
		// Add behaviors
		// followButton should have the current user follow the user given in userIdArea
		followButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				followButtonPressed();
			}
			
			private void followButtonPressed() {
				// If the userId exists, follow the user with attach method
				if (User.getAllUsers().containsKey(userIdArea.getText())) {
					User userToFollow = User.getAllUsers().get(userIdArea.getText());
					// Don't follow multiple times
					if (userToFollow.observers.contains(currentUser)) {
						return;
					}
					userToFollow.attach(currentUser);
					listModel.addElement(userToFollow);
				}
			}
		});
		
		// postButton should post a tweet for the current user
		postButton.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				postButtonPressed();
			}
			
			private void postButtonPressed() {
				String msg = tweetArea.getText();
				currentUser.postMessage(msg);
				}
		});
	}

}
