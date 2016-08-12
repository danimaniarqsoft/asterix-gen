import java.math.BigDecimal;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;

public class Usuario {

    @XmlElement
    private int nombre;
    @XmlElement
    private long apMaterno;
    @XmlElement
    private BigDecimal apPaterno;
    @XmlElement
    private String telefono;
}
