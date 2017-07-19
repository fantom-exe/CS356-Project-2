/*
3. A ​user group has an unique ID, which can be used to group users.
A user group can contain any number of users.
The same user can only be included in one group.
Of course, a user group can contain other user groups recursively.
There is always a root group called ​Root ​ to include everything.
 */

public class UserGroup {
	private String ID;
	private UserGroup root;
	
	
	private UserGroup() {
	
	}
	
}
