package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MakeUpAndHair extends Service {
    private Boolean doHair;
    private Boolean doMakeUp;
    private Boolean doMan;
    private Boolean doWoman;

}
