package com.qianxiaofeng.design.patterns.behavior.templatemethod;

public class BProcesser extends AbstractProcesserTemplate {

	@Override
	protected void innerProcess() {
		// 仅需要关心差异化的处理流程
	}

}
