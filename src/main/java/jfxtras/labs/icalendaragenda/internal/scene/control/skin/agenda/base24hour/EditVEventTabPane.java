package jfxtras.labs.icalendaragenda.internal.scene.control.skin.agenda.base24hour;

import jfxtras.labs.icalendarfx.components.VEvent;

public class EditVEventTabPane extends EditDisplayableTabPane<VEvent>
{
    public EditVEventTabPane( )
    {
        super();
//        DescriptiveVBox<VEvent> v = new DescriptiveVEventVBox();
//        setEditDescriptive(v);
        setDescriptiveVBox(new DescriptiveVEventVBox());
        getDescriptiveAnchorPane().getChildren().add(getDescriptiveVBox());
//        this.setId("editVEventTabPane");
    }
}
