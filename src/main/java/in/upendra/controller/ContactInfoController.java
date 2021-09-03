package in.upendra.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.upendra.entity.Contact;
import in.upendra.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "contactInfo";
	}

	@PostMapping("/saveContact")
	public String saveContact(Contact contact, Model model) {
		boolean isSaved = contactService.saveContact(contact);

		if (isSaved) {
			model.addAttribute("success", "Contact Saved Successfully");
		} else {
			model.addAttribute("error", "Failed To Save Contact");
		}
		return "contactInfo";
	}

	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
		List<Contact> allContacts = contactService.getAllContacts();

		model.addAttribute("contacts", allContacts);

		return "contacts";
	}

}
