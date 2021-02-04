package com.example.wsdl.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WsdlClient extends WebServiceGatewaySupport {

    public Object callWebService(Object request) {
        String uri = getWebServiceTemplate().getDefaultUri();
        return getWebServiceTemplate().marshalSendAndReceive(uri, request);
    }
}
