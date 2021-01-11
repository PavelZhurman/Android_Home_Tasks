package by.it.academy.app4_1task

class Contact(contactImage: Int, contactName: String, contactEmailOrPhoneNumber: String) {

    private var image = contactImage
    private var name = contactName
    private var emailOrPhoneNumber = contactEmailOrPhoneNumber


    fun getImage(): Int {
        return image
    }

    fun getName(): String {
        return name
    }

    fun getEmailOrPhone(): String {
        return emailOrPhoneNumber
    }


    object ContactListManager {
        private val listOfContacts = mutableListOf<Contact>()

        fun addContactToList(contact: Contact) {
            listOfContacts.add(contact)
        }

        fun editContactInList(index: Int, contact: Contact) {
            listOfContacts[index] = contact
        }

        fun deleteContactFromList(index: Int) {
            listOfContacts.removeAt(index)
        }

        fun getListOfContacts(): List<Contact> {
            return listOfContacts
        }

    }

}