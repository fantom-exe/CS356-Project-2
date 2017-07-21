public class UserTotalVisitor implements Visitor {
	private int visitorCount = 0;

	public void visit(Component component) {
		if (component instanceof User)
			visitorCount++;
		else
			for (Component child : component.child)
				visit(child);
	}
	
	int getCount() {
		return visitorCount;
	}
}
