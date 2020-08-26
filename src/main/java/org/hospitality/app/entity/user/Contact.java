package org.hospitality.app.entity.user;

// Author: Thokozile Snono
// Entity: Contact
// Date: 3 July

public class Contact {
    private String email, contactNumber;

    private Contact(Contact.Builder builder){
        this.contactNumber = builder.contactNumber;
        this.email = builder.email;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public String getEmail()
    {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Email ='" + email + '\'' +
                ", Contact number ='" + contactNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String email, contactNumber;

        public Contact.Builder setEmail(String email
        ){
            this.email = email;
            return this;
        }

        public Contact.Builder setContactNumber(String contactNumber)
        {
            this.contactNumber = contactNumber;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }
}