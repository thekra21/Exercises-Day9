package org.example.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@XmlRootElement
public class JobsDto {
 private String Jobs_Title;
 private int Job_id;
 private double min_sal;
 private double max_sal;

    private ArrayList<LinkDto> links = new ArrayList<>();

    public JobsDto() {
    }

    public JobsDto(String jobs_Title, int job_id, double min_sal, double max_sal) {
        Jobs_Title = jobs_Title;
        Job_id = job_id;
        this.min_sal = min_sal;
        this.max_sal = max_sal;
    }
    public JobsDto(ResultSet rs) throws SQLException {
        Jobs_Title = rs.getString("Job_Title");
        Job_id = rs.getInt("Job_id");
        min_sal = rs.getDouble("min_salary");
        max_sal = rs.getDouble("max_salary");

    }

    @XmlElementWrapper
    @XmlElement(name = "link")
    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void addLink(String url, String rel) {
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
    @Override
    public String toString() {
        return "Jobs{" +
                "Jobs_Title='" + Jobs_Title + '\'' +
                ", Job_id=" + Job_id +
                ", min_sal=" + min_sal +
                ", max_sal=" + max_sal +
                '}';
    }

    public String getJobs_Title() {
        return Jobs_Title;
    }

    public void setJobs_Title(String jobs_Title) {
        Jobs_Title = jobs_Title;
    }

    public double getMin_sal() {
        return min_sal;
    }

    public void setMin_sal(double min_sal) {
        this.min_sal = min_sal;
    }

    public int getJob_id() {
        return Job_id;
    }

    public void setJob_id(int job_id) {
        Job_id = job_id;
    }

    public double getMax_sal() {
        return max_sal;
    }

    public void setMax_sal(double max_sal) {
        this.max_sal = max_sal;
    }
}
