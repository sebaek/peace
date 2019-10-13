package com.peace.util;

public class AppUtil {

	public static void close(AutoCloseable... res) {
		try {
			for (AutoCloseable r : res) {
				if (r != null) {
					r.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
