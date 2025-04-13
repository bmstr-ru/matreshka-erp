// Для теста
        package ru.matreshka.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.matreshka.erp.*;

import java.util.*;
import java.io.File;
import java.time.LocalDateTime;

@SpringBootApplication

public class MatreshkaApplication {
    public static void main(String[] args) {
        // Создание пользователей
        Employee employee1 = new Employee(1L, "Иван Иванович Иванов", new Date(), "Разработчик", "Отличный парень", true);
        Employee employee2 = new Employee(2L, "Петр Петрович Петров", new Date(), "Тестировщик", "Внимательный", true);
        Employee employee3 = new Employee(3L, "Сидор Сидорович Сидоров", new Date(), "Менеджер", "Ответственный", true);

        // Создание прав
        Grant grant1 = new Grant("Чтение");
        Grant grant2 = new Grant("Редактирование");
        Grant grant3 = new Grant("Удаление");

        // Назначение прав пользователям
        employee1.addGrant(grant1);
        employee1.addGrant(grant2);
        employee2.addGrant(grant1);
        employee3.addGrant(grant1);
        employee3.addGrant(grant2);
        employee3.addGrant(grant3);

        // Создание групп пользователей
        EmployeeGroup group1 = new EmployeeGroup("Разработчики");
        EmployeeGroup group2 = new EmployeeGroup("Тестировщики");
        EmployeeGroup group3 = new EmployeeGroup("Менеджеры");

        // Добавление пользователей в группы
        group1.addEmployee(employee1);
        group2.addEmployee(employee2);
        group3.addEmployee(employee3);

        // Назначение прав группам
        group1.addGrant(grant1);
        group1.addGrant(grant2);
        group2.addGrant(grant1);
        group3.addGrant(grant1);
        group3.addGrant(grant2);
        group3.addGrant(grant3);

        // Создание документа
        Document document1 = new Document("Отчет о проделанной работе", "Отчетность");
        document1.create("Текст первого отчета.");

        // Создание новой версии документа
        File file = new File("document.txt");
        document1.createNewVersion(file, "Текст обновленного отчета.");

        // Создание пути утверждения документа
        ApprovalPath approvalPath = new ApprovalPath(LocalDateTime.now().plusDays(7));

        // Создание сущностей утверждения
        ApprovalEntity approvalEntity1 = new ApprovalEntity(employee3, null, LocalDateTime.now().plusDays(3), "Проверить соответствие"); // Для конкретного пользователя
        ApprovalEntity approvalEntity2 = new ApprovalEntity(null, group2, LocalDateTime.now().plusDays(5), "Проверить качество"); // Для группы пользователей

        // Добавление сущностей утверждения в путь
        approvalPath.addApprovalEntity(approvalEntity1);
        approvalPath.addApprovalEntity(approvalEntity2);

        // Отправка документа на утверждение
        document1.sendForApproval(approvalPath);

        // Имитация утверждения/отклонения кароче тещу отколнил или как
        approvalEntity1.approve("Отчет утвержден");
        approvalEntity2.reject("Найдены ошибки");

        // Вывод информации о документе и версиях  ЖУТЬ С ВЕРСИЯМИ - СЛОЖНО - Смотрит Дима
        System.out.println("Document: " + document1.getName());
        for (DocumentVersion version : document1.getVersions()) {
            System.out.println("Version created by: " + version.getCreatedBy().getName());
            System.out.println("Version text: " + version.getText());
            System.out.println("Version creation time: " + version.getCreationTime());
            System.out.println("Version status: " + version.getStatus());
        }
    }
}