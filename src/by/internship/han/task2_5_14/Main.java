package by.internship.han.task2_5_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.internship.han.task2_5_14.Domain.reverseDomain;

public class Main {

    public static List<Domain> getSortedDomains(List<Domain> domains) {
        domains.sort(Domain::compareTo);
        return domains;
    }

    public static List<Domain> getListDomains() {
        Scanner scanner = new Scanner(System.in);
        List<Domain> domains = new ArrayList<>();
        System.out.println("Введите имя домена. Для выхода введите '/'");
        String s = scanner.nextLine();
        while (!s.equals("/")) {
            Domain domain = new Domain();
            domain.setAddress(reverseDomain(s));
            domains.add(domain);
            s = scanner.nextLine();
        }
        return domains;
    }

    public static void main(String[] args) {
        List<Domain> domains = getListDomains();
        getSortedDomains(domains).forEach(System.out::println);
    }
}
