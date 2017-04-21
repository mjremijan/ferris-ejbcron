package org.ferris.timerservice.config;

import java.io.File;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Singleton
public class ScheduleExpressionsProducer {

    @Produces
    public ScheduleExpressions produceScheduleExpressions() {
        try {
            System.out.printf("Creating JAXBContext...%n");
            JAXBContext jaxbContext 
                = JAXBContext.newInstance(ScheduleExpressions.class);
            
            System.out.printf("Creating Unmarshaller...%n");
            Unmarshaller jaxbUnmarshaller 
                = jaxbContext.createUnmarshaller();
            
            String configXml 
                = System.getProperty("ScheduleExpressions_Xml");
            
            System.out.printf("Unmarshalling \"%s\"...%n", configXml);
            ScheduleExpressions expressions
                = (ScheduleExpressions) jaxbUnmarshaller.unmarshal(
                    new File(configXml)
                );
            
            return expressions;
        } catch (JAXBException ex) {
            throw new RuntimeException("Exception unmarshalling the ScheduleExpressions XML configuration document", ex);
        }
    };
}
