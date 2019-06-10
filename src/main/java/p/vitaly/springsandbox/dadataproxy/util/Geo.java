
package p.vitaly.springsandbox.dadataproxy.util;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author vitalyp
 * 
 * Represent geographic location
 */
@Data
public class Geo implements Serializable{

    private static final long serialVersionUID = 3556634333658001365L;
    
    private Double latitude;
    private Double longitude;
}
