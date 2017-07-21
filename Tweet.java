
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tweet {
	private String message;
	private boolean ispositive = false;

	public Tweet(String message) {
		this.message = message;
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
	
	// Use toString instead
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
