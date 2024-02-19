package com.example.application.views;

import com.example.application.views.about.AboutView;
import com.example.application.views.blog.BlogView;
import com.example.application.views.contact.ContactView;
import com.example.application.views.home.HomeView;
import com.example.application.views.portfolio.PortfolioView;
import com.example.application.views.services.ServicesView;
import com.example.application.views.skills.SkillsView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

	private H2 viewTitle;

	public MainLayout() {
		setPrimarySection(Section.DRAWER);
		addDrawerContent();
		addHeaderContent();
	}

	private void addHeaderContent() {
		DrawerToggle toggle = new DrawerToggle();
		toggle.setAriaLabel("Menu toggle");

		viewTitle = new H2();
		viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

		addToNavbar(true, toggle, viewTitle);
	}

	private void addDrawerContent() {
		H1 appName = new H1("< Gideon-Yebei />");
		appName.getStyle().set("width", "100%");
		appName.getStyle().set("text-align", "center");
		appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
		Header header = new Header(appName);

		Scroller scroller = new Scroller(createNavigation());

		addToDrawer(header, scroller, createFooter());
	}

	private SideNav createNavigation() {
		SideNav nav = new SideNav();

		nav.addItem(new SideNavItem("Home", HomeView.class, LineAwesomeIcon.HOME_SOLID.create()));
		nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.USER.create()));
		nav.addItem(new SideNavItem("Skills", SkillsView.class, LineAwesomeIcon.TOOLS_SOLID.create()));
		nav.addItem(new SideNavItem("Services", ServicesView.class, LineAwesomeIcon.TOOLBOX_SOLID.create()));
		nav.addItem(new SideNavItem("Portfolio", PortfolioView.class, LineAwesomeIcon.CODE_SOLID.create()));
		nav.addItem(new SideNavItem("Blog", BlogView.class, LineAwesomeIcon.BOOK_READER_SOLID.create()));
		nav.addItem(new SideNavItem("Contact", ContactView.class, LineAwesomeIcon.PAPER_PLANE_SOLID.create()));

		return nav;
	}

	private Footer createFooter() {
		Footer layout = new Footer();

		H2 footer = new H2("© 2024 Gideon Yebei");
		footer.getStyle().set("width", "100%");
		footer.getStyle().set("text-align", "center");
		footer.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
		layout.add(footer);

		return layout;
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		viewTitle.setText(getCurrentPageTitle());
	}

	private String getCurrentPageTitle() {
		PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : title.value();
	}
}
