package jobtrack;

public class Main {
	public static void main(String[] args) {
		ApplicationService service = new ApplicationService();
		CsvFileIO csv = new CsvFileIO();
		service.setList(csv.load());

		Menu menu = new Menu(service);
		menu.start();

		csv.save(service.getList());
		InputUtil.close();

	}
}