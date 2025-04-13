package ru.matreshka.erp;

// Вывод версии документа
class DocumentVersion {
    private File file;
    private String text;
    private LocalDateTime creationTime;
    private Employee createdBy;
    private String status;

    public DocumentVersion(File file, String text, Employee createdBy) {
        this.file = file;
        this.text = text;
        this.creationTime = LocalDateTime.now();
        this.createdBy = createdBy;
        this.status = "Создан";
    }

    public File getFile() {
        return file;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        this.status = "Утвержден";
        System.out.println("Document version approved");
    }

    public void sendForApproval() {
        this.status = "На утверждении";
        System.out.println("Document version sent for approval");
    }

    public void setStatus(String status) {
        this.status = status;
    }
}