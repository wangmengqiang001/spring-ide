/*******************************************************************************
 * Copyright (c) 2016 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.boot.dash.test;

import org.eclipse.jface.text.BadLocationException;
import org.junit.Test;
import org.springframework.ide.eclipse.boot.dash.test.mocks.MockManifestEditor;

public class ManifestYamlEditorTest {

	@Test
	public void toplevelCompletions() throws Exception {
		MockManifestEditor editor;
		editor = new MockManifestEditor("<*>");
		editor.assertCompletions(
				"applications:\n"+
				"  - <*>",
				// ---------------
				"buildpack: <*>",
				// ---------------
				"command: <*>",
				// ---------------
				"disk_quota: <*>",
				// ---------------
				"domain: <*>",
				// ---------------
				"domains:\n"+
				"  - <*>",
				// ---------------
				"env:\n"+
				"  <*>",
				// ---------------
//				"host: <*>",
				// ---------------
//				"hosts: \n"+
//				"  - <*>",
				// ---------------
				"inherit: <*>",
				// ---------------
				"instances: <*>",
				// ---------------
				"memory: <*>",
				// ---------------
//				"name: <*>",
				// ---------------
				"no-hostname: <*>",
				// ---------------
				"no-route: <*>",
				// ---------------
				"path: <*>",
				// ---------------
				"random-route: <*>",
				// ---------------
				"services:\n"+
				"  - <*>",
				// ---------------
				"stack: <*>",
				// ---------------
				"timeout: <*>"
		);

		editor = new MockManifestEditor("ranro<*>");
		editor.assertCompletions(
				"random-route: <*>"
		);
	}

	@Test
	public void nestedCompletions() throws Exception {
		MockManifestEditor editor;
		editor = new MockManifestEditor(
				"applications:\n" +
				"  - <*>"
		);
		editor.assertCompletions(
				// ---------------
				"applications:\n" +
				"  - buildpack: <*>",
				// ---------------
				"applications:\n" +
				"  - command: <*>",
				// ---------------
				"applications:\n" +
				"  - disk_quota: <*>",
				// ---------------
				"applications:\n" +
				"  - domain: <*>",
				// ---------------
				"applications:\n" +
				"  - domains:\n"+
				"      - <*>",
				// ---------------
				"applications:\n" +
				"  - env:\n"+
				"      <*>",
				// ---------------
				"applications:\n" +
				"  - host: <*>",
				// ---------------
				"applications:\n" +
				"  - hosts:\n"+
				"      - <*>",
				// ---------------
				"applications:\n" +
				"  - instances: <*>",
				// ---------------
				"applications:\n" +
				"  - memory: <*>",
				// ---------------
				"applications:\n" +
				"  - name: <*>",
				// ---------------
				"applications:\n" +
				"  - no-hostname: <*>",
				// ---------------
				"applications:\n" +
				"  - no-route: <*>",
				// ---------------
				"applications:\n" +
				"  - path: <*>",
				// ---------------
				"applications:\n" +
				"  - random-route: <*>",
				// ---------------
				"applications:\n" +
				"  - services:\n"+
				"      - <*>",
				// ---------------
				"applications:\n" +
				"  - stack: <*>",
				// ---------------
				"applications:\n" +
				"  - timeout: <*>"
		);
	}

	@Test
	public void valueCompletions() throws Exception {
		assertCompletions("disk_quota: <*>",
				"disk_quota: 1024M<*>",
				"disk_quota: 256M<*>",
				"disk_quota: 512M<*>"
		);
		assertCompletions("memory: <*>",
				"memory: 1024M<*>",
				"memory: 256M<*>",
				"memory: 512M<*>"
		);
		assertCompletions("no-hostname: <*>",
				"no-hostname: false<*>",
				"no-hostname: true<*>"
		);
		assertCompletions("no-route: <*>",
				"no-route: false<*>",
				"no-route: true<*>"
		);
		assertCompletions("random-route: <*>",
				"random-route: false<*>",
				"random-route: true<*>"
		);
	}

	@Test
	public void hoverInfos() throws Exception {
		MockManifestEditor editor = new MockManifestEditor(
				"memory: 1G\n" +
				"applications:\n" +
				"  - buildpack: zbuildpack\n" +
				"    domain: zdomain\n" +
				"    name: foo"
		);
		editor.assertIsHoverRegion("memory");
		editor.assertIsHoverRegion("applications");
		editor.assertIsHoverRegion("buildpack");
		editor.assertIsHoverRegion("domain");
		editor.assertIsHoverRegion("name");

		editor.assertHoverContains("memory", "Use the <code>memory</code> attribute to specify the memory limit");
		editor.assertHoverContains("1G", "Use the <code>memory</code> attribute to specify the memory limit");
		editor.assertHoverContains("buildpack", "use the <code>buildpack</code> attribute to specify its URL or name");
	}

	private void assertCompletions(String textBefore, String... textAfter) throws Exception {
		MockManifestEditor editor = new MockManifestEditor(textBefore);
		editor.assertCompletions(textAfter);
	}

}
