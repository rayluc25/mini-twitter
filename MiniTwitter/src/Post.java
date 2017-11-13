import java.util.HashSet;
import java.util.Set;

public class Post {
	
	private static Set<Post> allPosts = new HashSet<Post>();
	private String message;
	private User user;
	
	public Post(String message, User user) {
		this.message = message;
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return user.getId() + " says: " + message;
	}
	
	public void accept(Visitor vis) {
		vis.atPost(this);
	}
	
	public static void addToAllPosts(Post p) {
		allPosts.add(p);
	}
	
	public static Set<Post> getAllPosts() {
		return allPosts;
	}

}
