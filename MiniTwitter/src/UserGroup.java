import java.util.HashSet;
import java.util.Set;

public class UserGroup implements UserComponent {
	// UserGroup is the composite container in this Composite design pattern
	
	private static Set<UserGroup> allGroups = new HashSet<UserGroup>();
	private boolean isGroup = true;
	private boolean isUser = false;
	private String id;
	private Set<UserComponent> children;
	
	public static UserGroup createUserGroup(String id) {
		// Check if allGroups already has a UserGroup with given id
		if (allGroups.contains(id)) {
			return null;
		}
		// If id not used yet, create the UserGroup, add to allGroups
		UserGroup newGroup = new UserGroup(id);
		allGroups.add(newGroup);
		return newGroup;
	}
		
	private UserGroup(String id) {
		this.id = id;
	}
	
	// So JTree displays id instead of address space
	@Override
	public String toString() {
		return this.id;
	}
	
	public Set<UserComponent> getChildren(){
		return children;
	}
	
	public void addChild(UserComponent child) {
		children.add(child);
	}
	
	public void setChildren(Set<UserComponent> components) {
		this.children = components;
	}
	

	@Override
	public void expand() {
		for(UserComponent component : children) {
			component.expand();
		}
	}

	@Override
	public void accept(Visitor vis) {
		vis.atUserGroup(this);
	}
	
	public static Set<UserGroup> getAllGroups() {
		return allGroups;
	}

}
