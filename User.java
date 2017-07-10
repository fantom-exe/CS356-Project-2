/*
2. A ​user has   1) an unique ID;
				2) a list of user IDs that are following this user (followers);
				3) a list of user IDs being followed by this user (followings);
				4) a news feed list containing a list of Twitter messages
				
4. Users can choose to follow other users (not user groups) by providing the target user ID.
Unfollow is not required

5. Users can also post a short Tweet message (a String), so that all the followers can see
this message in their news feed lists. Of course, the user can also see his or her own
posted messages.
 */

import java.util.ArrayList;

public class User {
	private String ID;
	private ArrayList<User> followers;
	
	public User() {
		followers = new ArrayList<>();
		
	}
	
	
}
