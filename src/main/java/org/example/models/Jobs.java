package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Jobs {
 private String job_title;
 private int Job_id;
 private double min_sal;
 private double max_sal;

    public Jobs() {
    }



    public Jobs(String job_title, int job_id, double min_sal, double max_sal) {
        this.job_title = job_title;
        this.Job_id = job_id;
        this.min_sal = min_sal;
        this.max_sal = max_sal;
    }
    public Jobs(ResultSet rs) throws SQLException {

        Job_id = rs.getInt("job_id");
        job_title = rs.getString("job_title");
        min_sal = rs.getDouble("min_salary");
        max_sal = rs.getDouble("max_salary");

    }


    @Override
    public String toString() {
        return "Jobs{" +
                "Jobs_Title='" + job_title + '\'' +
                ", Job_id=" + Job_id +
                ", min_sal=" + min_sal +
                ", max_sal=" + max_sal +
                '}';
    }

    public String getJobs_Title() {
        return job_title;
    }

    public void setJobs_Title(String jobs_Title) {
        job_title = job_title;
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
