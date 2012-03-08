/**
 * @author xjt
 */
package xjt.translation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * ִ�з��빦�ܵ���,Ҫȷ������������״̬��
 */
public class TranslationUtil {
	/**
	 * ִ�з���
	 * 
	 * @param string
	 *            Ҫ������ı��ַ���
	 * @param fromSupportLanguage
	 *            ԭ�ı��ַ��������֣���"zh-CN"��ʾ�����������Լ�
	 * @param toSupportLanguage
	 *            Ҫ����ɵ����֣���"en"��ʾӢ�����Լ�
	 * @return ����õ��ı��ַ���
	 */
	public String translate(String string, String fromSupportLanguage,
			String toSupportLanguage) {

		String str = string.trim();
		HttpURLConnection uc = null;
		try {
			String url = "http://ajax.googleapis.com/ajax/services/language/"
					+ "translate?v=1.0&langpair=" + fromSupportLanguage + "%7C"
					+ toSupportLanguage + "&q="
					+ URLEncoder.encode(str, "UTF-8");

			uc = (HttpURLConnection) (new URL(url.toString())).openConnection();
			InputStream inputStream = uc.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"));
			StringBuilder outputBuilder = new StringBuilder();
			if (inputStream != null) {
				String readStr;
				while ((readStr = reader.readLine()) != null) {
					outputBuilder.append(readStr).append('\n');
				}
			}
			String result = outputBuilder.toString();
			int i = 0;
			for (i = 36; i < result.length(); i++) {
				if (result.charAt(i) == '\"') {
					break;
				}
			}
			String s = result.substring(36, i);
			return s;
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		} finally {
			if (uc != null) {
				uc.disconnect();
				uc = null;
			}
		}
	}
}
