package in.upendra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.upendra.entity.Contact;
import in.upendra.repository.ContactRepository;

public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		return true;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		return contactRepository.getById(contactId);
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		return true;
	}

}
