
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         
         for (String line : fr.lines())
         {
             LogEntry logEntry = WebLogParser.parseEntry(line);
             records.add(logEntry);
         }
     }
     
     public int countUniqueIPs ()
     {
         ArrayList<String> uniqueIPsList = new ArrayList<String>();
         
         for (LogEntry le : records) {
            String ip = le.getIpAddress();
             
            if(!uniqueIPsList.contains(ip))
            {
                uniqueIPsList.add(ip);
            }
         }
         
         return uniqueIPsList.size();
     }
     
     public void printAllHigherThanNum (int num)
     {
         
         for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
             
            if(statusCode > num)
            {
                System.out.println(le);
            }
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay (String someday)
     {
         ArrayList<String> uniqueIPsOnDay = new ArrayList<String>();
         for (LogEntry le : records) {
            String ip = le.getIpAddress();
             
            if(!uniqueIPsOnDay.contains(ip))
            {
                String date = le.getAccessTime().toString();
                if (date.contains(someday))
                {
                    uniqueIPsOnDay.add(ip);
                }
            }
         }
         return uniqueIPsOnDay;
     }
     
     public int countUniqueIPsInRange (int low, int high)
     {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         int count = 0;
         for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
             
            if(statusCode >= low && statusCode <= high)
            {
                String ip = le.getIpAddress();
                if(!uniqueIPs.contains(ip))
                {   
                    count++;
                    uniqueIPs.add(ip);
                }
            }
         }
         return count;
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
