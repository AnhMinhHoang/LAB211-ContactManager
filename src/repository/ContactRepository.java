/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DataAccess.ContactDao;
import java.util.List;
import model.Contact;

/**
 *
 * @author GoldCandy
 */
public class ContactRepository implements IContactRepository {

    @Override
    public void addContact(List<Contact> list, Contact contact) {
        ContactDao.Instance().addContact(list, contact);
    }

    @Override
    public void displayAll(List<Contact> list) {
       ContactDao.Instance().displayAll(list);
    }

    @Override
    public void deleteContact(List<Contact> list) {
        ContactDao.Instance().deleteContact(list);
    }
}
