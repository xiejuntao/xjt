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
 * 执行翻译功能的类,要确保程序处于联网状态。
 */
public class TranslationUtil {
	/**
	 * 执行翻译
	 * 
	 * @param string
	 *            要翻译的文本字符串
	 * @param fromSupportLanguage
	 *            原文本字符串的语种，如"zh-CN"表示简体中文语言集
	 * @param toSupportLanguage
	 *            要翻译成的语种，如"en"表示英文语言集
	 * @return 翻译好的文本字符串
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
