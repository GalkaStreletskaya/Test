package elements;

public class TestConstants {

	public static final String BASE_URL = "https://www.24option.com/24option/#Trade";
	
	public static long DEFAULT_TIMEOUT = 3000;
	
	//Main Page Selectors
	public static final String LOGIN_FIELD = "input[class='gwt-TextBox navigation_menu_username_field']";
	public static final String LOGIN_BUTTON = "div[class='navigation_menu_login_button']";
	public static final String ERROR_POPUP = "div[class='message_popup_message']";
	public static final String SELECTED_LANGUAGE = "div[class*='language_selector_flag_%s']";
	public static final String NOT_SELECTED_LANGUAGE = "div[class='language_selector_popup_language_panel language_selector_popup_language_panel_%s']";
	public static final String LANGUAGE_LABEL = "div[class='language_selector_label']";
	public static final String LANGUAGE_BAR = "div[class='language_selector_popup']";
}
