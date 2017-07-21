
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User extends Component {

    private Set<String> followings;
    private List<Tweet> newsFeed;
    private Set<Observer> observers = new HashSet<>();
    private long lastUpdateTime;

    public User(String id, Component parent) {
        this.id = id;
        this.parent = parent;
        this.followings = new HashSet<>();
        this.newsFeed = new ArrayList<>();
        this.creationTime = System.currentTimeMillis();
        this.lastUpdateTime = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean follow(User other) {
        if (this.equals(other)) {
            return false;
        }
        if (other == null) {
            return false;
        }
        other.register(this);
        if (followings.contains(other.getId())) {
            return false;
        } else {
            followings.add(other.getId());
            return true;
        }

    }

    public void tweet(String message) {
        this.lastUpdateTime = System.currentTimeMillis();
        update(message);
    }

    public Set<String> getFollowings() {
        return followings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Tweet> getNewsFeed() {
        return newsFeed;
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.notify();
        }
    }

    @Override
    public void update(String message) {
        this.newsFeed.add(new Tweet(message));
        for (Observer observer : observers) {
            ((User) observer).lastUpdateTime = System.currentTimeMillis();
            ((User) observer).newsFeed.add(new Tweet(message));
        }

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean contains(String id) {
        return this.id.equals(id);
    }

    public String getCreationTime() {
        Date date = new Date(creationTime);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        String dateText = df2.format(date);
        return dateText;
    }

    @Override
    public String toString() {
        return id;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public String getLastUpdateTimeString() {
        Date date = new Date(lastUpdateTime);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        String dateText = df2.format(date);
        return dateText;
    }

    @Override
    public User getById(String id) {
        if (this.id.equals(id)) {
            return this;
        } else {
            return null;
        }
    }

}
