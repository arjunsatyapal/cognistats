package com.google.cognistats.client.rpc;

import com.google.cognistats.shared.dtos.CommonDSDto;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("stockPrices")

public interface CommonTestRpc extends RemoteService {
	CommonDSDto getCommonDSDto();

}
