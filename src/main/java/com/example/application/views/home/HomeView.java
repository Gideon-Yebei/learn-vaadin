package com.example.application.views.home;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

	public HomeView() {
		setSpacing(false);

		H3 hello = new H3("Hello, I'm");
		hello.getStyle().set("margin", "0");
		hello.getStyle().set("font-size", "20px");
		H2 name = new H2("Gideon");
		name.getStyle().set("margin", "0");
		name.getStyle().set("font-size", "50px");
		H3 title = new H3("Software Developer");
		title.addClassName("title");
		title.getStyle().set("margin", "0");
		title.getStyle().set("font-size", "20px");
		title.getStyle().set("style", "font-weight: 100");
		title.getStyle().set("color", "var(--lumo-success-color)");

		Image image = new Image("images/logo.png", "Gideon");
		image.getStyle().set("border-radius", "50% 50% 0 0");
		image.getStyle().set("margin-top", "20px");
		image.getStyle().set("margin-bottom", "20px");
		image.getStyle().set("background", "var(--image-background-gradient)");

		Button DownloadCV = new Button("Download CV");
		DownloadCV.getStyle().set("margin-top", "20px");
		DownloadCV.getStyle().set("margin-bottom", "20px");
		DownloadCV.getStyle().set("background-color", "transparent");
		DownloadCV.getStyle().set("color", "var(--light-blue-color)");
		DownloadCV.getStyle().set("border-radius", "5px");
		DownloadCV.getStyle().set("border", "2px solid var(--blue-border-color)");
		DownloadCV.getStyle().set("padding", "10px 20px");
		DownloadCV.getStyle().set("font-size", "20px");
		DownloadCV.getStyle().set("color", "var(--lumo-success-color)");
		DownloadCV.getStyle().set("cursor", "pointer");

		Button ContactMe = new Button("Contact Me");
		ContactMe.getStyle().set("margin-top", "20px");
		ContactMe.getStyle().set("margin-bottom", "20px");
		ContactMe.getStyle().set("background-color", "var(--light-blue-color)");
		ContactMe.getStyle().set("color", "var(--lumo-base-color)");
		ContactMe.getStyle().set("border-radius", "5px");
		ContactMe.getStyle().set("border", "none");
		ContactMe.getStyle().set("padding", "10px 20px");
		ContactMe.getStyle().set("font-size", "20px");
		ContactMe.getStyle().set("cursor", "pointer");
		ContactMe.addClickListener(e -> {
			ContactMe.getUI().ifPresent(ui -> ui.navigate("contact"));
		});

		HorizontalLayout hButtons = new HorizontalLayout(DownloadCV, ContactMe);

		add(hello, name, title, hButtons, image);

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");
	}

}
