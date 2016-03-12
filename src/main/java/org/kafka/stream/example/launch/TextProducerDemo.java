package org.kafka.stream.example.launch;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;
import org.kafka.stream.example.core.TextProducer;
import org.kafka.stream.example.util.CommandLineHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class MailProducerDemo.
 * 
 * @author David Martinez
 */
public class TextProducerDemo {

	public static String TEXT_FILE = "textFile";
	public static String TOPIC_OPTION_NAME = "topic";

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) throws IOException {
		try {
			CommandLineHandler commandLine  = new CommandLineHandler(getProducerOptions(), args);
			
			String filePath = commandLine.getOption(TEXT_FILE);
			String topic = commandLine.getOption(TOPIC_OPTION_NAME);

			// start producer thread
			new TextProducer(topic, filePath).run();
			
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
		Option pathOption = new Option(TEXT_FILE, TEXT_FILE, true, "file to sample from text.");

		optionList.add(topicOption);
		optionList.add(pathOption);
		
		return optionList;
	}

}
