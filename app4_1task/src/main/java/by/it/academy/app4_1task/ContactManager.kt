package by.it.academy.app4_1task

class ContactManager {
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