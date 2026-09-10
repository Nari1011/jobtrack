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
		if (list.isEmpty()) {
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
}
