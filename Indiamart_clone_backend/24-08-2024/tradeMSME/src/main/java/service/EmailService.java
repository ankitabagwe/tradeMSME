package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	 public void sendOtpEmail(String toEmail, String otp) throws MessagingException {
	        String subject = "tradeMSME OTP-" + otp;

	        String emailContent = "<html>" +
	                "<body style='font-family: Arial, sans-serif;'>" +
	                "<h2 style='color: #d9534f;'>tradeMSME</h2>" +
	                "<p><b>Dear tradeMSME User,</b></p>" +
	                "<p>Greetings from tradeMSME!</p>" +
	                "<p>tradeMSME employees never ask for OTP. Sharing it with anyone allows unauthorized access to your tradeMSME account.</p>" +
	                "<p style='font-size: 18px; font-weight: bold;'>Your OTP is <span style='color: #d9534f;'>" + otp + "</span>. Do not share with anyone.</p>" +
	                "<p>We received this request through your email address: <b>" + toEmail + "</b></p>" +
	                "<p><b>Warm Regards,</b><br>Team tradeMSME</p>" +
	                "</body></html>";

	        // Create a MIME message
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom("your-email@gmail.com"); // Change to your sender email
	        helper.setTo(toEmail);
	        helper.setSubject(subject);
	        helper.setText(emailContent, true); // Set to HTML format

	        // Send email
	        mailSender.send(message);
	    }
}
