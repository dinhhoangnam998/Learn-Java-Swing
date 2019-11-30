package com.example.demo.gui.eventlistener;

import java.util.EventListener;

import com.example.demo.gui.eventobject.AddPersonEvent;

public interface AddPersonSubmitListener extends EventListener {
	void addPersonOccur(AddPersonEvent e);
}
