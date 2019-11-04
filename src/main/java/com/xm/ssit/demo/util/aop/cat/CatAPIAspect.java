package com.xm.ssit.demo.util.aop.cat;


import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.xm.ssit.demo.util.aop.annotation.CatAPI;
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
public class CatAPIAspect {
	private Logger logger = LoggerFactory.getLogger(CatAPIAspect.class);


	@Around(value = "@annotation(catAPI)", argNames = "pjp,catAPI")
	public Object catAPITransaction(ProceedingJoinPoint pjp, CatAPI catAPI)
			throws Exception {
		logger.debug(" {} cat api before", catAPI.serviceName());
		Transaction t = Cat.newTransaction("URL", catAPI.serviceName());
		Object retVal = null;
		try {
			retVal = pjp.proceed();
			logger.debug(" {} cat api set success ", catAPI.serviceName());
			t.setStatus(Transaction.SUCCESS);
		} catch (Throwable e) {
			t.setStatus(e);
			Cat.logError(e);
		} finally {
			logger.debug(" {} cat api complete ", catAPI.serviceName());
			t.complete();
		}
		return retVal;
	}
}
