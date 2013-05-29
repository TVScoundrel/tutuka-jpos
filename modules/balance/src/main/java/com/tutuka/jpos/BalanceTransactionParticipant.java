package com.tutuka.jpos;

import java.io.Serializable;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;

public class BalanceTransactionParticipant extends TxnSupport {
	protected int doPrepare(long id, Context ctx) throws Exception {
		ISOMsg m = (ISOMsg) ctx.get(BalanceRequestListener.REQUEST);
		ISOSource s = (ISOSource) ctx.get(BalanceRequestListener.ISOSOURCE);
		
		if(m.hasField(3) && m.getString(3).charAt(0) == '3') {
			m.set(39, "00");
			m.set(4, "7102000000100000");
			m.set(5, "7102000000100000");
			m.set(6, "7102000000100000");
		} else {
			m.set(39, "01");
		}

		m.setResponseMTI();
		s.send(m);
		
		return PREPARED | NO_JOIN | READONLY;
	}
	
	public void commit(long id, Serializable context) { }
	public void abort(long id, Serializable context) { }
}
