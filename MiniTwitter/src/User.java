import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User extends Subject implements UserComponent, Observer {
	
	private boolean isGroup = false;
	private boolean isUser = true;
	// So users cannot share the same id
	private static Set<String> allUsers = new HashSet<String>();
	private String id;
	// A list of the user's own posts
	private List<Post> newsfeed = new ArrayList<>();
	// A list of following's posts
	private List<String> followers = new ArrayList<>();
	private List<String> following = new ArrayList<>();
	
	// Static factory method to ensure unique userIds
	public static User createUser(String id) {
		// Check if allUsers already has a User with given id
		if (allUsers.contains(id)) {
			return null;
		}
		// If userId not used yet, create the User, add id to allUsers
		allUsers.add(id);
		return new User(id);
	}
	
	private User(String id) {
		this.id = id;
	}
	
	// So JTree displays userId instead of address space
	@Override
	public String toString() {
		return this.id;
	}
	
	// This code makes User a Subject from Observer pattern
	
	public String getId() {
		return id;
	}
	
	public void postMessage(String msg) {
		Post post = new Post(msg, this);
		System.out.println(id + " posted: " + msg);
		newsfeed.add(post);
		notifyObservers(post);
	}
	
	// This code makes User an Observer from the Observer pattern
	public void update(Post post) {
		newsfeed.add(post);
	}
	
	public String getFeed() {
		String string = "";
		
		for (Post post : newsfeed) {
			string += post.toString() + "\n";
		}
		
		return string;
	}

	// This code makes User a Component in Composite Design Pattern
	
	@Override
	public void expand() {
		// Generate the User View UI
		
	}

	// 
	@Override
	public void follow(Subject sub) {
		// TODO Auto-generated method stub
		following.add(sub.getId());
	}
}
