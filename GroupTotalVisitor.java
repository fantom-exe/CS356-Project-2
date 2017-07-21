
public class GroupTotalVisitor implements Visitor {

	private int count = 0;

	@Override
	public void visit(Component component) {
		if (component instanceof User) {
		} else {
			count++;
			for (Component child : component.child) {
				visit(child);
			}
		}
	}

	public int getCount() {
		return count;
	}
	
	

}
