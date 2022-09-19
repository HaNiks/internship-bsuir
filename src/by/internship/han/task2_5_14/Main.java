package by.internship.han.task2_5_14;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Domain domain = new Domain();
        List<Domain> domains = domain.getListDomains();
        domain.getSortedDomains(domains).forEach(System.out::println);
    }
}
