package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
  @author   Olha
  @project   lab3
  @class  CompanyServiceImplTest
  @version  1.0.0 
  @since 22.02.2024 - 22.29
*/


class CompanyServiceImplTest {
    private final Company main = new Company(null, 2);
    private final Company development = new Company(main, 5);
    private final Company marketing = new Company(null, 7);
    private final Company frontend = new Company(development, 3);
    private final Company backend = new Company(development, 0);



    private final ICompanyService companyService = new CompanyServiceImpl();



    @Test
    void whenCompanyIsNullThenNull() {
        assertNull(companyService.getTopLevelParent(null));
    }
    @Test
    void whenCompanyHasNoParentItIsOnTop() {
        assertEquals(main,companyService.getTopLevelParent(main));
    }
    @Test
    void whenCompanyHasOneParentItIsOnTop() {
        assertEquals(main,companyService.getTopLevelParent(development));
    }
    @Test
    void whenCompanyHasTwoParentsItIsOnTop() {
        assertEquals(main,companyService.getTopLevelParent(main));
    }
    @Test
    void whenCompanyIsSingleItIsOnTop() {
        assertEquals(marketing,companyService.getTopLevelParent(marketing));
    }

    private final List<Company> departments = List.of(main, development, marketing, frontend, backend);


    @Test
    void whenEmployeeCountForMainCompanyThen10() {
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(main, departments);
        assertEquals(10, totalEmployeeCount);
    }

    @Test
    void whenEmployeeCountForDevelopmentCompanyThen8() {
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(development, departments);
        assertEquals(8, totalEmployeeCount);
    }

    @Test
    void whenEmployeeCountForMarketingCompanyThen7() {
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(marketing, departments);
        assertEquals(7, totalEmployeeCount);
    }

    @Test
    void whenEmployeeCountForFrontendCompanyThen3() {
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(frontend, departments);
        assertEquals(3, totalEmployeeCount);
    }

    @Test
    void whenEmployeeCountForBackendCompanyThen0() {
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(backend, departments);
        assertEquals(0, totalEmployeeCount);
    }
    @Test
    void whenEmployeeCountForNullThen0() {
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(null, departments);
        assertEquals(0, totalEmployeeCount);
    }
    @Test
    void whenEmployeeCountForEmptyListThen0() {
        List<Company> emptyDepartments = List.of();
        long totalEmployeeCount = companyService.getEmployeeCountForCompanyAndChildren(main, emptyDepartments);
        assertEquals(0, totalEmployeeCount);
    }

}