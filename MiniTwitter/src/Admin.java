
public class Admin {
	// uses Singleton design pattern

	protected static Admin instance;
	
	protected Admin() { }
	
	public static Admin getInstance() {
		if (instance == null) {
			instance = new Admin();
		}
		return instance;
	}
	
	
}
