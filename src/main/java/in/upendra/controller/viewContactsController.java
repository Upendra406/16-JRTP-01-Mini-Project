package in.upendra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.upendra.entity.Contact;
import in.upendra.service.ContactService;

@Controller
public class viewContactsController {

	@Autowired
	private ContactService service;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contact = service.getContactById(contactId);

		model.addAttribute("contact", contact);
		return "contactInfo";

	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model) {
		service.deleteContactById(contactId);

		return "redirect:viewContacts";

	}

}
