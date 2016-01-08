package org.michael.demo.util;

//�������ݵĲ�����    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputData {
	private BufferedReader buf = null;

	public InputData() {
		buf = new BufferedReader(new InputStreamReader(System.in));
	}

	public int getInt() {
		int temp = 0;
		// �������Ĳ������֣�����Ӧ����һ����ʾ�������û��������
		// ����ʹ��������֤
		String str = null;
		boolean flag = true;
		while (flag) {
			// ��������
			str = this.getString();
			if (!(str.matches("\\d+"))) {
				// �������һ�����֣��������������
				System.out.print("��������ݣ����������������������룺");
			} else {
				// ��һ����ȷ�����֣�����Խ���ת��
				temp = Integer.parseInt(str);
				// ��ʾ�˳�ѭ��
				flag = false;
			}
		}
		return temp;
	}

	public String getString() {
		String str = null;
		try {
			str = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public float getFloat() {
		float f = 0.0f;
		String str = null;
		boolean flag = true;
		while (flag) {
			// ��������
			str = this.getString();
			if (!(str.matches("\\d+.?\\d{1,2}"))) {
				// �������һ�����֣��������������
				System.out.print("��������ݣ�������С����С�����ֻ����λ�������������룺");
			} else {
				// ��һ����ȷ�����֣�����Խ���ת��
				f = Float.parseFloat(str);
				// ��ʾ�˳�ѭ��
				flag = false;
			}
		}
		return f;
	}
}
