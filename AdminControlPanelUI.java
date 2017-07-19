/*
6. A few analysis features are needed in the admin control panel:
	1) output the total number of users;
	2) output the total number of groups;
	3) output the total number of Tweet messages in all the users’ news feed;
	4) output the percentage of the positive Tweet messages in all the users’
	news feed (the message containing positive words, such as good, great,
	excellent, etc.) Free free to decide the positive words.
	
	** UI **
3.  -You can add users/groups with Buttons and TextAreas.
	-Of course, the TreeView should be updated as well whenever new users/groups are being added.
4.  For groups, you should display them with a different notation (maybe a folder
	icon or something else just to distinguish it from the users).
5.  Deleting users/groups is not required.
6.  -Clicking on the 4 buttons at the bottom-right will output the correspondent
		information.
	-You can simply popup a dialog to display the value, or use some other widgets.
7.  -When you select a user in the tree, clicking on the Open User View button will
		open the User View as shown in Figure 2.
	-You can open multiple User Views for different users.
8.  -In the User View, it will display the current users you are following in a
		ListView (followings).
	-You can add new users to follow by using the TextArea and Button.
	-Unfollow is not required. Displaying your followers is not required.
9.  The User View also shows the current news feed list for this user in a ListView.
10. You can post a new Tweet with the TextArea and Button. Once you click the Post
	button. It will add the message to all your followers’ news feed list, as well
	as your own news feed list.
11. Whenever a new message is posted, all the followers’ news feed list view should
	be updated and refreshed automatically.
 */

import javax.swing.*;
import java.awt.*;

public class AdminControlPanelUI extends JFrame {
	// main panel
	private JPanel mainPanel = new JPanel();
	
	// center
	private JPanel centerPanel = new JPanel();
	private JTextArea userList = new JTextArea(25, 25);
	private JScrollPane userListScroll = new JScrollPane(userList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	// east
	private JPanel eastPanel = new JPanel();
	private JTextArea userID = new JTextArea();
	private JButton addUser = new JButton("Add User");
	private JTextArea groupID = new JTextArea();
	private JButton addGroup = new JButton("Add Group");
	private JButton userView = new JButton("User View");
	
	// south
	private JPanel southPanel = new JPanel();
	
	
	AdminControlPanelUI() {
		// frame
		super("Twitter");
		setSize(700, 450);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// main panel
		mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		
		// center panel - user view
//		centerPanel.setLayout(new BorderLayout());
		
		centerPanel.add(userList);
		centerPanel.add(userListScroll, BorderLayout.CENTER);
		
		// east panel
//		eastPanel.setLayout(new BorderLayout());
		
		eastPanel.add(userID);
		eastPanel.add(addUser);
		eastPanel.add(groupID);
		eastPanel.add(addGroup);
		eastPanel.add(userView);
		
		// buttons - south panel
		
		
		// frame
		add(mainPanel);
		setVisible(true);
	}
	
}
