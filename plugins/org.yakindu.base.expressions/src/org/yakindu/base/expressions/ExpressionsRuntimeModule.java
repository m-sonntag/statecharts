/*
 * generated by Xtext
 */
package org.yakindu.base.expressions;

import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;

public class ExpressionsRuntimeModule extends org.yakindu.base.expressions.AbstractExpressionsRuntimeModule {

	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return ExpressionsTypeInferrer.class;
	}

}
