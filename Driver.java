
public class Driver {

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdminControlPanel adminPanel = AdminControlPanel.getInstance();
				adminPanel.setVisible(true);
			}
		});
	}
}
