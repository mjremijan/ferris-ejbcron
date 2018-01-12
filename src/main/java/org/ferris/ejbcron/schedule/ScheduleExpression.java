package org.ferris.ejbcron.schedule;

import javax.enterprise.inject.Vetoed;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Vetoed
@XmlRootElement(name = "ScheduleExpression")
public class ScheduleExpression {

    @XmlElement(name = "Second")
    public String second;

    @XmlElement(name = "Minute")
    public String minute;

    @XmlElement(name = "Hour")
    public String hour;

    @XmlElement(name = "Month")
    public String month;

    @XmlElement(name = "Year")
    public String year;

    @XmlElement(name = "Command")
    public Command command;

    @XmlElement(name = "DayOfWeek")
    public String dayOfWeek;

    @XmlElement(name = "DayOfMonth")
    public String dayOfMonth;
}
