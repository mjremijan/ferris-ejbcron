package org.ferris.timerservice.config;

import javax.enterprise.inject.Vetoed;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Vetoed
@XmlRootElement(name = "Command")
public class Command {
    
    @XmlElement(name = "Executable")
    public String executable;
    
    @XmlElement(name = "Arguments")
    public Arguments arguments;
}
