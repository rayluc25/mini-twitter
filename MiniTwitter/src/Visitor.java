
public interface Visitor {
	
	void atUser(User u);
	void atUserGroup(UserGroup u);
	void atPost(Post p);
	
}
