package DAO;

import Database.JDBCUtil;
import Model.Department;
import Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements InterfaceDAO<Department> {
    public static DepartmentDAO getInstance(){
        return new DepartmentDAO();
    }
    @Override
    public ArrayList<Department> SelectAll() {
        List<Department> selectList = new ArrayList<>();
        Connection cnt = null;
        try {
            cnt = JDBCUtil.getConnection();
            Statement stmt = cnt.createStatement();
            String SQL = "SELECT * FROM departments";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Department dep = new Department(
                        rs.getInt("depID"),
                        rs.getString("depName"),
                        rs.getInt("numberMember"),
                        rs.getInt("depManagerID"));
                selectList.add(dep);
            }
            return (ArrayList<Department>) selectList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }
    @Override
    public <L> ArrayList<Department> selectByConditon(L col, L val, int cond) {
        List<Department> selectByCondList = new ArrayList<>();
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            String SQL = "SELECT * FROM departments WHERE "+(String) col+" = ?";
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
                Department dep = new Department(
                        rs.getInt("depID"),
                        rs.getString("depName"),
                        rs.getInt("numberMember"),
                        rs.getInt("depManagerID"));
                selectByCondList.add(dep);
            }
            return (ArrayList<Department>) selectByCondList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }
    @Override
    public void Insert( Department dept) {
        Connection cnt = null;
        PreparedStatement prst = null;
        try {
            cnt = JDBCUtil.getConnection();
            String sql = "INSERT INTO departments(depID,depName,numberMember) VALUES (?,?,?)";
            prst = cnt.prepareStatement(sql);
                prst.setInt(1, dept.getDepID());
                prst.setString( 2, dept.getDepName());
                prst.setInt( 3, dept.getNumberMember());
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
            String sql = "UPDATE departments SET " + col + " = ? WHERE depID = " + id;
            prst = cnt.prepareStatement(sql);
            if(cond == 1){
                prst.setString(1, (String) val);
            }else if(cond ==2){
                prst.setInt(1,(Integer) val);
            } else if (cond ==3) {
                prst.setDouble(1,(Double) val);
            }else if (cond ==4) {
                prst.setNull(1, Types.VARCHAR);
            }
            int rs = prst.executeUpdate();
            if(rs != 0){
                System.out.println("Successfully");
            }else {System.out.println("Update Error");}
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
            String sql = "DELETE FROM departments WHERE " + col + " = ?";
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
            }else {System.out.println("Delete Error");}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnt);
        }
    }
}
