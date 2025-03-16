//Part B
//Task 7
public class Person{
    private String name;
    private String surname;
    private String email;

    //Constructor
    public Person(String name,String surname,String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    //Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    //Information of the person
    public void printInfo() {
        System.out.println("Person's name is:"+name);
        System.out.println("Person's surname is:"+surname);
        System.out.println("Person's Email is:"+email);
    }
}
