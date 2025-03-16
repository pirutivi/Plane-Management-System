import java.util.Scanner;

//Task 1
public class PlaneManagement{
    //Cost of seats
    private static final int COST_200 = 200;
    private static final int COST_150 = 150;
    private static final int COST_180 = 180;

    //Number of seats
    private static int[] seatsA = new int[14];
    private static int[] seatsB = new int[12];
    private static int[] seatsC = new int[12];
    private static int[] seatsD = new int[14];

    //Task 9
    private static Ticket[] soldTickets=new Ticket[52];

    //Initializing all seats as available(0).
    static{
        for(int i=0;i<seatsA.length;i++){
            seatsA[i]=0;
            seatsD[i]=0;
        }
        for(int i=0;i<seatsB.length;i++){
            seatsB[i]=0;
            seatsC[i]=0;
        }
    }

    //Displaying sold seats and available seats.
    public static void displaySeats(){
        displaySeatsForRow(seatsA,'A');
        displaySeatsForRow(seatsB,'B');
        displaySeatsForRow(seatsC,'C');
        displaySeatsForRow(seatsD,'D');
    }

    //Displaying sold seats indicated by 'X' and available seats indicated by 'O'.
    private static void displaySeatsForRow(int[] seats,char rowName){
        System.out.print(rowName+" ");
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                System.out.print("X ");
            }else{
                System.out.print("O ");
            }
        }
        System.out.println();
    }

    //Selling a seat
    public static void sellSeat(char row,int column){
        int[] seats;
        switch (row){
            case 'A':
                seats=seatsA;
                break;
            case 'B':
                seats=seatsB;
                break;
            case 'C':
                seats=seatsC;
                break;
            case 'D':
                seats=seatsD;
                break;
            default:
                System.out.println("You have entered an invalid row.");
                return;
        }

        if(column>0 && column<=seats.length && seats[column-1]==0){
            seats[column-1]=1;
            System.out.println("Seat"+row+column+"Sold successfully.");
        }else{
            System.out.println("Invalid seat or seat already sold.");
        }
    }

    //Getting the price of a seat
    private static int getSeatCost(int column){
        if(column>=1 && column<=5){
            return COST_200;
        }else if(column>=6 && column<=9){
            return COST_150;
        }else if(column>=10 && column<=14){
            return COST_180;
        }else{
            return 0;
        }
    }
    //Task 2
    public static void displayMenu(){
        System.out.println("*************************************************");
        System.out.println("*                MENU OPTIONS                   *");
        System.out.println("*************************************************");
        System.out.println("1) Buy a seat");
        System.out.println("2) Cancel a seat");
        System.out.println("3) Find first available seat");
        System.out.println("4) Seating plan");
        System.out.println("5) Print ticket information and total sales");
        System.out.println("6) Search ticket");
        System.out.println("0) Quit");
        System.out.println("*************************************************");
        System.out.print("Please select an option: ");
    }

    public static void main(String[] args){
        System.out.println("Welcome to the Plane Management application");
        Scanner input=new Scanner(System.in);
        int option;
        do{
            displayMenu();
            option=input.nextInt();

            switch(option){
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                case 0:
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Invalid.Please enter any of these number 1,2,3,4,5,6 or 0");
            }
        }while (option!=0);
    }

    //Task 3
    public static void buy_seat(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter row letter (A-D):");
        char row=input.next().toUpperCase().charAt(0);
        System.out.print("Enter seat number(1-14):");
        int column=input.nextInt();

        //Prompt for person's information
        System.out.print("Enter your name:");
        String name=input.next();
        System.out.print("Enter your surname:");
        String surname=input.next();
        System.out.print("Enter your email:");
        String email=input.next();

        Person person=new Person(name,surname,email);
        int price=getSeatCost(column);
        Ticket ticket=new Ticket(row,column,price,person);

        //Marking the seat as sold
        switch (row){
            case 'A':
                seatsA[column-1]=1;
                break;
            case 'B':
                seatsB[column-1]=1;
                break;
            case 'C':
                seatsC[column-1]=1;
                break;
            case 'D':
                seatsD[column-1]=1;
                break;
            default:
                System.out.println("Invalid row.");
                return;
        }

        //Adding the ticket to the array of sold tickets
        for(int i=0;i<soldTickets.length;i++){
            if(soldTickets[i]==null){
                soldTickets[i]=ticket;
                System.out.println("You have purchased the ticket successfully!");
                return;
            }
        }
        //Informing the user,if the array is full.
        System.out.println("No more tickets");
        ticket.save();
        System.out.println("You have purchased the ticket successfully!");
    }

    //Task 4
    public static void cancel_seat(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the row letter (A, B, C, D):");
        char row=input.next().toUpperCase().charAt(0);
        System.out.print("Enter the seat number:");
        int column=input.nextInt();

        //Finding the ticket to be canceled via soldTickets array.
        for(int i=0;i<soldTickets.length;i++){
            Ticket ticket=soldTickets[i];
            if(ticket!=null && ticket.getRow()==row && ticket.getSeat()==column){
                // Removing the ticket from the array list of tickets
                soldTickets[i]=null;
                System.out.println("Ticket "+row+column+" cancelled");
                //Updating the seats
                switch(row){
                    case 'A':
                        seatsA[column-1]=0;
                        break;
                    case 'B':
                        seatsB[column-1]=0;
                        break;
                    case 'C':
                        seatsC[column-1]=0;
                        break;
                    case 'D':
                        seatsD[column-1]=0;
                        break;
                    default:
                        System.out.println("Invalid row.");
                        return;
                }
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    //Task 5
    public static void find_first_available(){
        char[] rowLabels={'A','B','C','D'};
        for (int row=0;row<4;row++){
            char rowName=rowLabels[row];
            int[] seats;
            switch(rowName){
                case 'A':
                    seats=seatsA;
                    break;
                case 'B':
                    seats=seatsB;
                    break;
                case 'C':
                    seats=seatsC;
                    break;
                case 'D':
                    seats=seatsD;
                    break;
                default:
                    System.out.println("Invalid row.");
                    return;
            }

            for(int column=0;column<seats.length;column++){
                if(seats[column]==0){
                    System.out.println("First available seat:"+rowName+(column+1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    //Task 6
    public static void show_seating_plan(){
        System.out.println("Seating Plan:");
        displaySeats();
    }

    //Task 10
    public static void print_tickets_info(){
        int totalSales=0;
        System.out.println("Tickets Sold:");
        for(Ticket ticket:soldTickets){
            if(ticket!=null){
                ticket.printTicketInfo();
                totalSales+=ticket.getPrice();
            }
        }
        System.out.println("Total Sales:£"+totalSales);
    }

    //Task 11
    public static void search_ticket(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the row letter (A,B,C,D):");
        char row=input.next().toUpperCase().charAt(0);
        System.out.print("Enter the seat number:");
        int column=input.nextInt();

        boolean ticketFound=false;
        for(Ticket ticket:soldTickets){
            if(ticket!=null && ticket.getRow()==row && ticket.getSeat()==column){
                ticket.printTicketInfo();
                ticketFound=true;
                break;
            }
        }
        if(!ticketFound){
            System.out.println("This seat is available.");
        }
    }
}










