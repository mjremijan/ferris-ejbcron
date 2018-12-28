package org.ferris.ejbcron;

import java.util.LinkedList;
import org.junit.Test;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ProcessBuilderTest {

    @Test
    public void testProcessBuilder() throws Exception {
        LinkedList<String> cmd
            = new LinkedList<>();

        cmd.add("C:\\Windows\\System32\\cmd.exe");
        cmd.add("/K");
        cmd.add("start \"Dashboard\" /B \"%ALLUSERSPROFILE%\\Microsoft\\AppV\\Client\\Integration\\B1825454-D96F-433D-912E-D26A4BF367A5\\Root\\Chrome\\Application\\chrome.exe\" --profile-directory=Default --new-window \"https://www.linkedin.com\"");
        
        
        System.out.printf("Create ProcessBuilder%n");
        ProcessBuilder pb
            = new ProcessBuilder(cmd);

        System.out.printf("Start Process%n");

        Process p = pb.start();
        
        System.out.printf("DONE 1%n");

    }
}
