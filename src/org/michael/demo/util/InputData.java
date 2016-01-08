package org.michael.demo.util;

//输入数据的操作类    
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
		// 如果输入的不是数字，至少应该有一个提示，告诉用户输入错了
		// 可以使用正则验证
		String str = null;
		boolean flag = true;
		while (flag) {
			// 输入数据
			str = this.getString();
			if (!(str.matches("\\d+"))) {
				// 如果不是一个数字，则必须重新输入
				System.out.print("输入的内容，必须是整数，请重新输入：");
			} else {
				// 是一个正确的数字，则可以进行转换
				temp = Integer.parseInt(str);
				// 表示退出循环
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
			// 输入数据
			str = this.getString();
			if (!(str.matches("\\d+.?\\d{1,2}"))) {
				// 如果不是一个数字，则必须重新输入
				System.out.print("输入的内容，必须是小数（小数点后只到两位），请重新输入：");
			} else {
				// 是一个正确的数字，则可以进行转换
				f = Float.parseFloat(str);
				// 表示退出循环
				flag = false;
			}
		}
		return f;
	}
}
