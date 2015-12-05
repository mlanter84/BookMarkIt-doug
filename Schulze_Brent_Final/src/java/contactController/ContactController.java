/*
 * CMIS 440
 * ContactController.java
 * Rolodex Database Final
 * 12 OCT 2015
 * Schulze, Brent
 */
package contactController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseLogic.contactDBLogic;
import contactClasses.Contact;


//logic controller to edit or delete contacts based on their contact_ID parameter
public class ContactController extends HttpServlet 
{

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/contact.jsp";
    private static String DISPLAY_CONTACT = "/displayContact.jsp";
    private contactDBLogic dbLogic;

    public ContactController() 
    {
        super();
        dbLogic = new contactDBLogic();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete"))
        {
            int contact_ID = Integer.parseInt(request.getParameter("contact_ID"));
            dbLogic.deleteContact(contact_ID);
            forward = DISPLAY_CONTACT;
            request.setAttribute("contacts", dbLogic.getAllContacts());    
        } 
        else if (action.equalsIgnoreCase("edit"))
        {
            forward = INSERT_OR_EDIT;
            int contact_ID = Integer.parseInt(request.getParameter("contact_ID"));
            Contact contact = dbLogic.getContactById(contact_ID);
            request.setAttribute("contact", contact);
        } 
        else if (action.equalsIgnoreCase("displayContact"))
        {
            forward = DISPLAY_CONTACT;
            request.setAttribute("contacts", dbLogic.getAllContacts());
        }
        else
        {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Contact contact = new Contact();
        contact.setNameFirst(request.getParameter("nameFirst"));
        contact.setNameLast(request.getParameter("nameLast"));
        contact.setAddress(request.getParameter("address"));
        contact.setCity(request.getParameter("city"));
        contact.setState(request.getParameter("state"));
        contact.setZipCode(request.getParameter("zipCode"));
        contact.setEmail(request.getParameter("email"));
        contact.setPhoneNumber(request.getParameter("phoneNumber"));
        String contact_ID = request.getParameter("contact_ID");
        if(contact_ID == null || contact_ID.isEmpty())
        {
            dbLogic.addContact(contact);
        }
        else
        {
            contact.setContact_ID(Integer.parseInt(contact_ID));
            dbLogic.updateContact(contact);
        }
        RequestDispatcher view = request.getRequestDispatcher(DISPLAY_CONTACT);
        request.setAttribute("contacts", dbLogic.getAllContacts());
        view.forward(request, response);
    }
}
