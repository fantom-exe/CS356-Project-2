
import java.util.ArrayList;
import java.util.List;

public class UserValidationVisitor implements Visitor {
	private List<String> IDs = new ArrayList<>();

	@Override
	public void visit(Component component) {
		if (component instanceof User)
			IDs.add(component.id);
		else {
			IDs.add(component.id);
			
			for (Component child : component.child)
				visit(child);
		}
		
	}
	
	// Check for spaces in id
	List<String> checkSpaces() {
		List<String> list = new ArrayList<>();
		
		// Add IDs containing spaces to list
		for (int i = 0; i < IDs.size(); i++)
			if(IDs.get(i).contains(" "))
				list.add(IDs.get(i) + " contains space(s)!");
		
		// Return list of IDs with spaces
		return list;
	}
	
	// Check whether id is unique
	List<String> checkUnique() {
		List<String> list = new ArrayList<>();
		
		// Add IDs not unique to list
		for (int i = 0; i < IDs.size(); i++) {
			for (int j = i + 1; j < IDs.size(); j++)
				if (IDs.get(i).equals(IDs.get(j)))
					list.add(IDs.get(i) + " is not unique!");
		}
		
		// Return list of IDs that are not unique
		return list;
	}
}
