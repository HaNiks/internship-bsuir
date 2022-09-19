package by.internship.han.task2_5_14;

import java.util.*;

public class Domain {

    private String address;

    private int compareTo(Domain domain) {
        return this.address.compareTo(domain.address);
    }

    public static String reverseDomain(String s) {
        String[] arr = s.split("\\.");
        Collections.reverse(Arrays.asList(arr));
        return String.join(".", arr);
    }

    public List<Domain> getListDomains() {
        Scanner scanner = new Scanner(System.in);
        List<Domain> domains = new ArrayList<>();
        System.out.println("Введите имя домена. Для выхода введите '/'");
        String s = scanner.nextLine();
        while (!s.equals("/")) {
            Domain domain = new Domain();
            domain.address = reverseDomain(s);
            domains.add(domain);
            s = scanner.nextLine();
        }
        return domains;
    }

    public List<Domain> getSortedDomains(List<Domain> domains) {
        domains.sort(Domain::compareTo);
        return domains;
    }

    @Override
    public String toString() {
        return address;
    }
}