/*******************************************************************************
 *  Copyright (c) 2012 VMware, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      VMware, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.config.graph.model;

import org.eclipse.gef.requests.CreationFactory;

/**
 * @author Leo Dos Santos
 */
public class TransitionCreationFactory implements CreationFactory {

	public Object getNewObject() {
		return null;
	}

	public Object getObjectType() {
		return Transition.SOLID_CONNECTION;
	}

}
