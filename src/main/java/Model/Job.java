package Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyName;
    private String jobRole;
    private String salary;
    private String location;
    @Column
    private LocalDate postedDate;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setcompanyName(String companyName){
        this.companyName=companyName;
    }
    public String getcompanyName(){
        return companyName;
    }
    public void setjobRole(String jobRole){
            this.jobRole=jobRole;
    }
    public String getjobRole(){
        return jobRole;
    }
    public void setsalary(String salary){
        this.salary=salary;
    }
    public String getsalary(){
        return salary;
    }
    public void setlocation(String location){
        this.location=location;
    }
    public String getlocation(){
        return location;
    }
    public void setpostedDate(LocalDate postedDate){
        this.postedDate=postedDate;
    }
    public LocalDate getpostedDate(){
        return postedDate;
    }


}
