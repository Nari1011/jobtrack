package jobtrack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CsvFileIO {

	private static final String FILE_NAME = "applications.csv";

	public void save(ArrayList<JobApplication> list) {
		try {
			FileWriter fw = new FileWriter(FILE_NAME);
			for (JobApplication app : list) {
				String line = app.getId() + "," +
						app.getCompanyName() + "," +
						app.getJobType() + "," +
						app.getAppliedDate() + "," +
						app.getStage() + "," +
						app.getNextAction() + "," +
						app.getNextDate();
				fw.write(line + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("保存に失敗しました");
		}
	}

	public ArrayList<JobApplication> load() {
		ArrayList<JobApplication> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String line = br.readLine();
			while (line != null) {
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
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			System.out.println("読み込みに失敗しました");
		}
		return list;
	}
}