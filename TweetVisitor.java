import java.util.List;

public class TweetVisitor implements Visitor {
	private int tweets = 0;

	@Override
	public void visit(Component component) {
		List<Tweet> userTweets = component.getNewsFeed();
		tweets += userTweets.size();
	}

	int getTweets() {
		return tweets;
	}
	
}
