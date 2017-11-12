import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class User extends Subject implements UserComponent, Observer {
	
	private boolean isGroup = false;
	private boolean isUser = true;
	// So users cannot share the same id
	private static Map<String, User> allUsers = new HashMap<String, User>();
	private String id;
	// A list of the user's own posts and posts of those in following
	private Vector<Post> newsFeed = new Vector<>();
	// A list of people who are following this User
	private List<String> followers = new ArrayList<>();
	// A list of Users that this User is following
	private List<String> following = new ArrayList<>();
	
	// Static factory method to ensure unique userIds
	public static User createUser(String id) {
		// Check if allUsers already has a User with given id
		if (allUsers.containsKey(id)) {
			return null;
		}
		// If userId not used yet, create the User, add user to allUsers
		User newUser = new User(id);
		allUsers.put(id,  newUser);
		return newUser;
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
		newsFeed.add(post);
		notifyObservers(post);
	}
	
	// This code makes User an Observer from the Observer pattern
	public void update(Post post) {
		newsFeed.add(post);
	}
	
	public String getFeed() {
		String string = "";
		
		for (Post post : newsFeed) {
			string += post.toString() + "\n";
		}
		
		return string;
	}

	// This code makes User a Component in Composite Design Pattern
	
	@Override
	public void expand() {
		// Generate the User View UI
		
	}

	@Override
	public void follow(Subject sub) {
		following.add(sub.getId());
	}
	
	public List<String> getFollowingList(){
		return following;
	}
	
	public Vector<Post> getFeedVector() {
		return newsFeed;
	}
	
	public static HashMap<String, User> getAllUsers() {
		return (HashMap<String, User>) allUsers;
	}
}
