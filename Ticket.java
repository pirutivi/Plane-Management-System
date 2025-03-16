import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Task 8
public class Ticket {
    private char row;
    private int seat;
    private int price;
    private Person person;

    //Constructor
    public Ticket(char row, int seat, int price, Person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person=person;
    }

    //Getters and setters
    public char getRow(){
        return row;
    }

    public void setRow(char row){
        this.row = row;
    }

    public int getSeat(){
        return seat;
    }

    public void setSeat(int seat){
        this.seat = seat;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person){
        this.person=person;
    }

    // Printing information of the ticket
    public void printTicketInfo(){
        System.out.println("Ticket Information:");
        System.out.println("The row is:"+row);
        System.out.println("The seat is:"+seat);
        System.out.println("The cost is:"+price);
        System.out.println("Person Information:");
        person.printInfo();
    }

    //Task 12
    public void save(){
        String fileName = row + "" + seat + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            writer.println("Ticket Information:");
            writer.println("The row is:"+row);
            writer.println("The seat is:"+seat);
            writer.println("The cost is:"+price);
            writer.println("Person Information:");
            writer.println("Person's name is:"+person.getName());
            writer.println("Person's surname is:"+person.getSurname());
            writer.println("Person's Email is:"+person.getEmail());
            System.out.println("Ticket information saved to file:"+fileName);
        }catch (IOException e){
            System.out.println("Can't save ticket information to file:"+fileName);
        }
    }
}
