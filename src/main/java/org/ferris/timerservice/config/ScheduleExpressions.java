package org.ferris.timerservice.config;

import java.util.List;
import javax.enterprise.inject.Vetoed;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Vetoed
@XmlRootElement(name = "ScheduleExpressions")
public class ScheduleExpressions {

    @XmlElement(name = "ScheduleExpression")
    public List<ScheduleExpression> scheduleExpressions;
}
