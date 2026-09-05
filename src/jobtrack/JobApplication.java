package jobtrack;

import java.time.LocalDate;

public class JobApplication {
	private int id;
	private String companyName;
	private String jobType;
	private LocalDate appliedDate;
	private int stage;
	private String nextAction;
	private LocalDate nextDate;

	public JobApplication(int id, String companyName, String jobType, LocalDate appliedDate, String nextAction,
			LocalDate nextDate) {
		this.id = id;
		this.companyName = companyName;
		this.jobType = jobType;
		this.appliedDate = appliedDate;
		this.nextAction = nextAction;
		this.nextDate = nextDate;
		this.stage = 1;

	}

	public int getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getJobType() {
		return jobType;
	}

	public int getStage() {
		return stage;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public String getNextAction() {
		return nextAction;
	}

	public LocalDate getNextDate() {
		return nextDate;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

	public void setNextDate(LocalDate nextDate) {
		this.nextDate = nextDate;
	}

	public String getStageName() {
		switch (stage) {
		case 1:
			return "書類";
		case 2:
			return "一次";
		case 3:
			return "二次";
		case 4:
			return "最終";
		case 5:
			return "内定";
		case 6:
			return "不採用";
		default:
			return "不明";
		}
	}

}
