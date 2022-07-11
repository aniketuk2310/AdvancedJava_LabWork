package OnlineExamApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {

	//key-value pair (subject name -> key, questions of that subject -> value)
	private Map< String, List<Question> > questionBank = new HashMap<>();
	
	/* not recommended version
	private List<Question> questionsOnJava;
	private List<Question> questionsOnPython;
	private List<Question> questionsOnHTML;
	private List<Question> questionsOnReact; */
	
	public void addNewSubject(String subject) {
		questionBank.put(subject, new ArrayList<>());	//subject name,question list
	}
	
	public void addNewQuestion(String subject,Question question) {
		List<Question> questions = questionBank.get(subject);	//fetched the list of questions related to (this) subject
		questions.add(question);	//added (this) question into the list
	}
	
	public List<Question> fetchQuestionsOn(String subject){
		return questionBank.get(subject);	//fetching questions on (this) subject
	}
}
