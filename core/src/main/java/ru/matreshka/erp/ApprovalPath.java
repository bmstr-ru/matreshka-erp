package ru.matreshka.erp;

// Путь документа
class ApprovalPath {
    private List<ApprovalEntity> approvalEntities;
    private LocalDateTime deadline;

    public ApprovalPath(LocalDateTime deadline) {
        this.approvalEntities = new ArrayList<>();
        this.deadline = deadline;
    }

    public void create() {
        System.out.println("ApprovalPath created");
    }

    public void send() {
        System.out.println("ApprovalPath sent");
    }

    public void addApprovalEntity(ApprovalEntity approvalEntity) {
        this.approvalEntities.add(approvalEntity);
        System.out.println("Approval entity added to path");
    }
}