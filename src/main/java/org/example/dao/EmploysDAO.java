package org.example.dao;

import org.example.dto.EmployeesFileDto;
import org.example.models.Employs;

import java.sql.*;
import java.util.ArrayList;


public class EmploysDAO {

    private static final String URL ="jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\myproject\\src\\main\\java\\hr.db";
    private static final String SELECT_ALL_EMPLOYS = "select * from employees";
    private static final String SELECT_ONE_EMPLOYEES_JOIN_JOBS = "select * from employees join jobs on employees.job_id = jobs.job_id where employee_id = ?";
    private static final String SELECT_ONE_EMPLOYS = "select * from employees where employee_id = ?";
    private static final String SELECT_BY_HIRE_DATE = "select * from employees where hire_date=?";
    private static final String SELECT_BY_JOB_ID = "select * from employees where job_id=?";
    private static final String INSERT_EMPLOYS = "insert into employees values (?, ?, ?,?,?,?,?,?,?)";
    private static final String UPDATE_EMPLOYS = "update employees set frist_name = ?, last_name = ?,email=? ,phone_number =? ,hire_date=?,job_id=?,salary=?,manager_id=?, department_id=? where employee_id = ?";
    private static final String DELETE_EMPLOYS = "delete from employees where employee_id = ?";


    public void insertEmployees(Employs e) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMPLOYS);
        st.setInt(1, e.getEmployee_id());
        st.setString(2,e.getFirst_name());
        st.setString(3, e.getLast_name());
        st.setString(4, e.getEmail());
        st.setString(5,e.getPhone_number());
        st.setString(6, e.getHire_date());
        st.setInt(7,e.getJob_id());
        st.setDouble(8,e.getSalary());
        st.setInt(9,e.getManger_id());
        st.setInt(10,e.getDepartment_id());
        st.executeUpdate();
    }

    public void updateEmplyees(Employs e) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMPLOYS);
        st.setInt(10, e.getEmployee_id());
        st.setString(1,e.getFirst_name());
        st.setString(2, e.getLast_name());
        st.setString(3, e.getEmail());
        st.setString(4,e.getPhone_number());
        st.setString(5, e.getHire_date());
        st.setInt(6,e.getJob_id());
        st.setDouble(7,e.getSalary());
        st.setInt(8,e.getManger_id());
        st.setInt(9,e.getDepartment_id());
        st.executeUpdate();
    }
    public void deleteEmployees(int employees_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMPLOYS);
        st.setInt(1, employees_id);
        st.executeUpdate();
    }

    public Employs selectEmployees(int emplyee_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMPLOYS);
        PreparedStatement st =conn.prepareStatement(SELECT_ONE_EMPLOYEES_JOIN_JOBS);
        st.setInt(1, emplyee_id);
        ResultSet rs = st.executeQuery();
        return rs.next() ? new Employs(rs) : null;
    }
        public ArrayList<Employs> selectAllEmploys(EmployeesFileDto Fliter) throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);
            PreparedStatement st ;

            if (Fliter.getHire_date() != null) {

                st = conn.prepareStatement(SELECT_BY_HIRE_DATE);
                st.setString(1,Fliter.getHire_date());

            } else if (Fliter.getJob_id() != null) {
                st = conn.prepareStatement(SELECT_BY_JOB_ID);
                st.setInt(1,Fliter.getJob_id());

            }else {
                st = conn.prepareStatement(SELECT_ALL_EMPLOYS);

            }
            ResultSet rs = st.executeQuery();
            ArrayList<Employs> employs = new ArrayList<>();
            while (rs.next()) {
                employs.add(new Employs(rs));
            }

            return employs;
        }


    }




