package jobtrack;

public class Main {
	public static void main(String[] args) {
		ApplicationService service = new ApplicationService();
		Menu menu = new Menu(service);
		menu.start();
		InputUtil.close();

	}
}