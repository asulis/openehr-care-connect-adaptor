package com.inidus.platform.fhir.medication;

import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.param.TokenParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MedicationStatementProvider.class, MedicationStatementConnector.class})
public class MedicationStatementProviderTest {
    @Autowired
    @Qualifier("MedicationStatementProvider")
    private MedicationStatementProvider testProvider;
    @Autowired
    private MedicationStatementConnector ehrConnector;

    @Test
    public void getAllResources() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        Assert.assertNotNull(testProvider.getAllResources());
    }

    @Test
    public void getResourceByPatientIdentifier_ehrNamespace() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        TokenParam identifier = new TokenParam("uk.nhs.nhs_number", "9999999000");
        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, identifier, null, null);
        Assert.assertNotNull(result);
        Assert.assertEquals("https://fhir.nhs.uk/Id/nhs-number", result.get(0).getSubject().getIdentifier().getSystem());
    }

    @Test
    public void getResourceByPatientIdentifier_FhirNamespace() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        TokenParam identifier = new TokenParam("https://fhir.nhs.uk/Id/nhs-number", "9999999000");
        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, identifier, null, null);
        Assert.assertNotNull(result);
        Assert.assertEquals("https://fhir.nhs.uk/Id/nhs-number", result.get(0).getSubject().getIdentifier().getSystem());
    }

    @Test
    public void getResourceByDate() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        Date from = DatatypeConverter.parseDateTime("2000-12-07T15:47:43+01:00").getTime();
        Date to = DatatypeConverter.parseDateTime("2018-12-07T15:47:43+01:00").getTime();
        DateRangeParam dateRange = new DateRangeParam(from, to);

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, null, dateRange);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByDate_withouth_from() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        Date to = DatatypeConverter.parseDateTime("2018-12-07T15:47:43+01:00").getTime();
        DateRangeParam dateRange = new DateRangeParam(null, to);

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, null, dateRange);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByDate_withouth_to() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        Date from = DatatypeConverter.parseDateTime("2000-12-07T15:47:43+01:00").getTime();
        DateRangeParam dateRange = new DateRangeParam(from, null);

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, null, dateRange);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByStatus_active() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        StringParam status = new StringParam("active");

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, status, null);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByStatus_inactive() throws Exception {
        configureCdrConnector("https://test.operon.systems", "oprn_hcbox", "XioTAJoO479", false);

        StringParam status = new StringParam("inactive");

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, status, null);

        Assert.assertNotNull(result);
    }

    @Test
    public void getAllResources_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        Assert.assertNotNull(testProvider.getAllResources());
    }

    @Test
    public void getResourceByPatientIdentifier_ehrNamespace_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        TokenParam identifier = new TokenParam("uk.nhs.nhs_number", "9999999000");
        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, identifier, null, null);
        Assert.assertNotNull(result);
        Assert.assertEquals("https://fhir.nhs.uk/Id/nhs-number", result.get(0).getSubject().getIdentifier().getSystem());
    }

    @Test
    public void getResourceByPatientIdentifier_FhirNamespace_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        TokenParam identifier = new TokenParam("https://fhir.nhs.uk/Id/nhs-number", "9999999000");
        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, identifier, null, null);
        Assert.assertNotNull(result);
        Assert.assertEquals("https://fhir.nhs.uk/Id/nhs-number", result.get(0).getSubject().getIdentifier().getSystem());
    }

    @Test
    public void getResourceByDate_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        Date from = DatatypeConverter.parseDateTime("2000-12-07T15:47:43+01:00").getTime();
        Date to = DatatypeConverter.parseDateTime("2018-12-07T15:47:43+01:00").getTime();
        DateRangeParam dateRange = new DateRangeParam(from, to);

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, null, dateRange);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByDate_withouth_from_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        Date to = DatatypeConverter.parseDateTime("2018-12-07T15:47:43+01:00").getTime();
        DateRangeParam dateRange = new DateRangeParam(null, to);

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, null, dateRange);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByDate_withouth_to_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        Date from = DatatypeConverter.parseDateTime("2000-12-07T15:47:43+01:00").getTime();
        DateRangeParam dateRange = new DateRangeParam(from, null);

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, null, dateRange);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByStatus_active_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        StringParam status = new StringParam("active");

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, status, null);

        Assert.assertNotNull(result);
    }

    @Test
    public void getResourceByStatus_inactive_ethercis() throws Exception {
        configureCdrConnector("http://178.62.71.220:8080", "guest", "guest", true);

        StringParam status = new StringParam("inactive");

        List<MedicationStatementCC> result = testProvider.getFilteredResources(null, null, status, null);

        Assert.assertNotNull(result);
    }

    private void configureCdrConnector(String url, String user, String pass, boolean isToken) {
        ehrConnector.setIsTokenAuth(isToken);
        ehrConnector.setUrl(url);
        ehrConnector.setUsername(user);
        ehrConnector.setPassword(pass);
    }
}
