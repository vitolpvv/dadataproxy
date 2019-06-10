package p.vitaly.springsandbox.dadataproxy;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import p.vitaly.springsandbox.dadataproxy.util.DaDataProperties;

/**
 *
 * @author vitalyp
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DaDataProperties.class)
public class PropertiesTest {
    
    @Autowired
    private DaDataProperties daDataProperties;
    
    @Test
    public void isDaDataKeyProvided() {
        assertNotEquals("DaData api-key must be provided", "", daDataProperties.getKey());
    }
    
    @Test
    public void isDaDataSecretProvided() {
        assertNotEquals("DaData secret-key must be provided", "", daDataProperties.getSecret());
    }
    
}
