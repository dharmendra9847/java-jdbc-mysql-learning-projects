package com.crudoperation;
import com.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud {

    //  DEFAULT CONSTRUCTOR
    public Crud(){
        createTable();
    }

    //  TABLE CREATION
    public void createTable(){  // SN USER_NAME PASSWORD  FULL_NAME ADDRESS DEPARTMENT SALARY
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionFactory.getConnection();  //  CONNECTION MANAGE
            String sql = "CREATE TABLE IF NOT EXISTS employee (SN INT AUTO_INCREMENT PRIMARY KEY," +
                    "USERNAME VARCHAR(30) NOT NULL UNIQUE," +
                    "PASSWORD VARCHAR(30)," +
                    "FULLNAME VARCHAR(100)," +
                    "ADDRESS VARCHAR(200)," +
                    "DEPARTMENT VARCHAR(100),"+
                    "SALARY INT);";

            statement = connection.createStatement();
            // statement.executeUpdate(sql);
            statement.execute(sql);
            System.out.println("TABLE CREATED SUCCESSFULLY!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    }

    public void insert(EmployeeDTO employeeDTO){

        Connection connection = null;
        Statement statement = null;


        try{
            String sql = " insert into employee(username, password, fullname, address, department, salary) "+
                    "VALUES ('"+employeeDTO.getUsername()+"','"+employeeDTO.getPassword()+"','"+employeeDTO.getFullname()+"','"+employeeDTO.getAddress()+"','"+employeeDTO.getDepartment()+"','"+employeeDTO.getSalary()+"')";

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println("DATA " + executeUpdate + " INSERTED SUCCESSFULLY!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    //  READ DATA
    public void read(String username, String password){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try{
            String sql = "select * from employee where username='"+username+"' and password='"+password+"'";

            // SQL INJECTION: username='"+username+"' and password='"+password+"'";
            //  "select * from employee where username='dhar@123' and password='anything'OR'1'='1'";
            //                          'dhar@123'                 anything'OR'1'='1

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); // NO DATA

            /*  ONE WAY

            boolean next = resultSet.next();    //  INTERNALLY IT WILL FETCH FIRST ROW AND PUT INSIDE RESULTSET OBJECT

            int sn = resultSet.getInt("SN");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String fullname = resultSet.getString("fullname");
            String address = resultSet.getString("address");
            String department = resultSet.getString("department");
            int salary = resultSet.getInt("salary");

            */
            if (resultSet.next()){
                int getSn = resultSet.getInt("SN");
                String getUsername = resultSet.getString("username");
                String getPassword = resultSet.getString("password");
                String getFullname = resultSet.getString("fullname");
                String getAddress = resultSet.getString("address");
                String getDepartment = resultSet.getString("department");
                int getSalary = resultSet.getInt("salary");

                System.out.println("SN: " + getSn);
                System.out.println("USERNAME: " + getUsername);
                System.out.println("PASSWORD: " + getPassword);
                System.out.println("FULLNAME: " + getFullname);
                System.out.println("ADDRESS: " + getAddress);
                System.out.println("DEPARTMENT: " + getDepartment);
                System.out.println("SALARY: " + getSalary);

                System.out.println("SN: " + getSn + " | " + " USERNAME: " + getUsername + " | "  + " PASSWORD: " + getPassword + " | "  + " FULLNAME: " +
                        getFullname + " | "  + " ADDRESS: " + getAddress + " | "  + " DEPARTMENT: " + getDepartment + " | "  + " SALARY: " + getSalary);


            }else {
                System.out.println("USER NOT FOUND!");
            }

            //  System.out.println("DATA " + resultSet + " INSERTED SUCCESSFULLY!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    }

    //  UPDATE DATA
    public void update(String username, int salary){

        Connection connection = null;
        Statement statement = null;

        try{
            String sql = "update employee set salary = '"+salary+"' where  username = '"+username+"'";


            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);

            System.out.println("DATA " + executeUpdate + " UPDATED SUCCESSFULLY!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    // DELETE DATA
    public void delete(String username){

        Connection connection = null;
        Statement statement = null;

        try{
            String sql = "delete from employee where username = '"+username+"'";

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);

            System.out.println("DATA " + executeUpdate + " DELETED SUCCESSFULLY!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
