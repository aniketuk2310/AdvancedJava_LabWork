package OnlineExamApp;

public class Option {
	
	private String option;				//option
	private boolean isRightAnswer;		//status of answer

	public Option() {
	}

	public Option(String option, boolean isRightAnswer) {
		super();
		this.option = option;
		this.isRightAnswer = isRightAnswer;
	}

	public String getOption() {		//getting that particular option
		return option;
	}

	public void setOption(String option) {		//setting that particular option
		this.option = option;
	}

	public boolean isRightAnswer() {		//checking is answer is right or not
		return isRightAnswer;
	}

	public void setRightAnswer(boolean isRightAnswer) {		//setting right answer
		this.isRightAnswer = isRightAnswer;
	}

}
