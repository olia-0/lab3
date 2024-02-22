package org.example;/*
  @author   Olha
  @project   lab3
  @class  ICompanyService
  @version  1.0.0 
  @since 22.02.2024 - 22.26
*/


import java.util.List;

public interface ICompanyService {
    Company getTopLevelParent(Company child);

    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}
