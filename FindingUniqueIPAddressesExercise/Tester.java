
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer lg = new LogAnalyzer();
        //read logs from file
        lg.readFile("short-test_log");
        //print all logs
        lg.printAll();
    }
    
    public void testUniqueIP() {
        LogAnalyzer lg = new LogAnalyzer();
        //read logs from file
        lg.readFile("short-test_log");
        //print all unqiue ips
        System.out.println("Number of unique addresses is: " + lg.countUniqueIPs ());
    }
    
    public void testAllHigherThanNum() {
        LogAnalyzer lg = new LogAnalyzer();
        //read logs from file
        lg.readFile("weblog1_log");
        
        int num = 400;
        //print all logs that has status code greater than num
        lg.printAllHigherThanNum(num);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer lg = new LogAnalyzer();
        //read logs from file
        lg.readFile("weblog1_log");
        
        String someday = "Mar 24";
        //print all logs that has status code greater than num
        ArrayList<String> uniqueIPsOnDay = lg.uniqueIPVisitsOnDay(someday);
        
        for (String ip : uniqueIPsOnDay) {
             System.out.println(ip);
        }
        System.out.println("Number of unique addresses on this date ("+ someday +") is: " + uniqueIPsOnDay.size());
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer lg = new LogAnalyzer();
        //read logs from file
        lg.readFile("weblog1_log");
        
        int low = 300, high = 399;
        //print all logs that has status code greater than num
        System.out.println("Number of unique addresses in the range of ("+ low + " to " + high +") is: " + lg.countUniqueIPsInRange(low, high));
    }
}
