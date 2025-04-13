package ru.matreshka.erp;

// Создание групп пользователей
class EmployeeGroup {
    private String name;
    private List<Employee> employees;
    private List<Grant> grants;

    public EmployeeGroup(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.grants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void create() {
        System.out.println("EmployeeGroup created: " + this.name);
    }

    public void delete() {
        System.out.println("EmployeeGroup deleted: " + this.name);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        System.out.println("Employee added to group " + this.name + ": " + employee.getName());
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        System.out.println("Employee removed from group " + this.name + ": " + employee.getName());
    }

    public void addGrant(Grant grant) {
        this.grants.add(grant);
        System.out.println("Grant added to group " + this.name + ": " + grant.getDescription());
    }

    public void removeGrant(Grant grant) {
        this.grants.remove(grant);
        System.out.println("Grant removed from group " + this.name + ": " + grant.getDescription());
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}