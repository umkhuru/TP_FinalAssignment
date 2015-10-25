package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.ContactDetails;

import java.util.Map;

/**
 * Created by student on 2015/10/24.
 */
public class ContactDetailsFactory {

    public static ContactDetails createContactDetails(Map<String,String> values, Map<Long, Long> value)
    {
        ContactDetails contactDetails = new ContactDetails.Builder(values.get("email"))
                .address(values.get("address"))
                .cellNumber(value.get("cellNumber"))
                .telNumber(value.get("telNumber"))
                .build();

        return contactDetails;
    }
}
