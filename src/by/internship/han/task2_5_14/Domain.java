package by.internship.han.task2_5_14;

import java.util.*;
import java.util.stream.IntStream;

public class Domain {

    private String address;

    private int compareTo(Domain domain) {
        return this.address.compareTo(domain.address);
    }

    private String reverseDomain(String s) {
        String[] arr = s.split("\\.");
        IntStream.range(0, arr.length / 2).forEach(i -> {
            String tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        });
        return convertToString(arr);
    }

    private String convertToString(String[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            stringBuilder.append(arr[i]);
            if (i != arr.length - 1) stringBuilder.append(".");
        });
        return stringBuilder.toString();
    }

    private List<Domain> getListDomains() {
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

    public List<Domain> getSortedDomains() {
        List<Domain> domains = getListDomains();
        domains.sort(Domain::compareTo);
        return domains;
    }

    @Override
    public String toString() {
        return address;
    }
}