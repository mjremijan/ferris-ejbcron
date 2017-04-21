package org.ferris.timerservice.config;

import java.util.List;
import javax.enterprise.inject.Vetoed;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Vetoed
@XmlRootElement(name = "Arguments")
public class Arguments {
    
    @XmlElement(name = "Argument")
    public List<String> arguments;
}
