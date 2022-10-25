package com.darko.sygnaltransform;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.exceptions.CsvValidationException;

@SpringBootApplication
public class PpgWaveletTransformApplication {

	public static void main(String[] args) throws CsvValidationException, IOException, InvocationTargetException,
			InterruptedException, IllegalAccessException {
		SpringApplication.run(PpgWaveletTransformApplication.class, args);

		new PPGTransform();

//		APIs, Libraries and datasets used in project:
//		1. "OpenCSV" library (https://opencsv.sourceforge.net/)
//		2. "Smile" API (https://haifengl.github.io/quickstart.html)
//		3. Welltory PPG dataset (https://github.com/Welltory/welltory-ppg-dataset)
//		4. Mendeley Data "Real-World PPG dataset" (https://data.mendeley.com/datasets/yynb8t9x3d/3)

//		Licenses:
		// * CERN OHL license description (Mendeley Data) ----->
		// "The files associated with this dataset are licensed under a CERN OHL version
		// 1.2 license.",
		// "The CERN Open Hardware License (CERN OHL) governs the use, copying,
		// modification and distribution of hardware design
		// documentation, and the manufacture and distribution of products."

		// Using OpenCSV library and "Smile" API to work with Welltory PPG dataset not
		// working because method
		// transform() demands one-dimensional array, and PPG Signal in CSV files from
		// Welltory github page
		// are presented by two-dimensional array (time, R, G, B / values).
	}

}
