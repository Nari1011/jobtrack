package jobtrack;

public class Menu {
	private ApplicationService service;

	public Menu(ApplicationService service) {
		this.service = service;

	}

	private void showMenu() {
		System.out.println("---JOBTRACK---");
		System.out.println("1.応募先の登録");
		System.out.println("2.応募先の一覧表示");
		System.out.println("3.応募作の削除");
		System.out.println("0.終了");
		System.out.println("--------------");
	}

	public void start() {
		while (true) {
			showMenu();
			int choice = InputUtil.readIntInRange("番号を入力してください:", 0, 3);
			if (choice == 0) {
				System.out.println("終了します。");
				return;
			}
			switch (choice) {
			case 1:
				service.register();
				break;
			case 2:
				service.showAll();
				break;
			case 3:

			}

		}
	}

}
