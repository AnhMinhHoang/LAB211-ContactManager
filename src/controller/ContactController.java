/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.ContactRepository;
import model.Contact;
import view.Menu;

/**
 *
 * @author GoldCandy
 */
public class ContactController extends Menu {

    protected static String[] mc = {"Add a Contact",
        "Display all Contact",
        "Delete a Contact",
        "Exit"};
    protected ContactRepository algorithm;
    protected Contact contact;

    public ContactController() {
        super("========= Contact program =========", mc);
        algorithm = new ContactRepository();
        contact = new Contact();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("-------- Add a Contact --------");
                algorithm.addContact(contact.getList(), new Contact());
                break;
            }
            case 2: {
                System.out.println("----------------------------------------------------- Display all Contact -----------------------------------------------------");
                algorithm.displayAll(contact.getList());
                break;
            }
            case 3: {
                System.out.println("------- Delete a Contact -------");
                algorithm.deleteContact(contact.getList());
                break;
            }
            case 4: {
                System.out.println("END...");
                System.exit(0);
            }
            default: {
                System.err.println("No such choice");
            }
        }
    }

}
