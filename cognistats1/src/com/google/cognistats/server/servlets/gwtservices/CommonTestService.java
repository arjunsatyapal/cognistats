package com.google.cognistats.server.servlets.gwtservices;

import com.google.cognistats.client.rpc.CommonTestRpc;
import com.google.cognistats.shared.dtos.CommonDSDto;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CommonTestService extends RemoteServiceServlet implements CommonTestRpc {

	@Override
	public CommonDSDto getCommonDSDto() {
		return null;
	}

}
