
/*
 * author: xjt; time: Dec 7, 2008,10:50:33 PM.
 */
package xjt.mail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * 发送邮件的类
 * */
public class MailUtil {
	/**
	 * 发件人
	 * */
	public Sender sender = null;
	/**
	 * 收件人
	 * */
	public Receiver receiver = null;
	/**
	 * 邮件类
	 * */
	public MailContent mailContent = null;
	/**
	 * 构造发送邮件类
	 * @param
	 * 		sender   发件人
	 * @param
	 * 		receiver   收件人
	 * @param
	 * mailContent   邮件内容
	 * */
	public MailUtil(Sender sender, Receiver receiver, MailContent mailContent) {
		this.sender = sender;
		this.receiver = receiver;
		this.mailContent = mailContent;
	}
	/**
	 *发送邮件 
	*/
	public void send(){
		String stmServer = sender.getServerName();
		String protocol = "smtp";
		String username = sender.getUserName();
		String password = sender.getPassword();
		String from = sender.getFromName();
		String to = receiver.getToName();
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol",protocol);
		props.setProperty("mail.host",stmServer);
		props.setProperty("mail.smtp.auth", "true");
		XAuthenticator authenticator = new XAuthenticator(username,password);
		Session session = Session.getInstance(props,authenticator);
		session.setDebug(true);
		MimeMessage mimeMsg = new MimeMessage(session);
		try{
			mimeMsg.setFrom(new InternetAddress(from));
			mimeMsg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			Multipart mp = new MimeMultipart();
			mimeMsg.setSubject(mailContent.getTitle()); 
			BodyPart bp = new MimeBodyPart(); 
			bp.setContent(mailContent.getContent(),"text/html;charset=GB2312"); 
			mp.addBodyPart(bp);
			String [] fileNames = mailContent.getFileNames();
			for(int i=0;i< fileNames.length;i++){
				BodyPart bpp = new MimeBodyPart(); 
				FileDataSource fileds = new FileDataSource(fileNames[i]); 
				bpp.setDataHandler(new DataHandler(fileds)); 
				bpp.setFileName(fileds.getName()); 
				mp.addBodyPart(bpp);
			}
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			Transport.send(mimeMsg);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public class XAuthenticator extends Authenticator {

		String username = null;
		String password = null;
		public XAuthenticator(String username, String password) {
			this.username = username;
			this.password = password;
		}
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username,password);
		}
		
	}
}
