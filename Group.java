
import java.util.ArrayList;

public class Group extends Component {

	Group(String root, Component parent) {
		this.id = root;
		this.parent = parent;
		this.child = new ArrayList<>();
		this.creationTime = System.currentTimeMillis();
	}

	public void add(Component component) {
		child.add(component);
	}

	@Override
	public boolean contains(String id) {
		if (this.id.equals(id))
			return true;
		
		for (Component component : child)
			if (component.contains(id))
				return true;
		
		return false;
	}

	@Override
	public void register(Observer observer) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void unregister(Observer observer) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void notifyObserver() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(String message) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public User getById(String id) {
		for (Component component : child) {
			if (component instanceof User) {
				User found = (User) component;
				if (found.getId().equals(id)) {
					return found;
				}
			} else {
				return component.getById(id);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return id;
	}
	
}
