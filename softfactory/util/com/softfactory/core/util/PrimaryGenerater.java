package com.softfactory.core.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimaryGenerater {

	private static final String SERIAL_NUMBER = "XXXX"; // 流水号格式
	private static PrimaryGenerater primaryGenerater = null;

	private PrimaryGenerater() {
	}

	/**
	 * 取得PrimaryGenerater的单例实现
	 * 
	 * @return
	 */
	public static PrimaryGenerater getInstance() {
		if (primaryGenerater == null) {
			synchronized (PrimaryGenerater.class) {
				if (primaryGenerater == null) {
					primaryGenerater = new PrimaryGenerater();
				}
			}
		}
		return primaryGenerater;
	}

	/**
	 * 生成下一个编号
	 */

	public synchronized String generaterNextNumber(String sno) {
		String id = null;
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String a = null;
		if (sno != null) {
			a = sno.substring(4, 8);
		}
		String b = formatter.format(date).substring(0, 4);
		if (sno == null) {
			id = formatter.format(date) + "0001";
		} else if (!a.equals(b)) {
			id = formatter.format(date) + "0001";

		} else {
			int count = SERIAL_NUMBER.length();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++) {
				sb.append("0");
			}
			DecimalFormat df = new DecimalFormat("0000");
			id = formatter.format(date)
					+ df.format(1 + Integer.parseInt(sno.substring(12, 16)));
		}
		return id;
	}
}