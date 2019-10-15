package com.xm.ssit.demo;

import com.xm.ssit.demo.rules.RuleClass;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

/**
 * @ClassName RuleClient
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/8/6 17:01
 * Verion 1.0
 **/
public class RuleClient {
	public static void main(String[] args) {
		// create a rules engine
		RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
		RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

		// create rules
		Rules rules = new Rules();
		rules.register(new RuleClass.FizzRule());
		rules.register(new RuleClass.BuzzRule());
		rules.register(new RuleClass.FizzBuzzRule(new RuleClass.FizzRule(), new RuleClass.BuzzRule()));
		rules.register(new RuleClass.NonFizzBuzzRule());

		// fire rules
		Facts facts = new Facts();
		for (int i = 1; i <= 100; i++) {
			facts.put("number", i);
			fizzBuzzEngine.fire(rules, facts);
			System.out.println();
		}
	}

}
