package com.he.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *@function��java�ļ򵥵��׽������ӣ������ӣ�����һ���Ե��շ���ע�Ͳ��ֿ���ͨ������̨���������ַ�
 *@parameter:
 *@return��
 *@date��2016-6-22 ����03:41:07
 *@author:he
 *@notice:
 */
public class ScoketTest {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.println("������Ϣ");
			os.flush();

			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = is.readLine();
			System.out.println("�ͻ����յ���" + msg);

			os.close();
			socket.close(); 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("+++++�ͻ��˷����쳣+++++");
		}
	}
	// public static void main(String[] args) {
	// try {
	// Socket socket = new Socket("127.0.0.1", 8888);
	//
	// //��ϵͳ��׼�����豸����BufferedReader����
	// BufferedReader sin = new BufferedReader(new
	// InputStreamReader(System.in));
	//
	// //��Socket����õ��������������PrintWriter���󡡡�������������
	// PrintWriter os = new PrintWriter(socket.getOutputStream());
	//
	// //��Socket����õ�����������������Ӧ��BufferedReader����
	// BufferedReader is = new BufferedReader(new
	// InputStreamReader(socket.getInputStream()));
	//
	// String readline;
	//
	// readline = sin.readLine();
	// //��ϵͳ��׼�������һ�ַ���
	//
	// while (!readline.equals("bye")) {
	// //���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
	//				
	// os.println(readline);
	// //����ϵͳ��׼���������ַ��������Server
	//				
	// os.flush();
	// //ˢ���������ʹServer�����յ����ַ���
	//
	// System.out.println("Client:" + readline);
	// //��ϵͳ��׼����ϴ�ӡ������ַ���
	//
	// System.out.println("Server:" + is.readLine());
	// //��Server����һ�ַ���������ӡ����׼�����
	//
	// readline = sin.readLine();
	// //��ϵͳ��׼�������һ�ַ���
	// }
	// //����ѭ��
	//
	// os.close(); //�ر�Socket�����
	//
	// is.close(); //�ر�Socket������
	//
	// socket.close(); //�ر�Socket
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// System.out.println("+++++�ͻ��˷����쳣+++++");
	// }
	// }
}
