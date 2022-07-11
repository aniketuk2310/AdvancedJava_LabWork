package OnlineExamApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
	
	int qNo = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//loading all the questions here (of Java)
		QuestionBankLoader qbl = new QuestionBankLoader();
		List <Question> questions = qbl.loadQuestionsOnJava();
		
		//now extracting one question at a time
		
		if( qNo < questions.size()) {
			Question question = questions.get(qNo++);
			
			HttpSession session = request.getSession();
			session.setAttribute("currQue", question);
			
			response.sendRedirect("viewQuestion.jsp");
		}
		else
			response.sendRedirect("viewScore.jsp");
	}

}


// we have to run servlet for changing the question everytime.