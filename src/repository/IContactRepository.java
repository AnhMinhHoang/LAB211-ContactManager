/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Contact;

/**
 *
 * @author GoldCandy
 */
public interface IContactRepository {
    public void displayAll(List<Contact> list);
    
    public void deleteContact(List<Contact> list);
    
    public void addContact(List<Contact> list, Contact contact);
}
