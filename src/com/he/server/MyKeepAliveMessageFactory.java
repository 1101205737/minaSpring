package com.he.server;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class MyKeepAliveMessageFactory implements  KeepAliveMessageFactory{
	
	private final Logger LOG = Logger.getLogger(MyKeepAliveMessageFactory.class);
	
    /** ���������� */  
    private static final String HEARTBEATREQUEST = "1111";  
    private static final String HEARTBEATRESPONSE = "1112"; 

	public Object getRequest(IoSession session) {
		LOG.warn("����Ԥ����Ϣ: " + HEARTBEATREQUEST);  
         /** ����Ԥ����� */  
         return HEARTBEATREQUEST;
	}

	public Object getResponse(IoSession session, Object request) {
		LOG.warn("��ӦԤ����Ϣ: " + HEARTBEATRESPONSE);  
        /** ����Ԥ����� */  
        return HEARTBEATRESPONSE;  
//      return null;  
	}

	public boolean isRequest(IoSession session, Object message) {
		 LOG.warn("������������Ϣ: " + message);  
         if (message.equals(HEARTBEATREQUEST))  
             return true;  
         return false;  
	}

	public boolean isResponse(IoSession session, Object message) {
      LOG.warn("��Ӧ��������Ϣ: " + message);  
      if(message.equals(HEARTBEATRESPONSE))  
          return true;
		return false;
	}

}
