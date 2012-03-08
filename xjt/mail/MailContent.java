/**
 * @author xjt
 */
package xjt.mail;

/**
 * �ʼ���
 */
public class MailContent {
	/**
	 * �ʼ�����
	 */
	private String title = null;
	/**
	 * �ʼ�����
	 */
	private String content = null;
	/**
	 * �ʼ�����·��
	 */
	private String[] fileNames = null;

	/**
	 * �����ʼ���ķ���
	 * @param
	 * 		title   �ʼ�����
	 * @param
	 * 		content   �ʼ�����
	 * @param
	 * 		fileNames   �ʼ�������·��
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
