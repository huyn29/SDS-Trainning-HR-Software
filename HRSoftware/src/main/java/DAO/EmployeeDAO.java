package DAO;

import Database.JDBCUtil;
import Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements InterfaceDAO<Employee> {
    public static EmployeeDAO getInstance() {
        return new EmployeeDAO();
    }
    @Override
    public ArrayList<Employee> SelectAll() {
        List<Employee> selectList = new ArrayList<>();
        Connection cnt = null;
        try {
            cnt = JDBCUtil.getConnection();
            Statement stmt = cnt.createStatement();
            String SQL = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("empID"),
                        rs.getString("empName"),
                        rs.getString("empPhone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getInt("managerID"),
                        rs.getInt("depID"));
                selectList.add(emp);
            }
            return (ArrayList<Employee>) selectList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }
    @Override
    public <L> ArrayList<Employee> selectByConditon(L col, L val, int cond) {
        List<Employee> selectByCondList = new ArrayList<>();
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            String SQL = "SELECT * FROM employees WHERE "+(String) col+" = ?";
            prst = cnt.prepareStatement(SQL);
            if(cond == 1){
                prst.setString(1, (String) val);
            }else if(cond ==2){
                prst.setInt(1,(Integer) val);
            } else if (cond ==3) {
                prst.setDouble(1,(Double) val);
            } else if (cond ==4) {
                prst.setNull(1,Types.INTEGER);
            }
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("empID"),
                        rs.getString("empName"),
                        rs.getString("empPhone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getInt("managerID"),
                        rs.getInt("depID"));
                selectByCondList.add(emp);
            }
            return (ArrayList<Employee>) selectByCondList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }
    @Override
    public void Insert( Employee emp) {
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            String Sql = "INSERT INTO employees(empName,empPhone,email,salary) VALUES (?,?,?,?)";
            prst = cnt.prepareStatement(Sql);
                prst.setString( 1, emp.getEmpName());
                prst.setString( 2, emp.getEmpPhone());
                prst.setString( 3, emp.getEmail());
                prst.setDouble( 4, emp.getSalary());
            int rs = prst.executeUpdate();
            if(rs != 0){
                System.out.println("Successfully");
            }else {System.out.println("Error");}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            JDBCUtil.closeConnection(cnt);
        }
    }

    @Override
    public <L> void Update(L col, L val, int id,int cond) {
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            String sql = "UPDATE employees SET " + col + " = ? WHERE empID = " + id;
            prst = cnt.prepareStatement(sql);
            if(cond == 1){
                prst.setString(1, (String) val);
            }else if(cond ==2){
                prst.setInt(1,(Integer) val);
            } else if (cond ==3) {
                prst.setDouble(1,(Double) val);
            } else if (cond ==4) {
                prst.setNull(1,Types.INTEGER);
            }
            System.out.println(prst.toString());
            int rs = prst.executeUpdate();
            if(rs != 0){
                System.out.println("Successfully");
            }else {System.out.println("Error");}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }

    @Override
    public <L> void Delete(L col, L val,int cond) {
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            String sql = "DELETE FROM employees WHERE " + col + " = ?";
            prst = cnt.prepareStatement(sql);
            if(cond == 1){
                prst.setString(1, (String) val);
            }else if(cond ==2){
                prst.setInt(1,(Integer) val);
            } else if (cond ==3) {
                prst.setDouble(1,(Double) val);
            }
            int rs = prst.executeUpdate();
            if(rs != 0){
                System.out.println("Successfully");
            }else {System.out.println("Error");}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }
    public static int getNumberDep(String col, String col2,int x){
        int num = 0;
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            //SELECT COUNT(empID) as huyn FROM employees WHERE depID =12 GROUP BY depID;
            String SQL = "SELECT COUNT("+col+") as huyn FROM employees WHERE "+ col2+" = ? GROUP BY "+col2;
            prst = cnt.prepareStatement(SQL);
            prst.setInt(1,x);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                num = rs.getInt("huyn");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
        return num;
    }
}