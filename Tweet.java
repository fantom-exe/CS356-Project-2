
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

	private boolean checkPositive() {
		List<String> positiveWords = new ArrayList<>(Arrays.asList("good", "beautiful", "great"));
		for (String word : positiveWords) {
			if (this.message.toLowerCase().contains(word)) {
				return true;
			}
		}

		return false;
	}
	
	public String getMessage() {
		return message;
	}

	public boolean isPositive() {
		return ispositive;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
