package com.infosys.mappdemo2.services;

import com.infosys.mappdemo2.beans.Department;

import java.util.List;

public interface DepartmentServicesInterface {

    public void saveDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department findDepartment(int deptId);

}
