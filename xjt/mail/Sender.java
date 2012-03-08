/**
 * @author xjt
 */
package xjt.mail;

/**
 * ������
 */
public class Sender {
	/**
	 * �����˵ķ�������ַ
	 */
	private String serverName = null;
	/**
	 * �����˵��û���
	 */
	private String userName = null;
	/**
	 * �����˵��ʼ�����
	 */
	private String password = null;
	/**
	 * �����˵������ַ
	 */
	private String fromName = null;

	/**
	 * ���췢���˵ķ���
	 * @param
	 * 		serverName   ��������ַ
	 * @param
	 * 		userName   �û���
	 * @param
	 * 		password   ����
	 * @param
	 * 		fromName   �����˵������ַ
	 */
	public Sender(String serverName, String userName, String password,
			String fromName) {
		super();
		this.serverName = serverName;
		this.userName = userName;
		this.password = password;
		this.fromName = fromName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

}
