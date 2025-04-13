package ru.matreshka.erp;

// Создание прав
class Grant {
    private String description;

    public Grant(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void create() {
        System.out.println("Grant created: " + this.description);
    }

    public void delete() {
        System.out.println("Grant deleted: " + this.description);
    }
}