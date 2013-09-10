package com.zc.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The Class BaseTools.
 * 
 * @author kim
 */
public class BaseTools {

	/**
	 * 将byte数组转换为对象
	 * 
	 * @param bytes
	 *            字节数组
	 * @return 返回转化成的对象
	 */
	public static Object byteToObject(byte[] bytes) {
		Object obj = null;
		try {
			// bytearray to object
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			obj = oi.readObject();

			bi.close();
			oi.close();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 获取32位唯一ID.
	 * 
	 * @return the uUID
	 */
	public static String getUUID() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 获取全球唯一ID，大于40位.
	 * 
	 * @return the vMID
	 */
	public static String getVMID() {
		return (new java.rmi.dgc.VMID()).toString();
	}

	public static void main(String[] args) {
		/*System.out.println(getVMID());
		System.out.println(getVMID().length());*/
		System.out.println(getUUID());
	}

	/**
	 * 将任一对象转化为byte数组
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return 返回byte数组
	 */
	public static byte[] objectToByte(java.lang.Object obj) {
		byte[] bytes = null;
		try {
			// object to bytearray
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);

			bytes = bo.toByteArray();

			bo.close();
			oo.close();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		}
		return bytes;
	}

}
