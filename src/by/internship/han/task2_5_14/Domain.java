package by.internship.han.task2_5_14;

import java.util.*;

public class Domain {

    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public int compareTo(Domain domain) {
        return this.address.compareTo(domain.address);
    }

    public static String reverseDomain(String s) {
        String[] arr = s.split("\\.");
        Collections.reverse(Arrays.asList(arr));
        return String.join(".", arr);
    }

    @Override
    public String toString() {
        return address;
    }
}