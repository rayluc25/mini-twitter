import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	// Implement Subject (Observable) abstract class for practice
	
	protected List<Observer> observers = new ArrayList<Observer>();
	
	public abstract String getId();
	
	public void attach(Observer observer) {
		observers.add(observer);
		observer.follow(this);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers(Post post) {
		for(Observer ob : observers) {
			ob.update(post);
		}
	}

}
