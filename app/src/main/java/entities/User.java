package entities;

import java.util.List;

public class User {

    private String name;

    private String password;

    private String hashedPassword;

    private List<Ticket> ticketsBooked;

    private String userId;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void printTickets() {
        for(int i = 0; i < ticketsBooked.size(); i++){
            System.out.println(ticketsBooked.get(i).getTicketId());
        }
    }

    public String getUserId(){
        return userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHashedPasswordPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
