package application.responsableLaboratoire.domain;

public class Agenda {
	private static String url = "https://calendar.google.com";

	public Agenda() {
		super();
	}

	public static String getAgendaLink() {
		return url;
	}
}
