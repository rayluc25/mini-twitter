import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver {
	
	// In order to add a new User or a UserGroup, you must first select an element from the list view
	// to be the parent of the new User or UserGroup. A post is considered positive if it containst he word
	// "good."

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = MainUIFrame.getInstance();
			}
		});
	}

}
