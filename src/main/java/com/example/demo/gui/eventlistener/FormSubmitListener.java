package com.example.demo.gui.eventlistener;

import java.util.EventListener;

import com.example.demo.gui.eventobject.FormSubmitEvent;

public interface FormSubmitListener extends EventListener {
	void formSubmitOccur(FormSubmitEvent e);
}
