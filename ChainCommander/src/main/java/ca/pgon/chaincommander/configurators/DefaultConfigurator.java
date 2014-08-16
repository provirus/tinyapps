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
package ca.pgon.chaincommander.configurators;

import java.util.Map;

import ca.pgon.chaincommander.modes.ModeConstants;

/**
 * Configure the software via some default values.
 * 
 * @author Simon Levesque
 * 
 */
public class DefaultConfigurator implements Configurator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void configure(Map<String, String> configMap) {
		configMap.put(ConfigManager.PORT, "1000");
		configMap.put(ConfigManager.MODE, ModeConstants.MASTER);
	}
}