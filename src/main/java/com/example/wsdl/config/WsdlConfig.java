package com.example.wsdl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsdlConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.wsdl");
        return marshaller;
    }
    @Bean
    public WsdlClient wsdlClient(Jaxb2Marshaller marshaller) {
        WsdlClient client = new WsdlClient();
        client.setDefaultUri("http://10.34.18.197:9080/SafeSigner/SafeSignerWs");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
