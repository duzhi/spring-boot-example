package com.daimabaike.biz.common;

public interface BizRequest<T extends BizResponse> {

    public Class<T> getResponseClass();

}
