
import java.util.List;

public class PositiveTweetVisitor implements Visitor {

    private int positiveTweets = 0;

    @Override
    public void visit(Component component) {
        List<Tweet> userTweets = component.getNewsFeed();
        
        for (Tweet t : userTweets) {
            if (t.isPositive()) {
                this.positiveTweets += 1;
            }
        }
    }

    public int getPositiveTweets() {
        return positiveTweets;
    }
    
}
