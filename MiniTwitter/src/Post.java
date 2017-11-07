
public class Post {
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
}
