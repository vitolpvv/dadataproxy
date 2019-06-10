
package p.vitaly.springsandbox.dadataproxy.rest;

import p.vitaly.springsandbox.dadataproxy.dadata.DaDataStandartization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import p.vitaly.springsandbox.dadataproxy.util.Geo;
import ru.redcom.lib.integration.api.client.dadata.dto.Address;

/**
 *
 * @author vitalyp
 * 
 * Geographic location REST service.
 * 
 * There are two methods for getting address geographic location:
 * 
 * GET-method - address provided by query parameter 'addr'
 * 
 * POST-method - address provided by request body in text/plain format
 */
@RestController
@RequestMapping("address")
public class AddressController {
    
    @Autowired
    private DaDataStandartization daDataStandartization;
    
    /**
     * Address geographic location GET-request.
     * @param address - simple address name provided by query parameter 'addr'.
     * @return p.vitaly.springsandbox.dadataproxy.util.Geo - address geo-location.
     */
    @GetMapping(path = "geo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Geo geoGetRequest(@RequestParam("addr") String address) {
        return getGeoForAddress(address);
    }
    
    /**
     * Address geographic location POST-request.
     * @param address - simple address name provided by request body.
     * @return p.vitaly.springsandbox.dadataproxy.util.Geo - address geo-location.
     */
    @PostMapping(path = "geo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Geo geoPostRequest(@RequestBody String address) {
        return getGeoForAddress(address);
    }
    
    /**
     * Fetch address from dadata service and create corresponds Geo instance.
     * @param address - simple address name
     * @return p.vitaly.springsandbox.dadataproxy.util.Geo - address geo-location.
     */
    private Geo getGeoForAddress(String address) {
        Address addr = daDataStandartization.cleanAddress(address);
        Geo geo = new Geo();
        geo.setLatitude(addr.getGeoLat());
        geo.setLongitude(addr.getGeoLon());
        return geo;
    }
}
