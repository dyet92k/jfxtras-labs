package jfxtras.labs.icalendarfx.components;

import java.time.temporal.TemporalAmount;

import javafx.beans.property.ObjectProperty;
import jfxtras.labs.icalendarfx.properties.component.time.DurationProp;

public interface VComponentDuration<T> extends VComponentNew<T>
{
    /** 
     * DURATION
     * RFC 5545 iCalendar 3.8.2.5 page 99, 3.3.6 page 34
     * Can't be used if DTEND is used.  Must be one or the other.
     * 
     * Example:
     * DURATION:PT15M
     * */
    ObjectProperty<DurationProp> durationProperty();
    default DurationProp getDuration() { return durationProperty().get(); }
    default void setDuration(DurationProp duration) { durationProperty().set(duration); }
    default T withDuration(TemporalAmount amount) { setDuration(new DurationProp(amount)); return (T) this; }
    default T withDuration(String amount) { setDuration(new DurationProp(amount)); return (T) this; }
    default T withDuration(DurationProp duration) { setDuration(duration); return (T) this; }
}