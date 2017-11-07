import java.util.List;
import java.util.UUID;

public class UserGroup implements UserComponent {
	
	private boolean isGroup = true;
	private boolean isUser = false;
	private String id = UUID.randomUUID().toString();
	private List<UserComponent> components;
	
	public List<UserComponent> getComponents(){
		return components;
	}
	
	public void setComponents(List<UserComponent> components) {
		this.components = components;
	}
	

	@Override
	public void expand() {
		// TODO Auto-generated method stub
		for(UserComponent component : components) {
			component.expand();
		}
	}

}
