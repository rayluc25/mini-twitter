import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class User extends Subject implements UserComponent, Observer {
	private IUpdateListener updateListener;
	
	private long creationTime;
	private long lastUpdateTime;
	private boolean isGroup = false;
	private boolean isUser = true;
	// So users cannot share the same id
	private static Map<String, User> allUsers = new HashMap<String, User>();
	private String id;
	// A list of both the user's own posts and posts of those user is following
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
		newUser.creationTime = System.currentTimeMillis();
		newUser.lastUpdateTime = newUser.creationTime;
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
	
	public long getCreationTime() {
		return creationTime;
	}
	
	public long getUpdateTime() {
		return lastUpdateTime;
	}
	
	public void setUpdateTime(long t) {
		this.lastUpdateTime = t;
	}
	
	public void postMessage(String msg) {
		Post post = new Post(msg, this);
		newsFeed.add(post);
		notifyObservers(post);
	}
	
	// This code makes User an Observer from the Observer pattern
	public void update(Post post) {
		lastUpdateTime = System.currentTimeMillis();
		newsFeed.add(post);
		// add to list model
		if (updateListener != null) {
			updateListener.feedUpdated(post);
		}
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
		UserUIFrame userView = new UserUIFrame(this);
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
	
	public void addUpdateListener(IUpdateListener listener) {
		updateListener = listener;
	}
	
	public void accept(Visitor vis) {
		vis.atUser(this);
	}
}
