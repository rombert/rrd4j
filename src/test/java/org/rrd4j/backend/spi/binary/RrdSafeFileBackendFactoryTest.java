package org.rrd4j.backend.spi.binary;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.rrd4j.backend.spi.binary.RrdSafeFileBackendFactory;
import org.rrd4j.core.BackEndFactoryTest;
import org.rrd4j.core.RrdBackendFactory;


public class RrdSafeFileBackendFactoryTest extends BackEndFactoryTest {

    @Override
    @Test
    public void testName() {
        checkRegistred("SAFE", RrdSafeFileBackendFactory.class);
        
    }

    @Override
    @Test
    public void testBeans() throws IntrospectionException {
        checkBeans(RrdSafeFileBackendFactory.class, "lockRetryPeriod", "lockWaitTime");
    }

    @Test
    public void testStat() throws IOException {
        RrdBackendFactory factory = RrdBackendFactory.getFactory("SAFE");
        
        factory.start();
        Map<String, Number> stats = getStats(factory, "truc.rrd");
        Assert.assertEquals(0, stats.size());
    }

}