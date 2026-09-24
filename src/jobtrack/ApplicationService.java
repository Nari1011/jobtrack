package jobtrack;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ApplicationService {
	private ArrayList<JobApplication> list = new ArrayList<>();
	private int nextId = 1;

	public void register() {
		String companyName = InputUtil.readText("企業名: ");
		String jobType = InputUtil.readText("職種: ");
		String nextAction = InputUtil.readText("次の予定: ");
		LocalDate nextDate = InputUtil.readDate("期日の日を入力してください: ");

		JobApplication app = new JobApplication(nextId, companyName, jobType,
				LocalDate.now(), nextAction, nextDate);
		list.add(app);
		nextId++;
		System.out.println("登録しました");
	}

	public void showAll() {
		if (list.size() == 0) {
			System.out.println("登録されていません");
			return;
		}
		for (JobApplication app : list) {
			long days = ChronoUnit.DAYS.between(LocalDate.now(),
					app.getNextDate());
			String remain;
			if (days < 0) {
				remain = "期限切れ";
			} else {
				remain = "あと" + days + "日";
			}
			System.out.println(app.getId() + " " +
					app.getCompanyName() + " " +
					app.getJobType() + " " +
					app.getStageName() + " " +
					app.getNextAction() + " " +
					app.getNextDate() + " " +
					remain);

		}
	}

	private JobApplication findById(int id) {
		for (JobApplication app : list) {
			if (app.getId() == id) {
				return app;
			}
		}
		return null;
	}

	public void delete() {
		if (list.size() == 0) {
			System.out.println("登録されていません");
			return;
		}
		showAll();
		int id = InputUtil.readInt("削除する番号: ");
		JobApplication app = findById(id);
		if (app == null) {
			System.out.println("その番号は存在しません");
			return;
		}
		list.remove(app);
		System.out.println("削除しました");
	}

	public void update() {
		if (list.size() == 0) {
			System.out.println("登録されていません");
			return;
		}
		showAll();
		int id = InputUtil.readInt("更新する番号を選択: ");
		JobApplication app = findById(id);
		if (app == null) {
			System.out.println("その番号は存在しません");
			return;
		}
		System.out.println("1.書類");
		System.out.println("2.一次");
		System.out.println("3.二次");
		System.out.println("4.最終");
		System.out.println("5.内定");
		System.out.println("6.不採用");
		int stage = InputUtil.readIntInRange("段階: ", 1, 6);
		app.setStage(stage);
		String nextAction = InputUtil.readText("次の予定: ");
		app.setNextAction(nextAction);
		LocalDate nextDate = InputUtil.readDate("期日の入力: ");
		app.setNextDate(nextDate);
		System.out.println("更新しました。");

	}

	public void search() {
		if (list.size() == 0) {
			System.out.println("登録されていません");
			return;
		}
		String word = InputUtil.readText("検索語: ");
		int count = 0;
		for (JobApplication app : list) {
			if (app.getCompanyName().indexOf(word) != -1 || app.getJobType().indexOf(word) != -1) {
				long days = ChronoUnit.DAYS.between(LocalDate.now(), app.getNextDate());
				String remain;
				if (days < 0) {
					remain = "期限切れ";
				} else {
					remain = "あと" + days + "日";
				}
				System.out.println(app.getId() + " " +
						app.getCompanyName() + " " +
						app.getJobType() + " " +
						app.getStageName() + " " +
						app.getNextAction() + " " +
						app.getNextDate() + " " +
						remain);
				count++;
			}
		}
		if (count == 0) {
			System.out.println("見つかりませんでした");
			return;
		}
	}

	public ArrayList<JobApplication> getList() {
		return list;
	}

	public void setList(ArrayList<JobApplication> list) {
		this.list = list;
		for (JobApplication app : list) {
			if (app.getId() >= nextId) {
				nextId = app.getId() + 1;
			}
		}
	}

}
