/**
@author xjt
*/
package xjt.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ��װIO��
 * */
public class IOUtil{
	/**
	 * ��ӡ������̨
	 *@param
	 * 	   str Ҫ��ӡ���ַ���
	 * */
	public void writeToConsole(String str){
		System.out.println(str);
	}
	/**
	 * �ӿ���̨��ȡ�ַ���
	 * @return
	 *     ��ȡ�����ַ���
	 * */
	public String readFromConsole(){
		String str = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
					br=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr!=null){
				try {
					isr.close();
					isr=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}
	/**
	 * ���ַ���д���ı��ļ���
	 *@param
	 * 	   fileName  �ı��ļ���
	 *@param
	 *     str  �ַ���
	 * */
	public void writeToFile(String fileName,String str){
		File file = new File(fileName);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw!=null){
				fw=null;
			}
		}
	}
	/**
	 * ���ı��ļ��ж�ȡ�ַ���
	 * @param
	 *     fileName  �ı��ļ���
	 * @return
	 *     ��ȡ�����ַ���
	 * */
	public String readFromFile(String fileName){
		StringBuffer str = new StringBuffer();
		File file = new File(fileName);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			while((line=br.readLine())!=null){
				str.append(line);
				str.append("\r\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fileReader!=null){
				try {
					fileReader.close();
					fileReader = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return str.toString();
	}
}
