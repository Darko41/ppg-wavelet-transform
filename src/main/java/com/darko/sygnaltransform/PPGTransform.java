package com.darko.sygnaltransform;

import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import smile.plot.swing.Canvas;
import smile.plot.swing.LinePlot;
import smile.plot.swing.Plot;
import smile.plot.swing.PlotPanel;
import smile.wavelet.BestLocalizedWavelet;
import smile.wavelet.CoifletWavelet;
import smile.wavelet.D4Wavelet;
import smile.wavelet.DaubechiesWavelet;
import smile.wavelet.HaarWavelet;
import smile.wavelet.SymletWavelet;
import smile.wavelet.Wavelet;
import smile.wavelet.WaveletShrinkage;

public class PPGTransform {

	public PPGTransform() throws CsvValidationException, IOException, InvocationTargetException, InterruptedException,
			IllegalAccessException {
		// Using "OpenCSV" library and "Smile" API to work with Mendeley Data:
		CSVReader reader = new CSVReader(new FileReader(
				"C:\\Users\\kracu\\Documents\\workspace-spring-tool-suite-4-4.10.0\\ppg-wavelet-transform\\src\\main\\resources\\train8.csv"));
		String[] nextLine;
		double[] ppgSignal = null;
		double[] smooth = null;

		System.setProperty("java.awt.headless", "false");

		while ((nextLine = reader.readNext()) != null) {
			ppgSignal = Arrays.stream(nextLine).mapToDouble(Double::parseDouble).toArray();

//			Daubechies wavelet
//			DaubechiesWavelet daubechies = new DaubechiesWavelet(20);
//			daubechies.transform(ppgSignal);
//			smooth = ppgSignal.clone();
//			WaveletShrinkage.denoise(smooth, daubechies);

//			"D4", the simplest and most localized wavelet
//			D4Wavelet d4 = new D4Wavelet();
//			d4.transform(ppgSignal);
//			smooth = ppgSignal.clone();
//			WaveletShrinkage.denoise(smooth, d4);

//			Best Localized Wavelet
//			BestLocalizedWavelet blw = new BestLocalizedWavelet(14);
//			blw.transform(ppgSignal);
//			smooth = ppgSignal.clone();
//			WaveletShrinkage.denoise(smooth, blw);

//			Coiflet Wavelet
//			CoifletWavelet cw = new CoifletWavelet(30);
//			cw.transform(ppgSignal);
//			smooth = ppgSignal.clone();
//			WaveletShrinkage.denoise(smooth, cw);

//			Haar Wavelet
//			HaarWavelet haar = new HaarWavelet();
//			haar.transform(ppgSignal);
//			smooth = ppgSignal.clone();
//			WaveletShrinkage.denoise(smooth, haar);

//			Symlet Wavelet
//			SymletWavelet sw = new SymletWavelet(20);
//			sw.transform(ppgSignal);
//			smooth = ppgSignal.clone();
//			WaveletShrinkage.denoise(smooth, sw);

		}

		if (!GraphicsEnvironment.isHeadless()) {
			Plot plot1 = LinePlot.of(ppgSignal);
			Plot plot2 = LinePlot.of(smooth, java.awt.Color.BLUE);

			Canvas canvas = plot1.canvas();
			canvas.add(plot2);
			canvas.panel().window();
			canvas.setTitle("Symlet Wavelet, Coeff. 20");
		}

	}

}
