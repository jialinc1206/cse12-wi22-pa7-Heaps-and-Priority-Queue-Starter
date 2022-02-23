/**
 * TODO: Add file header
 */
import java.util.HashMap;


/**
 * This class creates a Ticket object to be used as a 
 * node for a priority queue. Contains a static HashMap 
 */
public class Ticket implements Comparable<Ticket>{

    
    public static final String ENVIRONMENT_SETUP = "Environment Setup";
    public static final String DEBUGGING = "Debgugging";
    public static final String CONCEPT_DOUBTS = "Conceptual Doubt";
    public static final String OTHERS = "Others";  
    
    public static final String WAITING = "Waiting";
    public static final String PROCESSING = "Accepted";
    public static final String RESOLVED = "Resolved";
    public static final String DATE_FORMAT = "HH:mm:ss";
    
    public static HashMap<String, Integer> orderMap;
    
    String studentName;
    String ticketType;
    String ticketStatus;
    Long createdAt;
    Long resolvedAt;
    int ticketNumber;
    
    
    public Ticket(String studentName, String ticketType){
        this.studentName = studentName;
        this.ticketType = ticketType;
        this.ticketStatus = WAITING;
    }
    

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setTicketCreated(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setTicketNumber(int ticketNumber){
        this.ticketNumber = ticketNumber;
    }
       
    public void setCreatedAt(Long createdAt){
        this.createdAt = createdAt;
    }

    public void setResolvedAt(Long resolvedAt){
        this.resolvedAt = resolvedAt;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }
      
    public int getTicketNumber(){
        return ticketNumber;
    }
    
    public Long getResolvedAt(){
        return resolvedAt;
    }
    
    public static void setOrderMap(HashMap<String, Integer> orderMap){
        Ticket.orderMap = orderMap;
    }
    
    /**
     * TODO: Method Header
     */
    @Override
    public int compareTo(Ticket other){
        //TODO: Your code

    }
 
    
}