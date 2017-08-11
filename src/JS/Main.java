package JS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	private static final String FILENAME = "chart.js";

	public static void main(String[] args) throws JsonProcessingException {
		BufferedWriter bw = null;
		FileWriter fw = null;
		System.out.println("**************CREATING JSON FROM POJO***************");
		LineBasic basic = new LineBasic();
		List<Integer> data = new ArrayList<Integer>();
		data.add(43934);
		data.add(52503);
		data.add(57177);
		data.add(69658);
		data.add(97031);
		data.add(119931);
		data.add(137133);
		data.add(154175);
		basic.setName("Installation");
		basic.setData(data);

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(basic);
		System.out.println("**************BUILDING JAVASCRIPT FILE***************");
		String js = "";
		js += HighChartsJavaScriptGenerator.ADD_BEGINNING_BRACKET.generate("container");
		js += HighChartsJavaScriptGenerator.ADD_TITLE.generate("SOME RANOM TITLE");
		js += HighChartsJavaScriptGenerator.ADD_PLOT_OPTINS.generate("2010");
		js += HighChartsJavaScriptGenerator.ADD_SERIES.generate(jsonInString);
		js += HighChartsJavaScriptGenerator.ADD_ENDING_BRACKET.generate(null);

		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(js);
			System.out.println("**************WRITING JAVASCRIPT FILE***************");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

		String input = "/Users/lukevang/Documents/WebScrappas/Javascript/home.html";
		String output = "/Users/lukevang/Documents/WebScrappas/Javascript/home.pdf";

		String[] command = { "/usr/local/bin/wkhtmltopdf", "--disable-smart-shrinking", "-d", "1200", "-B", "0", "-L",
				"0", "-R", "0", "-T", "0", "-O", "landscape", input, output };
		try {
			System.out.println("**************CREATING PDF***************");
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command(command);
			processBuilder.redirectErrorStream(false);
			Process process = processBuilder.start();
			// wait for process to finish
			process.waitFor();
			System.out.println("PROCESS EXIT VALUE: " + process.exitValue());
			System.out.println("**************COMPLETED PDF***************");

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("**************DELETING JAVASCRIPT FILE***************");

		File f = new File("/Users/lukevang/Documents/WebScrappas/Javascript/chart.js");

		System.out.println("**************CLEANING UP***************");

		if (f.delete()) {
			System.out.println("**************" + f.getName() + " FILE DELETED***************");
		} else {
			System.out.println("**************" + f.getName() + " JAVASCRIPT FILE NOT DELTED***************");
		}

	}

}
