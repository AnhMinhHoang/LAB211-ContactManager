/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import common.Validation;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Contact;

/**
 *
 * @author GoldCandy
 */
public class ContactDao implements Comparator<Contact> {

    private static ContactDao instance = null;
    private Validation valid = new Validation();

    public static ContactDao Instance() {
        if (instance == null) {
            synchronized (ContactDao.class) {
                if (instance == null) {
                    instance = new ContactDao();
                }
            }
        }
        return instance;
    }

    private int findID(List<Contact> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getiD() != i + 1) {
                return i + 1;
            }
        }
        return list.size() + 1;
    }

    public void addContact(List<Contact> list, Contact contact) {
        contact.setFullName(valid.checkName("Enter Name"));
        String[] str = contact.getFullName().split(" ");
        contact.setFirstName(str[0]);
        contact.setLastName(contact.getFullName().substring(contact.getFullName().indexOf(" ")).trim());
        contact.setiD(findID(list));
        contact.setGroup(valid.inputString("Enter Group"));
        contact.setAddress(valid.inputString("Address"));
        contact.setPhone(valid.phoneMatch("Enter Phone"));
        list.add(contact);
        System.out.println("Successful");
    }

    public void displayAll(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("Empty list...");
            return;
        }
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name",
                "First name", "Last name",
                "Group", "Address", "Phone");
        Collections.sort(list, new ContactDao());
        for (Contact contact : list) {
            System.out.println(contact.toString());
        }
    }

    public void deleteContact(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("Empty list...");
            return;
        }
        int iD = valid.inputInt("Enter ID");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getiD() == iD) {
                list.remove(i);
                System.out.println("Successful");
                return;
            }
        }
        System.out.println("Not found!");
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        if (o1.getiD() > o2.getiD()) {
            return 1;
        }
        if (o1.getiD() < o2.getiD()) {
            return -1;
        }
        return 0;
    }
}
