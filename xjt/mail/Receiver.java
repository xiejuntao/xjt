/**
 * @author xjt
 */
package xjt.mail;

/**
 * 收件人
 */
public class Receiver {
	/**
	 * 接收邮件的地址
	 */
	private String toName = null;

	/**
	 * 构造收件人的类
	 * @param
	 * 		toName   接收邮件的地址
	 */
	public Receiver(String toName) {
		super();
		this.toName = toName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

}
