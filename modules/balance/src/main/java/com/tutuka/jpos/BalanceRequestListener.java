package com.tutuka.jpos;

import java.io.*;
import org.jpos.iso.*;
import org.jpos.util.*;
import org.jpos.iso.channel.*;
import org.jpos.iso.packager.*;
import org.jpos.transaction.*;
import org.jpos.space.*;

public class BalanceRequestListener implements ISORequestListener {
	public static final String REQUEST = "REQUEST";
	public static final String ISOSOURCE = "ISOSOURCE";
	
	public BalanceRequestListener() {
		super();
	}

	public boolean process(ISOSource source, ISOMsg m) {
		Context ctx = new Context();
		ctx.put (REQUEST, m);
		ctx.put (ISOSOURCE, source);
		
		Space sp = SpaceFactory.getSpace();
		sp.out("txn", ctx);
		/*m.setResponseMTI();
		m.set(39, "00");
		source.send(m);*/
		return true;
	}
}