package com.tutuka.jpos;

import java.io.*;
import org.jpos.iso.*;
import org.jpos.util.*;
import org.jpos.iso.channel.*;
import org.jpos.iso.packager.*;

public class Test implements ISORequestListener {
	public Test() {
		super();
	}

	public boolean process(ISOSource source, ISOMsg m) {
		try {
			m.setResponseMTI();
			m.set(39, "00");
			source.send(m);
		} catch (ISOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}