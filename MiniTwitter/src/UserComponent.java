
public interface UserComponent {
	
	// This is the component interface for the Composite design pattern
	
	public void expand();
	
	public void accept(Visitor vis);
	
}
