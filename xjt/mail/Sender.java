/**
 * @author xjt
 */
package xjt.mail;

/**
 * 发件人
 */
public class Sender {
	/**
	 * 发件人的服务器地址
	 */
	private String serverName = null;
	/**
	 * 发件人的用户名
	 */
	private String userName = null;
	/**
	 * 发件人的邮件密码
	 */
	private String password = null;
	/**
	 * 发件人的邮箱地址
	 */
	private String fromName = null;

	/**
	 * 构造发件人的方法
	 * @param
	 * 		serverName   服务器地址
	 * @param
	 * 		userName   用户名
	 * @param
	 * 		password   密码
	 * @param
	 * 		fromName   发件人的邮箱地址
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
