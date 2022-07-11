package OnlineExamApp;

import java.util.List;

public class Question {
	
	private String question;			//Question
	private List<Option> options;		//and its options list	(Option list from option class)
	
	public Question() {		
	}
	
	public Question (String question) {
		super();
		this.question = question;
	}

	public String getQuestion() {		//returning question
		return question;
	}

	public void setQuestion(String question) {		//setting question
		this.question = question;
	}

	public List<Option> getOptions() {		//returning options list
		return options;
	}

	public void setOptions(List<Option> options) {		//setting options list
		this.options = options;
	}
	
}
