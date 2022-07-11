package OnlineExamApp;

import java.util.ArrayList;
import java.util.List;

//in a real appication i have to use database
public class QuestionBankLoader {

	public List<Question> loadQuestionsOnJava(){
		QuestionBank qb = new QuestionBank();		
		qb.addNewSubject("Java");
		
		Question q = new Question("What is your name?");	//setting 1st question
		List <Option> ops = new ArrayList<>();			//setting options for this question
		ops.add(new Option("Aniket",true));
		ops.add(new Option("Sanket",false));
		ops.add(new Option("Uttam",false));
		ops.add(new Option("Aashalata",false));
		q.setOptions(ops);
		qb.addNewQuestion("Java", q);
		
		q = new Question("Who is your favorite HERO?");	//setting 2nd question
		ops = new ArrayList<>();			//setting options for this question
		ops.add(new Option("Hritik",false));
		ops.add(new Option("Salman",false));
		ops.add(new Option("Shahrukh",true));
		q.setOptions(ops);
		qb.addNewQuestion("Java", q);
		
		q = new Question("What is your address?");	//setting 3rd question
		ops = new ArrayList<>();			//setting options for this question
		ops.add(new Option("Pune",false));
		ops.add(new Option("Baramati",false));
		ops.add(new Option("Sangavi",true));
		ops.add(new Option("Phaltan",false));
		q.setOptions(ops);
		qb.addNewQuestion("Java", q);
		
		return qb.fetchQuestionsOn("Java");
	}

}
