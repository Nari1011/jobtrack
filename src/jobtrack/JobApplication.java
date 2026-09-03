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

}
