import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver {

	public static void main(String[] args) {
		
/*		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = MainUIFrame.getInstance();

				frame.setSize(750, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});*/
		
		// Test Observer pattern
		
		// Create the Subject and Observers
		User user1 = new User("SubjectUser1");
		User user2 = new User("SubjectUser2");
		User user3 = new User("ObserverUser1");
		User user4 = new User("ObserverUser2");
		
		// Attach user3 and user4 as observer of user1
		user1.attach(user3);
		user1.attach(user4);
		user2.attach(user3);
		
		// Have user1 post a tweet
		user1.postMessage("LEAVE BRITNEY ALONE!!!");
		user2.postMessage("MAKE ME!!");
		user1.postMessage("Fuck u");
		user1.postMessage("Fuck u2");

		System.out.println(user1.observers.toString());
		
		System.out.println("User 1 news feed\n" + user1.getFeed());
		System.out.println("User 2 news feed\n" + user2.getFeed());
		System.out.println("User 3 news feed\n" + user3.getFeed());
		System.out.println("User 4 news feed\n" + user4.getFeed());	

	}

}
