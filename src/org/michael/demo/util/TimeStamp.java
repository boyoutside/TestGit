package org.michael.demo.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class TimeStamp {
	private Calendar calendar = null;
	// 此标记有外部决定
	private String flag = null;

	public TimeStamp() {
		this.calendar = new GregorianCalendar();
	}

	public TimeStamp(String flag) {
		this();
		this.flag = flag;
	}

	public String getTimeStamp() {
		StringBuffer buf = new StringBuffer();
		if (this.flag != null) {
			buf.append(this.flag);
		}
		buf.append(this.addZero(calendar.get(Calendar.YEAR), 4));
		buf.append(this.addZero(calendar.get(Calendar.MONTH) + 1, 2));
		buf.append(this.addZero(calendar.get(Calendar.DAY_OF_MONTH), 2));
		buf.append(this.addZero(calendar.get(Calendar.HOUR_OF_DAY), 2));
		buf.append(this.addZero(calendar.get(Calendar.MINUTE), 2));
		buf.append(this.addZero(calendar.get(Calendar.SECOND), 2));
		buf.append(this.addZero(calendar.get(Calendar.MILLISECOND), 3));
		return buf.toString();
	}

	public String getTimeStampRandom() {
		StringBuffer buf = new StringBuffer();
		Random r = new Random();
		buf.append(this.getTimeStamp());
		buf.append(r.nextInt(10));
		buf.append(r.nextInt(10));
		buf.append(r.nextInt(10));
		return buf.toString();
	}

	// 可以单独设置一个加“0”的操作
	private String addZero(int temp, int len) {
		String str = temp + "";
		while (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}
}
