package org.ferris.ejbcron.ejb;

import java.io.IOException;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.ferris.ejbcron.schedule.ScheduleExpressions;

@Startup
@Singleton
public class TimerEjb {

    @Resource
    protected TimerService timerService;
    
    @Inject
    protected Instance<ScheduleExpressions> scheduleExpressionsInstance;
    
    @PostConstruct
    public void initialize() {
        
        System.out.printf("Creating ScheduleExpressions%n");
        ScheduleExpressions expressions
            = scheduleExpressionsInstance.get();
        
        expressions.scheduleExpressions.forEach(se -> {
            System.out.printf("Creating ScheduleExpression%n");
            ScheduleExpression expression 
                = new ScheduleExpression();
            if (!se.second.isEmpty()) {
                expression.second(se.second);
            }
            if (!se.minute.isEmpty()) {
                expression.minute(se.minute);
            }
            if (!se.hour.isEmpty()) {
                expression.hour(se.hour);
            }
            if (!se.month.isEmpty()) {
                expression.month(se.month);
            }
            if (!se.year.isEmpty()) {
                expression.year(se.year);
            }
            
            System.out.printf("Creating command list%n");
            LinkedList<String> strings 
                = new LinkedList<>();
            strings.add(se.command.executable);
            
            if (se.command.arguments != null) {
                if (se.command.arguments.arguments != null) {
                    se.command.arguments.arguments.forEach(arg -> strings.add(arg));
                }
            }
            
            System.out.printf("Creating TimerConfig%n");
            TimerConfig config
                = new TimerConfig();
            config.setInfo(strings);
            
            System.out.printf("CALL #createCalenderTimer%n");
            timerService.createCalendarTimer(expression, config);
        });
    }
    
    @Timeout
    public void timeout(Timer timer) {
        System.out.printf("Getting Timer INFO object%n");
        LinkedList<String> cmd
            = (LinkedList<String>)timer.getInfo();
        
        System.out.printf("Create ProcessBuilder%n");
        ProcessBuilder pb
            = new ProcessBuilder(cmd);

        System.out.printf("Start Process%n");
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
