
package system;


public class User {
    
    private int id,age,height,weight,cnumber,psibling;
    private String fname,mname,lname,gender,status,btype,dob,address,cship,ffname,
                   fmname,flname,ffoccupation,mfname,mmname,mlname,moccupation;
    
    public User(int ID, String FirstName,String LastName,String Address){
        this.id = ID;
        this.fname = FirstName;
        this.lname = LastName;
        this.address = Address;
        
    }
    public int getID(){
        return id;
    }
    public String getFirstName(){
        return fname;
    }
    public String getLastName(){
        return lname;
    }
    public String getAddress(){
        return address;
    }
    
}
