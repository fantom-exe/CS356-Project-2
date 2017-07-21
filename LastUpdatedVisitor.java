
import java.util.Calendar;
import java.util.Date;

public class LastUpdatedVisitor implements Visitor {

    private User user;
    long date;

    public LastUpdatedVisitor() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -4);
        this.date = calendar.getTime().getTime();
    }

    @Override
    public void visit(Component component) {
        if (component instanceof User) {
            User current = (User) component;
            if (date < (current).getLastUpdateTime()) {
                user = (User) component;
                date = current.getLastUpdateTime();
            }
        } else {
            for (Component child : component.child) {
                visit(child);
            }
        }
    }

    public User getUser() {
        return user;
    }

}
