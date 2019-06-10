
package p.vitaly.springsandbox.dadataproxy.dadata;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.vitaly.springsandbox.dadataproxy.util.DaDataProperties;
import ru.redcom.lib.integration.api.client.dadata.DaDataClient;
import ru.redcom.lib.integration.api.client.dadata.DaDataClientFactory;
import ru.redcom.lib.integration.api.client.dadata.dto.Address;

/**
 *
 * @author vitalyp
 * 
 * DaData standartization service.
 * 
 * dadata.key and dadata.secret properties in dadata.properties file must be
 * provided for success request.
 */
@Component
public class DaDataStandartization {
    
    @Autowired
    private DaDataProperties daDataProperties;
    
    private DaDataClient daDataClient;
    
    @PostConstruct
    public void init() {
        daDataClient = DaDataClientFactory.getInstance(daDataProperties.getKey(), daDataProperties.getSecret());
    }
    
    /**
    * Fetch standartized address object.
    * @param source - simple address name (ex.: 'spb nevsky 15').
    * @return ru.redcom.lib.integration.api.client.dadata.dto.Address instance.
    */
    public Address cleanAddress(final String source) {
        return daDataClient.cleanAddress(source);
    }
    
    /**
     * Check if dadata service is available.
     * @return true - if service available, false otherwise.
     */
    public boolean isAvailable() {
        return daDataClient.checkAvailability(true);
    }
}
