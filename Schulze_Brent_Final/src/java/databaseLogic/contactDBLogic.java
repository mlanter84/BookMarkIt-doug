/*
 * CMIS 440
 * contactDBLogic.java
 * Rolodex Database Final
 * 13 OCT 2015
 * Schulze, Brent
 */
package databaseLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import contactClasses.Contact;
import databaseConnector.mySqlUTIL;

public class contactDBLogic 
{
    private Connection connection;

    public contactDBLogic() 
    {
        connection = mySqlUTIL.getConnection();
    }
    //add contact method
    public void addContact(Contact contact) 
    {
        try 
        {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into contacts(nameFirst,nameLast,address,city,state,zipCode,email,phoneNumber) values (?, ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, contact.getNameFirst());
            preparedStatement.setString(2, contact.getNameLast());
            preparedStatement.setString(3, contact.getAddress());
            preparedStatement.setString(4, contact.getCity());
            preparedStatement.setString(5, contact.getState());
            preparedStatement.setString(6, contact.getZipCode());
            preparedStatement.setString(7, contact.getEmail());
            preparedStatement.setString(8, contact.getPhoneNumber());
            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    //delete contact method by contact_ID
    public void deleteContact(int contact_ID) 
    {
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from contacts where contact_ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, contact_ID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //edit/update contact method by contact_ID
    public void updateContact(Contact contact) 
    {
        try 
        {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update contacts set nameFirst=?, nameLast=?, address=?, city=?, state=?, zipCode=?, email=?, phoneNumber=?" +
                            "where contact_ID=?");
            // Parameters start with 1
            preparedStatement.setString(1, contact.getNameFirst());
            preparedStatement.setString(2, contact.getNameLast());
            preparedStatement.setString(3, contact.getAddress());
            preparedStatement.setString(4, contact.getCity());
            preparedStatement.setString(5, contact.getState());
            preparedStatement.setString(6, contact.getZipCode());
            preparedStatement.setString(7, contact.getEmail());
            preparedStatement.setString(8, contact.getPhoneNumber());
            preparedStatement.setInt(9, contact.getContact_ID());
            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    //reads and displays all contacts from database
    public List<Contact> getAllContacts() 
    {
        List<Contact> contacts = new ArrayList<Contact>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from contacts");
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setContact_ID(resultSet.getInt("contact_ID"));
                contact.setNameFirst(resultSet.getString("nameFirst"));
                contact.setNameLast(resultSet.getString("nameLast"));
                contact.setAddress(resultSet.getString("address"));
                contact.setCity(resultSet.getString("city"));
                contact.setState(resultSet.getString("state"));
                contact.setZipCode(resultSet.getString("zipCode"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhoneNumber(resultSet.getString("phoneNumber"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }
    //selects contact and determines the contact_ID for that contact
    public Contact getContactById(int contact_ID) 
    {
        Contact contact = new Contact();
        try 
        {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from contacts where contact_ID=?");
            preparedStatement.setInt(1, contact_ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) 
            {
                contact.setContact_ID(resultSet.getInt("contact_ID"));
                contact.setNameFirst(resultSet.getString("nameFirst"));
                contact.setNameLast(resultSet.getString("nameLast"));
                contact.setAddress(resultSet.getString("address"));
                contact.setCity(resultSet.getString("city"));
                contact.setState(resultSet.getString("state"));
                contact.setZipCode(resultSet.getString("zipCode"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return contact;
    }
}
