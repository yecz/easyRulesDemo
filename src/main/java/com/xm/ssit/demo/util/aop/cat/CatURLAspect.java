package com.xm.ssit.demo.util.aop.cat;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.ssit.framework.ext.annotation.CatURL;
import com.ssit.framework.ext.constants.ServerConstant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yechengzong on 2018/11/15.
 */
@Aspect
@Component
public class CatURLAspect {
	private Logger logger = LoggerFactory.getLogger(CatURLAspect.class);

	@Around(value = " @annotation(catURL)", argNames = "pjp,catURL")
	public Object catURLTransaction(ProceedingJoinPoint pjp, CatURL catURL)
			throws Exception {
		logger.debug(" {} cat url start", catURL.serviceName());
		Transaction t = Cat.newTransaction("URL", catURL.serviceName());
		Object retVal = null;
		try {
			Cat.logEvent("URL.Server", ServerConstant.SERVER_IP, Event.SUCCESS, "ip=" + ServerConstant.SERVER_IP);
			retVal = pjp.proceed();
			logger.debug(" {} cat url set success ", catURL.serviceName());
			t.setStatus(Transaction.SUCCESS);
		} catch (Throwable e) {
			t.setStatus(e);
			Cat.logError(e);
		} finally {
			logger.debug(" {} cat url complete ", catURL.serviceName());
			t.complete();
		}
		return retVal;
	}

}
