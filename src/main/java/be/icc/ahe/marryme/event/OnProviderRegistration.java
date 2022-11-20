package be.icc.ahe.marryme.event;

import be.icc.ahe.marryme.model.Societe;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;
@Getter
@Setter
public class OnProviderRegistration  extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private Societe societe;

    public OnProviderRegistration(Societe societe, Locale locale)
    {
        super(societe);
        this.societe = societe;
        this.locale = locale;
    }

}
