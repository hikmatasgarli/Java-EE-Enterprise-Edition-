package hikmat.util;


import hikmat.model.Student;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.List;
import java.util.Properties;

public class Method {
	
	public static void sendMail(String to,String subject,String text) {
		boolean result = false;
		final String username = "orient.testt@gmail.com";
		final String password = "adobeadobe1";

		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");

		Session session = Session.getInstance(props,new javax.mail.Authenticator(){

		});
	}

}
