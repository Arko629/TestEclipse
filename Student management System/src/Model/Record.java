package Model;

//import java.util.Date;

//The data to be entered
public class Record {
 
	private int roll_no;
	private String name;
	private String mobile;
	private String doj;
	
	// Default Constructor
    public Record() {}

    //Parameterized Constructor
	public Record(int roll_no,String name,String mobile,String doj) {
		this.roll_no=roll_no;
		this.name=name;
		this.mobile=mobile;
		this.doj=doj;
	}
	//Getters and Setters
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	// toString() Method
    // @return
    @Override public String toString()
    {
 
        // Returning the record
        return "Records{"
            + "name=" + name + ", idNumber=" + roll_no
            + ", contactNumber=" + mobile + ", DOJ="+doj+'}';
    }
	
	
	
}
