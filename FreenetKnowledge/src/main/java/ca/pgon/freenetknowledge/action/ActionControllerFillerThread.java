/*
    Tinyapps https://github.com/provirus/tinyapps
    Copyright (C) 2014

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package ca.pgon.freenetknowledge.action;

/**
 * This class will populate the ActionController with new items indefinitely.
 * 
 * @author Simon Levesque
 * 
 */
public class ActionControllerFillerThread extends Thread {

	private ActionController actionController;

	/**
	 * The constructor.
	 * 
	 * @param actionController
	 *            the ActionController that created it.
	 */
	public ActionControllerFillerThread(ActionController actionController) {
		this.actionController = actionController;
	}

	/**
	 * This method will request the creation of new actions indefinitely.
	 */
	@Override
	public void run() {
		while (true) {
			actionController.fill();
		}
	}

}