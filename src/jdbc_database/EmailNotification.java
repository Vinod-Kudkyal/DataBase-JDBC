package jdbc_database;

import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import java.util.Properties;

public class EmailNotification {
	public static void main(String args[])
	{
		System.out.println("Preparing to send message");
		String message = " Slot Booked Successfully";
		String subject = "Vaccine : Confirmation";
		String to = "vinaymarbe40@gmail.com";
		String from = "vinodkudkyal05@gmail.com";
		sendEmail(message,subject,to,from);
	}
	public static void sendEmail(String message,String subject,String to,String from)
	{
		String host = "smtp.gmail.com";
		Properties p = System.getProperties();
		System.out.println("Properties = "+p);
		p.put("mail.smtp.host", host);
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.auth", "true");
		Session s = Session.getInstance(p, new Authenticator()
				{

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("vinodkudkyal05@gmail.com","txstigpmjthhehpl");
					}
			
				});
		MimeMessage m = new MimeMessage(s);
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			Transport.send(m);
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Completed");
		}
	}
}