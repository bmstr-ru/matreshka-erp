package ru.matreshka.erp;

// Создание документа
class Document {
    private String name;
    private String category;
    private List<DocumentVersion> versions;

    public Document(String name, String category) {
        this.name = name;
        this.category = category;
        this.versions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<DocumentVersion> getVersions() {
        return versions;
    }

    public void create(String text) {
        System.out.println("Document created: " + this.name);
        createNewVersion(null, text); // Создаем первую версию при создании документа
    }

    public void createNewVersion(File file, String text) {
        // Предположим, что текущий пользователь создает документ
        Employee currentUser = new Employee(4L, "Текущий Пользователь", new Date(), "Неизвестно", "Описание", true);

        DocumentVersion version = new DocumentVersion(file, text, currentUser);
        this.versions.add(version);
        System.out.println("New version created for document " + this.name);
    }

    public void sendForApproval(ApprovalPath approvalPath) {
        System.out.println("Document " + this.name + " sent for approval");
    }
}