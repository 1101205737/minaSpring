package com.he.server;

import java.util.Iterator;

import org.apache.mina.common.IoSession;

/**
 *@function��ģ��Ⱥ�����ڷ���˺Ϳͻ��˶�����֮�󣬿������д˷���Ⱥ����Ϣ
 *@date��2016-9-27 ����03:42:42
 *@author:He.
 *@notice��
 */
public class SendToAllTest {
	public static void main(String[] args) {
		System.out.println(MyHandler.sessions.size());
		for (Iterator iterator = MyHandler.sessions.iterator(); iterator.hasNext();) {
			IoSession session = (IoSession) iterator.next();
			session.write("����ϵͳ��Ϣ");
		}
	}
}
