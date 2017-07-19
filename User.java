/*
2. A ​user has   1) an unique ID;
				2) a list of user IDs that are following this user (followers);
				3) a list of user IDs being followed by this user (followings);
				4) a news feed list containing a list of Twitter messages
				
4.  Users can choose to follow other users (not user groups) by providing the target user ID.
	Unfollow is not required

5.  Users can also post a short Tweet message (a String), so that all the followers can see
	this message in their news feed lists. Of course, the user can also see his or her own
	posted messages.
 */

import java.util.ArrayList;

public class User {
	private String ID;
	private ArrayList followers;
	private ArrayList followings;
	private String status;
	
	// Constructor - initialize variables
	private User() {
		ID = "";
		followers = new ArrayList<String>();
		followings = new ArrayList<String>();
		status = "";
	}
	
	// Follow specified user
	public void followUser(User userID) {
		userID.setFollowings(this.getID());
	}
	
	// Get user ID
	public String getID() {
		return ID;
	}
	
	// Set user ID
	public void setID(String ID) {
		this.ID = ID;
	}
	
	// Get list of people that follow user
	public String getFollowers() {
		String strFollowers = "";
		
		for (int i = 0; i < followers.size(); i++) {
			strFollowers += followers.get(i) + "\n";
		}
		
		return strFollowers;
	}
	
	// Follow this user
	public void follow(String userID) {
		followers.add(userID);
	}
	
	// Get list of people followed by the user
	public String getFollowings() {
		String strFollowings = "";
		
		for (int i = 0; i < followings.size(); i++) {
			strFollowings += followings.get(i) + "\n";
		}
		
		return strFollowings;
	}
	
	// Add person's ID to list of people followed by user
	public void setFollowings(String userID) {
		followings.add(userID);
	}
	
	// Return user's current status
	public String getStatus() {
		return status;
	}
	
	// Set the user's status
	public void setStatus(String statusUpdate) {
		status = statusUpdate;
	}
	
}
