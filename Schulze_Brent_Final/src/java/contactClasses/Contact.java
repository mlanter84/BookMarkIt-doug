/*
 * CMIS 440
 * Contact.java
 * Rolodex Database Final
 * 10 OCT 2015
 * Schulze, Brent
 */

package contactClasses;


public class Contact 
{
    private int contact_ID;
    private String nameFirst;
    private String nameLast;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phoneNumber;
    //setters and getters for each database field/column
    public int getContact_ID() 
    {
        return contact_ID;
    }
    public void setContact_ID(int contact_ID) 
    {
        this.contact_ID = contact_ID;
    }
    public String getNameFirst() 
    {
        return nameFirst;
    }
    public void setNameFirst(String nameFirst) 
    {
        this.nameFirst = nameFirst;
    }
    public String getNameLast() 
    {
        return nameLast;
    }
    public void setNameLast(String nameLast) 
    {
        this.nameLast = nameLast;
    }
    public String getAddress() 
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getCity() 
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getState() 
    {
        return state;
    }
    public void setState(String state) 
    {
        this.state = state;
    }
    public String getZipCode() 
    {
        return zipCode;
    }
    public void setZipCode(String zipCode) 
    {
        this.zipCode = zipCode;
    }
    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() 
    {
        return "Contact [contact_ID=" + contact_ID + ", nameFirst=" + nameFirst
                + ", nameLast=" + nameLast + ", address=" + address + ", city=" 
                + city + ", state=" + state + ", zipCode=" + zipCode + ", email="
                + email + ", phoneNumber=" + phoneNumber + "]";
    }    
}
