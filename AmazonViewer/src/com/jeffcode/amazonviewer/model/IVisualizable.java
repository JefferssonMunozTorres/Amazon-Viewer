package com.jeffcode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {

	Date starToSee(Date dateI);
	void stopToSee(Date dateI, Date dateF);
}
