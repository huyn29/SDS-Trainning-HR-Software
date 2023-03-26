package DAO;

import Model.Employee;

import java.util.ArrayList;

public interface InterfaceDAO<T> {
    public ArrayList<T>  SelectAll();
    public void Insert(T x);
    public <L> void Delete(L col, L val,int cond);
    public <L> void Update(L col, L val, int id,int cond);
    public <L> ArrayList<T> selectByConditon(L col, L val, int cond);
}
