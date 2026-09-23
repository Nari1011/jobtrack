package jobtrack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvFileIO {

	private static final String FILE_NAME = "applications.csv";

	public void save(ArrayList<JobApplication> list) {
		ArrayList<String> lines = new ArrayList<>();
		for (JobApplication app : list) {
			String line = app.getId() + "," +
					app.getCompanyName() + "," +
					app.getJobType() + "," +
					app.getAppliedDate() + "," +
					app.getStage() + "," +
					app.getNextAction() + "," +
					app.getNextDate();
			lines.add(line);
		}

		try {
			Files.write(Paths.get(FILE_NAME), lines);
		} catch (IOException e) {
			System.out.println("保存に失敗しました");
		}
	}

	public ArrayList<JobApplication> load() {
		ArrayList<JobApplication> list = new ArrayList<>();
		if (!Files.exists(Paths.get(FILE_NAME))) {
			return list;
		}

		try {
			List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
			for (String line : lines) {
				String[] parts = line.split(",");
				JobApplication app = new JobApplication(
						Integer.parseInt(parts[0]),
						parts[1],
						parts[2],
						LocalDate.parse(parts[3]),
						parts[5],
						LocalDate.parse(parts[6]));
				app.setStage(Integer.parseInt(parts[4]));
				list.add(app);
			}
		} catch (IOException e) {
			System.out.println("読み込みに失敗しました");
		}
		return list;
	}
}