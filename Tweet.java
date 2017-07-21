import java.util.*;

public class Tweet {
	private String message;
	private boolean ispositive = false;

	Tweet(String tweet) {
		this.message = tweet;
		this.ispositive = checkPositive();
	}
	
	// Check message for positive words
	private boolean checkPositive() {
		List<String> positiveWords = new ArrayList<>(Arrays.asList("good", "great", "awesome", "epic"));
		
		for (String word : positiveWords) {
			if (this.message.toLowerCase().contains(word)) {
				return true;
			}
		}

		return false;
	}
	
	boolean isPositive() {
		return ispositive;
	}
	
	public String toString() {
		return message;
	}
	
	// Use toString instead
	public String getMessage() {
		return message;
	}
}
