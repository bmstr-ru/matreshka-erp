package ru.matreshka.erp;

// Утверждение документа
class ApprovalEntity {
    private Employee employee;
    private EmployeeGroup employeeGroup;
    private String status;
    private LocalDateTime deadline;
    private String comment;

    public ApprovalEntity(Employee employee, EmployeeGroup employeeGroup, LocalDateTime deadline, String comment) {
        this.employee = employee;
        this.employeeGroup = employeeGroup;
        this.status = "Ожидает утверждения";
        this.deadline = deadline;
        this.comment = comment;
    }

    public void approve(String comment) {
        this.status = "Утверждено";
        this.comment = comment;
        System.out.println("Document approved by: " + (employee != null ? employee.getName() : employeeGroup.getName()));
    }

    public void reject(String comment) {
        this.status = "Отклонено";
        this.comment = comment;
        System.out.println("Document rejected by: " + (employee != null ? employee.getName() : employeeGroup.getName()));
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getComment() {
        return comment;
    }
}