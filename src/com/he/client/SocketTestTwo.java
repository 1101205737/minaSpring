package com.he.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *@function��java�ļ�socket���ӣ������ӣ����������ӷ�������ȡ��Ϣ
 *@parameter:
 *@return��
 *@date��2016-6-22 ����03:43:18
 *@author:he
 *@notice:
 */
public class SocketTestTwo {
	public static final String IP_ADDR = "127.0.0.1";// ��������ַ
	public static final int PORT = 8888;// �������˿ں�
	static String text = null;

	public static void main(String[] args) throws IOException {
		System.out.println("�ͻ�������...");
		Socket socket = null;
		socket = new Socket(IP_ADDR, PORT);
		PrintWriter os = new PrintWriter(socket.getOutputStream());
		os.println("al");
		os.println("two");
		os.flush();
		while (true) {
			try {
				// ����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ں�
				DataInputStream input = new DataInputStream(socket.getInputStream());
				// ��ȡ������������

				byte[] buffer;
				buffer = new byte[input.available()];
				if (buffer.length != 0) {
					System.out.println("length=" + buffer.length);
					// ��ȡ������
					input.read(buffer);
					// ת���ַ���
					String three = new String(buffer);
					System.out.println("����=" + three);
					if (three.equals("1111\n")) {
						System.out.println("���ͷ���������");
						os = new PrintWriter(socket.getOutputStream());
						os.println("1112");
						os.flush();
					}
				}
			} catch (Exception e) {
				System.out.println("�ͻ����쳣:" + e.getMessage());
				os.close();
			}
		}
	}
}
