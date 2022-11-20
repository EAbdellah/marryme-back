package be.icc.ahe.marryme.event;

import be.icc.ahe.marryme.model.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

 @Getter @Setter
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private Person person;

    public OnRegistrationCompleteEvent(Person person, Locale locale, String appUrl)
    {
        super(person);
        this.person = person;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    // standard getters and setters
}
