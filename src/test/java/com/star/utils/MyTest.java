package com.star.utils;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public class MyTest {

	/**
	 * 根据虚拟机类型生成随机Mac地址
	 * 
	 * @param hypervType
	 *            虚拟机类型 KVM: QEMU虚拟机 vmware: Vmware虚拟机 其他： 生成随机的Mac地址
	 * @return
	 */
	private String createRandomMacAddress(String hypervType) {
		String macAddress = null;
		if ("QEMU".equalsIgnoreCase(hypervType)) {// 根据不同的虚拟化类型生成前缀
			String prefix = "ch:54:00";
			macAddress = prefix.concat(":").concat(getRandChars(3));
		} else {
			macAddress = getRandChars(6);
		}
		return macAddress;
	}

	/**
	 * 生成 2个随机的小写字母或者数字组成的串
	 * 
	 * @return
	 */
	private static String getRandChars(int len) {
		String multiChars = "";
		for (int i = 0; i < len; i++) {
			multiChars = multiChars.concat(":");
			String chars = getRandTwoChars();
			multiChars = multiChars.concat(chars);
		}
		if (len > 0) {
			multiChars = multiChars.substring(1);
		}
		return multiChars;
	}

	/**
	 * 生成2个随机的小写字母或者数字
	 * 
	 * @return
	 */
	private static String getRandTwoChars() {
		String chars = createRandomChar();
		return chars.concat(createRandomChar());
	}

	/**
	 * 生成随机的小写字母或者数字
	 * 
	 * @return 随机的小写字母或者数字
	 */
	private static String createRandomChar() {
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "0", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", };
		Random rand = new Random();
		int rInt = rand.nextInt(chars.length);
		return chars[rInt];
	}

	public static void main(String[] args) {
		//String mac = new MyTest().createRandomMacAddress("");
		//System.out.println(mac);
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(cal.getTimeInMillis() - TimeZone.getDefault().getRawOffset());
		System.out.println(cal.getTime());
		
	}

}
