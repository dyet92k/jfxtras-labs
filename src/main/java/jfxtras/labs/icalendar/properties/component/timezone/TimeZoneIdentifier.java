package jfxtras.labs.icalendar.properties.component.timezone;

import java.time.DateTimeException;
import java.time.ZoneId;

import jfxtras.labs.icalendar.parameters.ValueParameter.ValueType;
import jfxtras.labs.icalendar.properties.PropertyBase;
import jfxtras.labs.icalendar.properties.component.descriptive.Status;

/**
 * TZID
 * Time Zone Identifier
 * RFC 5545, 3.8.3.1, page 102
 * 
 * To specify the identifier for the time zone definition for
 * a time component in the property value
 * 
 * LIMITATION: globally unique time zones are stored as strings and the ZoneID is null.
 * Only the toString and toContentLine methods will display the original string.  Another
 * method to convert the unique time zone string into a ZoneId is required.
 * 
 * EXAMPLE:
 * TZID:America/Los_Angeles
 * 
 * @author David Bal
 *
 */
public class TimeZoneIdentifier extends PropertyBase<Status, ZoneId>
{
    private String unknownValue; // contains exact string for unknown property value

    public TimeZoneIdentifier(String contentLine)
    {
        super(contentLine);
    }
    
    public TimeZoneIdentifier(TimeZoneIdentifier source)
    {
        super(source);
    }
    
    public TimeZoneIdentifier(ZoneId value)
    {
        super(value);
    }
    
    @Override
    protected ZoneId valueFromString(String propertyValueString)
    {
        try
        {
            return ZoneId.of(propertyValueString);
        } catch (DateTimeException e)
        {
            unknownValue = propertyValueString;
        }
        return null;
    }
    
    @Override
    protected String valueToString(ZoneId value)
    {
        if (value == null)
        {
            return unknownValue;
        }
        return getValue().toString();
    }
    
    @Override
    public boolean isValid()
    {
        boolean nonGlobalOK = (getValue() != null);
        boolean globallyUniqueOK = ((unknownValue != null) && (unknownValue.charAt(0) == '/'));
        boolean valueTypeOK = ((getValueParameter() == null) || (getValueParameter().equals(ValueType.TEXT)));
        return (nonGlobalOK || globallyUniqueOK) && valueTypeOK;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean superEquals = super.equals(obj);
        if (superEquals == false)
        {
            return false;
        }
        TimeZoneIdentifier testObj = (TimeZoneIdentifier) obj;
        boolean unknownEquals = (unknownValue == null) ? testObj.unknownValue == null : unknownValue.equals(testObj.unknownValue);
        return unknownEquals;
    }
}
