package com.xm.ssit.demo;

import com.sun.prism.ResourceFactory;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @ClassName RuleClientYml
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/8/6 17:05
 * Verion 1.0
 **/
public class RuleClientYml {

	public static void main(String[] args) throws FileNotFoundException {
		RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
		RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
		Rules rules = MVELRuleFactory.createRulesFrom(new FileReader("E:\\easyRulesDemo\\target\\classes\\ymls\\rules.yml"));

		Facts facts = new Facts();
		for (int i = 1; i <= 20; i++) {
			System.out.println("====== " + i + " ======");
			facts.put("number", i);
			rulesEngine.fire(rules, facts);
		}
	}
}