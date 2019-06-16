package com.daimabaike.biz.common.web;

import com.daimabaike.biz.common.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController<R extends BaseEntity> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ModelAttribute
    public void init(R user, HttpServletRequest request) {

        if (this.getClass().equals(CommonController.class)) {
            return;
        }

        logger.info("_ip={}", user.get_ip());
        user.set_ip(request.getRemoteAddr());

        logger.info("_ip={}", user.get_ip());
    }

}
