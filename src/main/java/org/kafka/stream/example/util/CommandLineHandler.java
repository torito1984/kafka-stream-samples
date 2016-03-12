package org.kafka.stream.example.util;

import org.apache.commons.cli.*;

import java.util.List;

/**
 * Created by david on 2/27/16.
 */
public class CommandLineHandler {
	private final CommandLine commandLine;
	
	/**
	 * Gets the option.
	 *
	 * @param option the option
	 * @return the option
	 */
	public String getOption(final String option) {
	    if (commandLine!=null && commandLine.hasOption(option)) {
	        return commandLine.getOptionValue(option);
	    }

	    return null;
	}

	/**
	 * Instantiates a new kafka example command line handler.
	 *
	 * @param optionList the option list
	 * @param args the args
	 * @throws ParseException the parse exception
	 */
	public CommandLineHandler(final List<Option> optionList, String[] args) throws ParseException{
		final CommandLineParser parser = new BasicParser();
		
	    final Options options = new Options();
	    for(Option option: optionList){
	    	options.addOption(option);
	    }

	    commandLine = parser.parse(options, args);
	}
}
