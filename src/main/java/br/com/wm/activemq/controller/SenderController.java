package br.com.wm.activemq.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/senders")
public class SenderController {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;
	
	@RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}
