import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdminControlPanelUI extends javax.swing.JFrame {
	// Singleton
	public static AdminControlPanelUI instance;
	Component root = new Group("root", null);
	javax.swing.tree.TreeNode rootNode = root;

	static AdminControlPanelUI getInstance() {
		if (instance == null) {
			synchronized (AdminControlPanelUI.class) {
				if (instance == null)
					instance = new AdminControlPanelUI();
			}
		}
		
		return instance;
	}

	AdminControlPanelUI() {
		// Initialize
		initComponents();
		setTitle("Admin");
		
		// Default users & groups
		User john = new User("john", root);
		User bob = new User("bob", root);
		User steve = new User("steve", root);

		root.insert(john); // root -> john
		root.insert(bob); // root -> bob
		root.insert(steve); // root -> steve

		Group CS356 = new Group("CS356", root);
		
		root.insert(CS356); // root -> cs356

		User stu1 = new User("stu1", CS356);
		User stu2 = new User("stu2", CS356);
		User stu3 = new User("stu3", CS356);
		
		CS356.insert(stu1); // cs356 -> stu1
		CS356.insert(stu2); // cs356 -> stu2
		CS356.insert(stu3); // cs356 -> stu3
		
		Group CS356Session01 = new Group("CS356Session01", CS356);
		
		CS356.insert(CS356Session01); // cs356 -> CS356Session01
		
		User stu8 = new User("stu8", CS356Session01); // CS356Session01 -> stu8
		User stu9 = new User("stu9", CS356Session01); // CS356Session01 -> stu9
		User stu10 = new User("stu10", CS356Session01); // CS356Session01 -> stu10
		
		CS356Session01.insert(stu8); // CS356Session01 -> stu8
		CS356Session01.insert(stu9); // CS356Session01 -> stu9
		CS356Session01.insert(stu10); // CS356Session01 -> stu10
		
		User stu4 = new User("stu4", CS356);
		
		CS356.insert(stu4); // CS356 -> stu8
		
		User oostu = new User("oostu", root);
		User ppstu2 = new User("ppstu2", root);
		
		root.insert(oostu); // root -> oostu
		root.insert(ppstu2); // root -> ppstu2
		
		// Update user total
		UserTotalVisitor totalUserVisitor = new UserTotalVisitor();
		totalUserVisitor.visit(root);
		labelUsersTotal.setText(String.valueOf(totalUserVisitor.getCount()));
		
		// Update group total
		GroupTotalVisitor totalGroupVisitor = new GroupTotalVisitor();
		totalGroupVisitor.visit(root);
		labelGroupTotal.setText(String.valueOf(totalGroupVisitor.getCount()));
		
		treeComponent.setModel(new DefaultTreeModel(rootNode));
		
		// A3
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				TweetVisitor tweetVisitor = new TweetVisitor();
				PositiveTweetVisitor positiveTweetVisitor = new PositiveTweetVisitor();
				
				// Total tweets
				tweetVisitor.visit(root);
				int tweetTotal = tweetVisitor.getTweets();
				labelMessageTotal.setText(String.valueOf(tweetTotal));
				
				// Positive tweets
				positiveTweetVisitor.visit(root);
				float positiveTweetTotal = positiveTweetVisitor.getPositiveTweets();
				String formatPercent = "";

				if (tweetTotal != 0)
					formatPercent = String.format("%.0f", positiveTweetTotal / tweetTotal * 100);
				
				labelPositivePercentage.setText(formatPercent + " %" + "");

			}
		}, 0, 1000);
		
	}

	// Copied as template
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		// Main Panel
		actionsPanel = new javax.swing.JPanel();
		
		// Panel
		addUserPanel = new javax.swing.JPanel();
		btnValidate = new javax.swing.JButton();
		
		// Panel
		addUserPanel1 = new javax.swing.JPanel();
		groupId = new javax.swing.JTextField();
		btnAddGroup = new javax.swing.JButton();
		
		// Panel
		addUserPanel2 = new javax.swing.JPanel();
		btnOpenUserView = new javax.swing.JButton();
		
		// Panel
		addUserPanel3 = new javax.swing.JPanel();
		labelUsersTotal = new javax.swing.JLabel();
		
		// Panel
		addUserPanel4 = new javax.swing.JPanel();
		labelGroupTotal = new javax.swing.JLabel();
		
		// Panel
		addUserPanel5 = new javax.swing.JPanel();
		labelPositivePercentage = new javax.swing.JLabel();
		
		// Panel
		addUserPanel6 = new javax.swing.JPanel();
		labelMessageTotal = new javax.swing.JLabel();
		
		// Panel
		addUserPanel7 = new javax.swing.JPanel();
		userId = new javax.swing.JTextField();
		btnAddUser = new javax.swing.JButton();
		scrollPanel = new javax.swing.JScrollPane();
		treeComponent = new javax.swing.JTree();
		
		lastUpdatedUser = new javax.swing.JTextField();
		btnFindLastUpdate = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		// A3
		addUserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Validation"));

		btnValidate.setText("Validate");
		btnValidate.addActionListener(evt -> btnValidateActionPerformed(evt));

		javax.swing.GroupLayout addUserPanelLayout = new javax.swing.GroupLayout(addUserPanel);
		addUserPanel.setLayout(addUserPanelLayout);
		addUserPanelLayout.setHorizontalGroup(
			addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(btnValidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap())
		);
		addUserPanelLayout.setVerticalGroup(
			addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserPanelLayout.createSequentialGroup()
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnValidate)
				.addContainerGap())
		);

		addUserPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Group"));

		btnAddGroup.setText("Add ");
		btnAddGroup.addActionListener(evt -> btnAddGroupActionPerformed(evt));

		javax.swing.GroupLayout addUserPanel1Layout = new javax.swing.GroupLayout(addUserPanel1);
		addUserPanel1.setLayout(addUserPanel1Layout);
		addUserPanel1Layout.setHorizontalGroup(
			addUserPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(groupId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnAddGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap())
		);
		addUserPanel1Layout.setVerticalGroup(
			addUserPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel1Layout.createSequentialGroup()
				.addGroup(addUserPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(groupId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnAddGroup))
				.addGap(0, 14, Short.MAX_VALUE))
		);

		addUserPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Open User View"));

		btnOpenUserView.setText("Open");
		btnOpenUserView.addActionListener(evt -> btnOpenUserViewActionPerformed(evt));

		javax.swing.GroupLayout addUserPanel2Layout = new javax.swing.GroupLayout(addUserPanel2);
		addUserPanel2.setLayout(addUserPanel2Layout);
		addUserPanel2Layout.setHorizontalGroup(
			addUserPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserPanel2Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(btnOpenUserView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		addUserPanel2Layout.setVerticalGroup(
			addUserPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel2Layout.createSequentialGroup()
				.addComponent(btnOpenUserView)
				.addGap(0, 14, Short.MAX_VALUE))
		);

		addUserPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("User total"));

		labelUsersTotal.setText("0");

		javax.swing.GroupLayout addUserPanel3Layout = new javax.swing.GroupLayout(addUserPanel3);
		addUserPanel3.setLayout(addUserPanel3Layout);
		addUserPanel3Layout.setHorizontalGroup(
			addUserPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel3Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelUsersTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		addUserPanel3Layout.setVerticalGroup(
			addUserPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel3Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelUsersTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, Short.MAX_VALUE))
		);

		addUserPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Group  total"));

		labelGroupTotal.setText("0");

		javax.swing.GroupLayout addUserPanel4Layout = new javax.swing.GroupLayout(addUserPanel4);
		addUserPanel4.setLayout(addUserPanel4Layout);
		addUserPanel4Layout.setHorizontalGroup(
			addUserPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel4Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelGroupTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(70, Short.MAX_VALUE))
		);
		addUserPanel4Layout.setVerticalGroup(
			addUserPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel4Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelGroupTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, Short.MAX_VALUE))
		);

		addUserPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Positive %"));

		labelPositivePercentage.setText("0");

		javax.swing.GroupLayout addUserPanel5Layout = new javax.swing.GroupLayout(addUserPanel5);
		addUserPanel5.setLayout(addUserPanel5Layout);
		addUserPanel5Layout.setHorizontalGroup(
			addUserPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel5Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelPositivePercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		addUserPanel5Layout.setVerticalGroup(
			addUserPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel5Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelPositivePercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, Short.MAX_VALUE))
		);

		addUserPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Message total"));

		labelMessageTotal.setText("0");

		javax.swing.GroupLayout addUserPanel6Layout = new javax.swing.GroupLayout(addUserPanel6);
		addUserPanel6.setLayout(addUserPanel6Layout);
		addUserPanel6Layout.setHorizontalGroup(
			addUserPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel6Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelMessageTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(82, Short.MAX_VALUE))
		);
		addUserPanel6Layout.setVerticalGroup(
			addUserPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel6Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(labelMessageTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, Short.MAX_VALUE))
		);

		addUserPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Add User"));

		btnAddUser.setText("Add ");
		btnAddUser.addActionListener(evt -> btnAddUserActionPerformed(evt));

		javax.swing.GroupLayout addUserPanel7Layout = new javax.swing.GroupLayout(addUserPanel7);
		addUserPanel7.setLayout(addUserPanel7Layout);
		addUserPanel7Layout.setHorizontalGroup(
			addUserPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel7Layout.createSequentialGroup()
				.addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap())
		);
		addUserPanel7Layout.setVerticalGroup(
			addUserPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(addUserPanel7Layout.createSequentialGroup()
				.addGroup(addUserPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(btnAddUser))
				.addGap(0, 14, Short.MAX_VALUE))
		);

		javax.swing.GroupLayout actionsPanelLayout = new javax.swing.GroupLayout(actionsPanel);
		actionsPanel.setLayout(actionsPanelLayout);
		actionsPanelLayout.setHorizontalGroup(
			actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(addUserPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(actionsPanelLayout.createSequentialGroup()
				.addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
					.addComponent(addUserPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(addUserPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(addUserPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(addUserPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			.addComponent(addUserPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(addUserPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(addUserPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		actionsPanelLayout.setVerticalGroup(
			actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(actionsPanelLayout.createSequentialGroup()
				.addComponent(addUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(addUserPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(addUserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(addUserPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(11, 11, 11)
				.addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(addUserPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(addUserPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(addUserPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(addUserPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		);

		treeComponent.setBorder(javax.swing.BorderFactory.createTitledBorder("Tree View"));
		scrollPanel.setViewportView(treeComponent);

		lastUpdatedUser.setEnabled(false);

		btnFindLastUpdate.setText("Find ");
		btnFindLastUpdate.addActionListener(evt -> btnFindLastUpdateActionPerformed(evt));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(actionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout
							.DEFAULT_SIZE, Short.MAX_VALUE))
			));
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGroup(layout.createSequentialGroup()
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(actionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidateActionPerformed
		UserValidationVisitor userValidationVisitor = new UserValidationVisitor();
		userValidationVisitor.visit(root);
		
		// Check unique ids
		List<String> checkUnique = userValidationVisitor.checkUnique();
		
		// Check no spaces
		List<String> checkSpaces = userValidationVisitor.checkSpaces();
		if (checkUnique.isEmpty() && checkSpaces.isEmpty())
			JOptionPane.showMessageDialog(this, "All User IDs are Valid.");
			
		else {
			String message = "\n";
			
			// unique
			for (String check : checkUnique)
				message += check + "\n";
			
			// spaces
			for (String check : checkSpaces)
				message += check + "\n";
			
			JOptionPane.showMessageDialog(this, "Invalid IDs Found: " + message);
		}
		
	}//GEN-LAST:event_btnValidateActionPerformed
	
	private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
		String userIdText = userId.getText();
		userId.setText("");
		
		DefaultTreeModel model = (DefaultTreeModel) treeComponent.getModel();
		
		Component root = (Group) model.getRoot();
		Component selectedNode = (Component) treeComponent.getLastSelectedPathComponent();
		
		String id = userIdText.trim();
		
		if (id.equals("")) {
			System.out.println("Blank username entered!");
		}
		else {
			if (selectedNode != null) {
				if (!root.contains(id))
					if (selectedNode instanceof Group) {
						Component newUser = new User(id, selectedNode);
						System.out.println("New user created: " + id);
						
						model.insertNodeInto(newUser, selectedNode, selectedNode.getChildCount());
						model.reload(newUser);
					}
			}
			else {
				if (!root.contains(id)) {
					Component newUser = new User(id, root);
					System.out.println("New user created: " + id);
					root.insert(newUser);
					model.reload();
				}
			}
		}
		
		// Update total users
		UserTotalVisitor totalVisitor = new UserTotalVisitor();
		totalVisitor.visit(root);
		labelUsersTotal.setText(totalVisitor.getCount() + "");
	}//GEN-LAST:event_btnAddUserActionPerformed

	private void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGroupActionPerformed
		// TODO add group
		DefaultTreeModel model = (DefaultTreeModel) treeComponent.getModel();
		Component root = (Group) model.getRoot();
		Component selectedNode = (Component) treeComponent.getLastSelectedPathComponent();
		
		String group = groupId.getText();

		if (group.trim().equals("")) {
			System.out.println("Blank Group Name entered!");
		} else {
			if (selectedNode != null) {
				if (!root.contains(group)) {
					if (selectedNode instanceof Group) {
						Component newGroup = new Group(group, selectedNode);
						System.out.println("New group created: " + group);

						model.insertNodeInto(newGroup, selectedNode, selectedNode.getChildCount());
						model.reload(newGroup);
					}
				}
			}
			else {
				if (!root.contains(group)) {
					Component newGroup = new Group(group, root);
					System.out.println("New group created: " + group);
					
					root.insert(newGroup);
					model.reload();
				}
			}
		}
		
		groupId.setText("");
		
		// Update total users
		GroupTotalVisitor totalVisitor = new GroupTotalVisitor();
		totalVisitor.visit(root);
		labelGroupTotal.setText(totalVisitor.getCount() + "");
	}//GEN-LAST:event_btnAddGroupActionPerformed

	private void btnOpenUserViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenUserViewActionPerformed
		// TODO open
		Component node = (Component) treeComponent.getLastSelectedPathComponent();
		
		if (node != null && node instanceof User) {
			UserViewUI userViewUI = new UserViewUI((User) node, root);
			userViewUI.setVisible(true);
		}
	}//GEN-LAST:event_btnOpenUserViewActionPerformed

	private void btnFindLastUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindLastUpdateActionPerformed
		// TODO add your handling code here:
		LastUpdatedVisitor lastUpdatedVisitor = new LastUpdatedVisitor();
		lastUpdatedVisitor.visit(root);
		
		User user = lastUpdatedVisitor.getUser();
		lastUpdatedUser.setText(user != null ? user.getId() + " at " + user.getLastUpdateTimeString() : "Not available");
	}//GEN-LAST:event_btnFindLastUpdateActionPerformed

	// MAIN //
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AdminControlPanelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AdminControlPanelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AdminControlPanelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AdminControlPanelUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> new AdminControlPanelUI().setVisible(true));
	}
	// .. //

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel actionsPanel;
	private javax.swing.JPanel addUserPanel;
	private javax.swing.JPanel addUserPanel1;
	private javax.swing.JPanel addUserPanel2;
	private javax.swing.JPanel addUserPanel3;
	private javax.swing.JPanel addUserPanel4;
	private javax.swing.JPanel addUserPanel5;
	private javax.swing.JPanel addUserPanel6;
	private javax.swing.JPanel addUserPanel7;
	private javax.swing.JPanel addUserPanel8;
	private javax.swing.JButton btnAddGroup;
	private javax.swing.JButton btnAddUser;
	private javax.swing.JButton btnFindLastUpdate;
	private javax.swing.JButton btnOpenUserView;
	private javax.swing.JButton btnValidate;
	private javax.swing.JTextField groupId;
	private javax.swing.JLabel labelGroupTotal;
	private javax.swing.JLabel labelMessageTotal;
	private javax.swing.JLabel labelPositivePercentage;
	private javax.swing.JLabel labelUsersTotal;
	private javax.swing.JTextField lastUpdatedUser;
	private javax.swing.JScrollPane scrollPanel;
	private javax.swing.JTree treeComponent;
	private javax.swing.JTextField userId;
	// End of variables declaration//GEN-END:variables
}
