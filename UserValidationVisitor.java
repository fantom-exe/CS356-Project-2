
import java.util.ArrayList;
import java.util.List;

public class UserValidationVisitor implements Visitor {

    List<String> IDs = new ArrayList<>();

    @Override
    public void visit(Component component) {
        if (component instanceof User) {
            IDs.add(component.id);
        }else{
            IDs.add(component.id);
            for (Component child : component.child) {
                visit(child);
            }
        }
    }

    public List<String> checkUnique() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < IDs.size(); i++) {
            for (int j = i + 1; j < IDs.size(); j++) {
                if (IDs.get(i).equals(IDs.get(j))) {
                    list.add(IDs.get(i) + " is not unique");
                }
            }

        }
        return list;
    }

    public List<String> checkSpaces() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < IDs.size(); i++) {
            if(IDs.get(i).contains(" ")){
                 list.add(IDs.get(i) + " contains space");
            }
        }
        return list;
    }
}
