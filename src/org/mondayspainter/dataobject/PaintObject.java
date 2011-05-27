package org.mondayspainter.dataobject;

import org.mondayspainter.dbhandler.IDataHandler;
import org.mondayspainter.dbhandler.PaintObjectHandler;
import org.mondayspainter.transportobject.PaintObjectTransport;

public class PaintObject extends DataObject<PaintObject> {
	
	private String title;
	
	public PaintObject() { }
	
	public PaintObjectTransport toTransportObject() {
		PaintObjectTransport t = new PaintObjectTransport();
		t.id = id;
		t.title = title;
		return t;
	}
	
	@Override
	public IDataHandler<PaintObject> getDataHandler() {
		return new PaintObjectHandler();
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
