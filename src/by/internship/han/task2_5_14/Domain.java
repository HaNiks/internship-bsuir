package by.internship.han.task2_5_14;

import java.util.*;
import java.util.stream.IntStream;

public class Domain implements StringComparator {

    @Override
    public List<String> compareTo() {
        List<String> domains = new ArrayList<>();
        getListDomains().forEach(s -> domains.add(reverseDomain(s)));
        Collections.sort(domains);
        return domains;
    }

    public String reverseDomain(String s) {
        String[] arr = s.split("\\.");
        IntStream.range(0, arr.length / 2).forEach(i -> {
            String tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        });
        return convertToString(arr);
    }

    public String convertToString(String[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            stringBuilder.append(arr[i]);
            if (i != arr.length - 1) stringBuilder.append(".");
        });
        return stringBuilder.toString();
    }

    public List<String> getListDomains() {
        Scanner scanner = new Scanner(System.in);
        List<String> domains = new ArrayList<>();
        System.out.println("Введите имя домена. Для выхода введите '/'");
        String domain = "";
        while (!domain.equals("/")) {
            domain = scanner.nextLine();
            if (!domain.equals("/")) domains.add(domain);
        }
        return domains;
    }

    public static void main(String[] args) {
        Domain domain = new Domain();
        domain.compareTo().forEach(System.out::println);
    }
}