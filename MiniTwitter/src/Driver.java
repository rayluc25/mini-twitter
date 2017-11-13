import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = MainUIFrame.getInstance();
			}
		});
		
/*		// Test Observer pattern
		
		// Create the Subject and Observers
		User user1 = User.createUser("SubjectUser1");
		User user2 = User.createUser("SubjectUser2");
		User user3 = User.createUser("ObserverUser1");
		User user4 = User.createUser("ObserverUser2");
		
		// Attach user3 and user4 as observer of user1
		// Attach user3 as observer of user2
		user1.attach(user3);
		user1.attach(user4);
		user2.attach(user3);
		
		// Have user1 post a tweet
		user1.postMessage("LEAVE BRITNEY ALONE!!!");
		user2.postMessage("MAKE ME!!");
		user1.postMessage("F*** u");
		user1.postMessage("F*** u2");
		
		// Each user's feed should contain own posts and posts of followings, it works
		System.out.println("User 1 news feed\n" + user1.getFeed());
		System.out.println("User 2 news feed\n" + user2.getFeed());
		System.out.println("User 3 news feed\n" + user3.getFeed());
		System.out.println("User 4 news feed\n" + user4.getFeed());	
*/
	}

}
