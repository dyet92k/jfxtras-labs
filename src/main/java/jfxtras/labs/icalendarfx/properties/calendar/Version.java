package jfxtras.labs.icalendarfx.properties.calendar;

import jfxtras.labs.icalendarfx.VCalendar;
import jfxtras.labs.icalendarfx.properties.PropertyBase;

/**
 * VERSION
 * RFC 5545, 3.7.4, page 79
 * 
 * This property specifies the identifier corresponding to the
 * highest version number or the minimum and maximum range of the
 * iCalendar specification that is required in order to interpret the
 * iCalendar object. 
 * 
 * A value of "2.0" corresponds to this software.
 * 
 * Example:
 * VERSION:2.0
 * 
 * @author David Bal
 * @see VCalendar
 */
public class Version extends PropertyBase<String, Version>
{
    public Version(CharSequence contentLine)
    {
        super(contentLine);
    }
    
    public Version(Version source)
    {
        super(source);
    }
    
    /** Set version to default value of 2.0 */
    public Version()
    {
        // null as argument for string converter causes default converter from ValueType to be used
        super("2.0");
    }
}