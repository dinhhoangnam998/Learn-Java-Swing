package com.example.demo.gui.eventlistener;

import java.util.EventListener;

import com.example.demo.gui.eventobject.QueryPersonEvent;

public interface QueryPersonSubmitListener extends EventListener {
	void queryPersonOccur(QueryPersonEvent e);
}
