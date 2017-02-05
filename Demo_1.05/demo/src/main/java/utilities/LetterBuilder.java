package utilities;

import taskfordemo.demo.EmailPage;

public class LetterBuilder {

	private EmailPage letter;

	public LetterBuilder() {
		letter = new EmailPage();
	}

	public LetterBuilder setTO(String to) {
		letter.setTO(to);
		return this;
	}

	public LetterBuilder setSubject(String subject) {
		letter.setSubject(subject);
		return this;
	}

	public LetterBuilder setBody(String body) {
		letter.setBody(body);
		return this;
	}

	public EmailPage build() {
		return this.letter;
	}

}
