package org.example;/*
  @author   Olha
  @project   lab3
  @class  CompanyServiceImpl
  @version  1.0.0 
  @since 22.02.2024 - 22.28
*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
        if(child == null)
           return null;
        else if (child.getParent() == null)
            return child;
        else
            return child.getParent();
    }


    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null || companies.isEmpty())
            return 0;

        long count = 0;
        Map<Company, Long> employeeCountCache = new HashMap<>();
        for (Company comp : companies) {
            employeeCountCache.put(comp, comp.getEmployeeCount());
        }

        count += company.getEmployeeCount();

        for (Company child : employeeCountCache.keySet()) {
            if (child.getParent() == company) {
                count += getEmployeeCountForCompanyAndChildren(child, companies);
            }
        }

        return count;
    }
}
