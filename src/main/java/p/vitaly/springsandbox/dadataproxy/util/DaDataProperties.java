
package p.vitaly.springsandbox.dadataproxy.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author vitalyp
 */
@Data
@Component
@PropertySource("classpath:dadata.properties")
public class DaDataProperties {
    @Value("${dadata.key}") String key;
    @Value("${dadata.secret}") String secret;
}
