package org.kafka.stream.example.launch;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import org.kafka.stream.example.core.TextProducer;
import org.kafka.stream.example.core.WordCountJob;
import org.kafka.stream.example.util.CommandLineHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class MailProducerDemo.
 * 
 * @author David Martinez
 */
public class WordCountDemo {

	public static String TOPIC_OPTION_NAME = "topic";
	public static String GROUP_OPTION_NAME = "job";
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) throws IOException {
		try {
			CommandLineHandler commandLine  = new CommandLineHandler(getProducerOptions(), args);
			
			String topic = commandLine.getOption(TOPIC_OPTION_NAME);
			String job = commandLine.getOption(GROUP_OPTION_NAME);

			// start producer thread
			new WordCountJob(topic, job).run();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the producer options.
	 *
	 * @return the producer options
	 */
	private static List<Option> getProducerOptions(){
		List<Option> optionList = new ArrayList<Option>();
		
		Option topicOption = new Option(TOPIC_OPTION_NAME, TOPIC_OPTION_NAME, true, "topic name on which message is going to be published");
		Option pathOption = new Option(GROUP_OPTION_NAME, GROUP_OPTION_NAME, true, "group of this job.");

		optionList.add(topicOption);
		optionList.add(pathOption);
		
		return optionList;
	}

}
