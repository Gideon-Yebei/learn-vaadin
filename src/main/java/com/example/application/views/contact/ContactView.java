package com.example.application.views.contact;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contact")
@Route(value = "contact", layout = MainLayout.class)
public class ContactView extends VerticalLayout {

	public ContactView() {
		setSpacing(false);

		H2 contact = new H2("Contact Me");
		contact.getStyle().set("margin", "0");
		contact.getStyle().set("font-size", "50px");
		contact.getStyle().set("color", "var(--lumo-success-color)");

		TextField firstName = new TextField("First Name");
		firstName.getStyle().set("width", "100%");
		TextField lastName = new TextField("Last Name");
		lastName.getStyle().set("width", "100%");
		TextField email = new TextField("Email");
		email.getStyle().set("width", "100%");
		TextField subject = new TextField("Subject");
		subject.getStyle().set("width", "100%");
		TextArea messageArea = new TextArea("Message");
		messageArea.getStyle().set("width", "100%");
		messageArea.getStyle().set("height", "400px");
		Button submit = new Button("Submit");
		//<theme-editor-local-classname>
		submit.addClassName("contact-view-button-1");

		HorizontalLayout contactName = new HorizontalLayout(firstName, lastName);
		contactName.getStyle().set("width", "100%");
		add(contact, contactName, email, messageArea, submit);

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");
	}

}
