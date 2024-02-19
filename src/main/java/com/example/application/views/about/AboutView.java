package com.example.application.views.about;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

	public AboutView() {
		setSpacing(false);

		Image aboutLogo = new Image("images/logo.png", "Gideon");
		aboutLogo.addClassName("about-logo");
		Div aboutImage = new Div(aboutLogo);
		aboutImage.addClassName("about-image");
		H2 intro = new H2("Get To Know Me!");
		intro.addClassName("intro");
		H1 aboutHeader = new H1("About Me");
		aboutHeader.addClassName("header");

		HorizontalLayout cards = getHorizontalLayout();
		cards.addClassName("cards");
		cards.getStyle().set("width", "100%");

		for (int i = 0; i < cards.getComponentCount(); i++) {
			cards.getComponentAt(i).addClassName("card");
		}

		Button letsConnect = new Button("Let's Connect");
		letsConnect.addClassName("connect");
		letsConnect.addClickListener(e -> {
			letsConnect.getUI().ifPresent(ui -> ui.navigate("contact"));
		});

		add(intro, aboutHeader, aboutImage, cards, letsConnect);

		addClassName("about-view");
		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");
	}

	private static HorizontalLayout getHorizontalLayout() {
		Icon briefcase = new Icon(VaadinIcon.BRIEFCASE);
		H2 experienceHeader = new H2("Experience");
		H3 experienceDate = new H3("2019 - Present");
		experienceDate.addClassName("date");

		Div experienceCard = new Div(
				briefcase,
				experienceHeader,
				experienceDate
		);
		Icon education = new Icon(VaadinIcon.BOOK);
		H2 educationHeader = new H2("Education");
		return getHorizontalLayout(education, educationHeader, experienceCard);
	}

	private static HorizontalLayout getHorizontalLayout(Icon education, H2 educationHeader, Div experienceCard) {
		H3 educationDate = new H3("2022 - 2026");
		educationDate.addClassName("date");
		Div educationCard = new Div(
				education,
				educationHeader,
				educationDate
		);
		Icon project = new Icon(VaadinIcon.CODE);
		H2 projectsHeader = new H2("Projects");
		H3 projectsDate = new H3("2020 - Present");
		projectsDate.addClassName("date");
		Div projectsCard = new Div(
				project,
				projectsHeader,
				projectsDate
		);
		return new HorizontalLayout(experienceCard, educationCard, projectsCard);
	}

}
