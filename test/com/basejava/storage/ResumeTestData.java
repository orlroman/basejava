package com.basejava.storage;

import com.basejava.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("01", "Roman");
        String[] contacts = new String[] {
                "8-800-555-35-35",
                "testSkype",
                "testMail",
                "testLinkedIn",
                "testGit",
                "testStack",
                "testPage"
        };

        int i = 0;
        for (ContactType contact : ContactType.values()) {
                System.out.println(contact.getTitle() + "" + contacts[i]);
                i++;
        }

        System.out.println();

        TextSection position = new TextSection("Ведущий стажировок и корпоративного обучения" +
                " по Java Web и Enterprise технологиям");
        TextSection personal = new TextSection("Аналитический склад ума, сильная логика, креативность," +
                " инициативность. Пурист кода и архитектуры.");

        System.out.println(SectionType.OBJECTIVE.getTitle() + "\n" + position.getContent() + "\n");
        System.out.println(SectionType.PERSONAL.getTitle() + "\n" + personal.getContent() + "\n");

        List<String> achievementContent = new ArrayList<>();
        achievementContent.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: " +
                "приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов " +
                "на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin " +
                "проект для комплексных DIY смет\n");

        achievementContent.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов." +
                " Более 3500 выпускников.\n");

        achievementContent.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike." +
                " Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");

        Section achievement = new ListSection(achievementContent);

        System.out.println(SectionType.ACHIEVEMENT.getTitle() + "\n" + achievement + "\n");

        List<String> qualificationContent = new ArrayList<>();
        qualificationContent.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n");
        qualificationContent.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce\n");
        qualificationContent.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, " +
                "MySQL, SQLite, MS SQL, HSQLDB\n");

        Section qualification = new ListSection(qualificationContent);

        System.out.println(SectionType.QUALIFICATION.getTitle() + "\n" + qualification + "\n");


        Period expPeriod = new Period(LocalDate.of(2013, 10, 10), LocalDate.now(), "Автор проекта",
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        List<Period> listExpPeriod = new ArrayList<>();
        listExpPeriod.add(expPeriod);
        Organization organization = new Organization("Java Online Projects", "https://javaops.ru/", listExpPeriod);
        System.out.println(SectionType.EXPERIENCE.getTitle() + "\n" + organization + "\n");

        Period eduPeriod = new Period(LocalDate.of(2013, 3, 3),
                LocalDate.of(2013, 5, 3), "",
                "'Functional Programming Principles in Scala' by Martin Odersky.");
        List<Period> listEduPeriod = new ArrayList<>();
        listEduPeriod.add(eduPeriod);
        Organization education = new Organization("Coursera", "coursera.com", listEduPeriod);
        System.out.println(SectionType.EDUCATION.getTitle() + "\n" + education + "\n");

    }
}
