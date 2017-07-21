
public class Driver {

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdminControlPanelUI adminPanel = AdminControlPanelUI.getInstance();
				adminPanel.setVisible(true);
			}
		});
	}
}
