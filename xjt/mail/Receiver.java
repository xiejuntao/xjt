/**
 * @author xjt
 */
package xjt.mail;

/**
 * �ռ���
 */
public class Receiver {
	/**
	 * �����ʼ��ĵ�ַ
	 */
	private String toName = null;

	/**
	 * �����ռ��˵���
	 * @param
	 * 		toName   �����ʼ��ĵ�ַ
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
