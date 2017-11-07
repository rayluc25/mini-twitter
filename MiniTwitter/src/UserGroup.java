import java.util.Set;

public class UserGroup implements UserComponent {
	// UserGroup is the composite container in this Composite design pattern
	
	private boolean isGroup = true;
	private boolean isUser = false;
	private String id;
	private Set<UserComponent> children;
	
	public UserGroup(String id) {
		this.id = id;
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
		// TODO Auto-generated method stub
		for(UserComponent component : children) {
			component.expand();
		}
	}

}
