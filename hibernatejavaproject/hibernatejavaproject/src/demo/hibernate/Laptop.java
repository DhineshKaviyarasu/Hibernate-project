package demo.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Laptop {
   @Id
    private int lapId;
   private String lapName;
   @ManyToOne
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lapId=" + lapId +
                ", lapName='" + lapName + '\'' +
                ", student=" + student +
                '}';
    }


    public Laptop(int lapId, String lapName,Student student) {
        this.lapId = lapId;
        this.lapName = lapName;
        this.student = student;
    }

    public int getLapId() {
        return lapId;
    }

    public void setLapId(int lapId) {
        this.lapId = lapId;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }
}
