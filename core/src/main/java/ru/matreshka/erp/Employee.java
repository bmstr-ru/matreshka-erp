package ru.matreshka.erp;

// Создание пользователей
class Employee {
    private Long id;
    private String name;
    private Date birthDate;
    private String jobTitle;
    private String comments;
    private Boolean active;
    private List<Grant> grants;

    public Employee(Long id, String name, Date birthDate, String jobTitle, String comments, Boolean active) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.jobTitle = jobTitle;
        this.comments = comments;
        this.active = active;
        this.grants = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void create() {
        System.out.println("Employee created: " + this.name);
    }

    public void fire() {
        this.active = false;
        System.out.println("Employee fired: " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void addGrant(Grant grant) {
        this.grants.add(grant);
        System.out.println("Grant added to employee " + this.name + ": " + grant.getDescription());
    }

    public void removeGrant(Grant grant) {
        this.grants.remove(grant);
        System.out.println("Grant removed from employee " + this.name + ": " + grant.getDescription());
    }
}