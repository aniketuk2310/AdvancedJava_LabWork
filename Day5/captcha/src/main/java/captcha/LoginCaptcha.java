package captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginCaptcha")
public class LoginCaptcha extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		
		//logic for generating the captcha text
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQURSTUVWXYZ0123456789";
		String captcha = "";
		for(int i=0; i<5; i++) {
			int rno = (int) (Math.random() * str.length());
			captcha += str.charAt(rno);
		}
		
		//now the code for sending the captcha as an image
		
		BufferedImage img = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
		Graphics gr = img.getGraphics();
		
		gr.setColor(Color.RED);
		gr.fillRect(0, 0, 150, 150);
		gr.setColor(Color.YELLOW);
		gr.setFont(new Font("Harrington",Font.BOLD,32));
		gr.drawString(captcha, 25, 35);
		
//		FileOutputStream out1 = new FileOutputStream("myimage.jpg");
		ImageIO.write(img, "jpeg", out);
	}

	
}
