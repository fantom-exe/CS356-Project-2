import java.util.*;
import java.text.SimpleDateFormat;

public class User extends Component {
	private Set<String> followings;
	private List<Tweet> newsFeed;
	private Set<Observer> observers = new HashSet<>();
	
	private long lastUpdateTime; // A3

	User(String id, Component parent) {
		this.id = id;
		this.parent = parent;
		this.followings = new HashSet<>();
		this.newsFeed = new ArrayList<>();
		
		// A3
		this.creationTime = System.currentTimeMillis();
		this.lastUpdateTime = 0;
	}

	String getId() {
		return id;
	}
	
	Set<String> getFollowings() {
		return followings;
	}
	
	public List<Tweet> getNewsFeed() {
		return newsFeed;
	}

	// unused
	public void setId(String id) {
		this.id = id;
	}

	boolean follow(User other) {
		// Do nothing //
		if (this.equals(other))
			return false;
		if (other == null)
			return false;
		// .. //
		
		other.register(this);
		
		if (followings.contains(other.getId())) // already following
			return false;
		else {
			followings.add(other.getId());
			return true;
		}

	}
	
	// Tweet message & update time
	void tweet(String message) {
		this.lastUpdateTime = System.currentTimeMillis();
		update(message);
	}
	
	public boolean equals(Object obj) {
		// False
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		// True
		if (this == obj)
			return true;
		
		final User other = (User) obj;
		
		return Objects.equals(this.id, other.id);
	}
	
	public boolean contains(String id) {
		return this.id.equals(id);
	}
	
	public String toString() {
		return id;
	}
	
	public User getUserByID(String id) {
		if (this.id.equals(id))
			return this;
		else
			return null;
	}
	
	public int hashCode() {
		int hash = 3;
		hash = 29 * hash + Objects.hashCode(this.id);
		return hash;
	}

	// A3 //
	String getCreationTime() {
		Date date = new Date(creationTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		
		return dateFormat.format(date);
	}
	
	long getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	String getLastUpdateTimeString() {
		Date date = new Date(lastUpdateTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
		
		return dateFormat.format(date);
	}
	// .. //
	
	// // // //
	public void register(Observer observer) {
		this.observers.add(observer);
	}
	
	public void unregister(Observer observer) {
		this.observers.remove(observer);
	}
	
	public void notifyObserver() {
		for (Observer observer : observers)
			observer.notify();
	}
	
	public void update(String message) {
		this.newsFeed.add(new Tweet(message));
		
		for (Observer observer : observers) {
			((User) observer).lastUpdateTime = System.currentTimeMillis();
			((User) observer).newsFeed.add(new Tweet(message));
		}
		
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	// .. //

}
