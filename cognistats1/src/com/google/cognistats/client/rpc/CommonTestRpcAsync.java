package com.google.cognistats.client.rpc;

import com.google.cognistats.shared.dtos.CommonDSDto;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CommonTestRpcAsync {

	void getCommonDSDto(AsyncCallback<CommonDSDto> callback);

}
