package com.RPMS;

import com.RPMS.controller.LoginController;
import com.RPMS.view.HomePageView;
import com.RPMS.view.landlord.LandlordListPropertyView;
import com.RPMS.view.login_registration.LoginView;
import com.RPMS.view.manager.AccountSystemView;
import com.RPMS.view.manager.SelectSystemOptionsView;
import com.RPMS.view.renter.RenterSearchPropertyView;
import com.RPMS.view.property.ListPropertyView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;

@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@StyleSheet("./styles/custom.css")
public class MainView extends AppLayout {
    private VerticalLayout mainLayout;
    private RouterLink selectSystemOptions;
    private RouterLink deepPropertyList;
    private RouterLink home;
    private RouterLink listAccounts;

    public MainView(){
        DrawerToggle drawerToggle = new DrawerToggle();
        selectSystemOptions = new RouterLink("Select System Options", SelectSystemOptionsView.class);
        deepPropertyList = new RouterLink("Properties Listed", ListPropertyView.class);
        home = new RouterLink("Home", HomePageView.class);
        listAccounts = new RouterLink("List Accounts", AccountSystemView.class);
        RouterLink selectSystemOptions = new RouterLink("Select System Options", SelectSystemOptionsView.class);
        RouterLink landlordList = new RouterLink("Properties Listed", LandlordListPropertyView.class);
        RouterLink renterSearch = new RouterLink("Find Your Home", RenterSearchPropertyView.class);
        RouterLink home = new RouterLink("Home", HomePageView.class);
        VerticalLayout mainLayout = new VerticalLayout(home, selectSystemOptions, landlordList, renterSearch);
        addToDrawer(mainLayout);
        addToNavbar(drawerToggle);
        HorizontalLayout filler = new HorizontalLayout();
        filler.setWidth("88%");
        addToNavbar(filler);
        addToNavbar(logoutButton());
    }

    /**
     * Button to logout current user
     *
     * @return
     */
    private Button logoutButton() {
        Button logoutButton = new Button("Logout");
        logoutButton.addClickListener(e -> {
            LoginController.getInstance().logOutUser();
            getUI().ifPresent(ui -> ui.navigate(LoginView.class));
        });
        logoutButton.setThemeName(Lumo.DARK);
        logoutButton.setIcon(new Icon(VaadinIcon.EXIT_O));
        return logoutButton;
    }

    private void switchView() {

    }

    private void landlordView() {
        mainLayout = new VerticalLayout(home, deepPropertyList);
    }

    private void renterView() {
        mainLayout = new VerticalLayout(home);
    }

    private void unregisteredRenterView() {
        mainLayout = new VerticalLayout(home);
    }

    private void managerView() {
        mainLayout = new VerticalLayout(home, selectSystemOptions, deepPropertyList);
    }


}




//
///**
// * The main view contains a button and a click listener.
// */
//@Route
//@PWA(name = "My Application", shortName = "My Application")
//public class MainView extends AppLayout {
//
//    private static EntityManagerFactory factory;
//    public MainView() {
//        Label tLabel = new Label("H(III");
//        AppLayout appLayout = new AppLayout();
//
//        appLayout.addToNavbar(new DrawerToggle());
//        Tabs tabs = new Tabs(new Tab("Login"), new Tab("Browse"));
//        tabs.setOrientation(Tabs.Orientation.VERTICAL);
//        appLayout.addToDrawer(tabs);
//        appLayout.setContent(tLabel);
//
//        appLayout.setVisible(true);
//
////        NaviBarView topNaviBar = new NaviBarView();
////
////        setSizeFull();
////        setMargin(false);
////        setSpacing(false);
////        setPadding(false);
////        add(header, workspace, footer);
////        Button button = new Button("Click me",
////                event ->{
////                    factory = Persistence.createEntityManagerFactory("RPMS_PU");
////                    EntityManager em = factory.createEntityManager();
////                    em.getTransaction().begin();
////
////                    Account account = new Manager(new Address(1,"Street", "City", "Postal", "Canada"),
////                            new Name("F", "M", "L"),
////                            new Email("email@email.ca"), "TESTMAN");
////
////                    em.persist(account);
////                    em.getTransaction().commit();
////                    em.close();
////                });
////        add(button);
//
//
//
//
//    }
//}
