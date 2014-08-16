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
package ca.pgon.chaincommander.configurators.exceptions;

/**
 * Thrown when the ArgumentsConfigurator has an issue parsing the arguments.
 * 
 * @author Simon Levesque
 * 
 */
public class BadArgumentsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Contructor with a message.
	 * 
	 * @param msg
	 *            the message
	 */
	public BadArgumentsException(String msg) {
		super(msg);
	}

}