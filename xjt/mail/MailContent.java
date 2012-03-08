/**
 * @author xjt
 */
package xjt.mail;

/**
 * 邮件类
 */
public class MailContent {
	/**
	 * 邮件标题
	 */
	private String title = null;
	/**
	 * 邮件内容
	 */
	private String content = null;
	/**
	 * 邮件附件路径
	 */
	private String[] fileNames = null;

	/**
	 * 构造邮件类的方法
	 * @param
	 * 		title   邮件标题
	 * @param
	 * 		content   邮件内容
	 * @param
	 * 		fileNames   邮件附件的路径
	 */
	public MailContent(String title, String content, String[] fileNames) {
		super();
		this.title = title;
		this.content = content;
		this.fileNames = fileNames;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

}
