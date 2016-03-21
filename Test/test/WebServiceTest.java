package test;

import org.junit.Test;

import com.yilv.webservice.client.SendMessageService;
import com.yilv.webservice.client.SendMessageServiceImplService;

public class WebServiceTest {

	// wsimport -s C:\Users\Administrator\Desktop\src -p
	// com.yilv.webservice.client -keep
	// http://localhost:8080/yi_xmpp/services/SendMessageService?wsdl
	@Test
	public void webService() {
		SendMessageService sendMessageService = new SendMessageServiceImplService().getSendMessageServiceImplPort();
		System.out.println(sendMessageService.sendMessage("12wsewqe3").getMessage());
	}
}
