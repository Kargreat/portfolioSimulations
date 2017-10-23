/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import junit.framework.TestCase;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

import java.util.HashMap;

public class MCSimulationsTest extends TestCase {
public void testSetEndingValue() throws Exception {
	HashMap<Integer, Double> localEndingValue = new HashMap<>();
	for(int i=0;i<10;i++){
		Double thisSimulationResult = 10000.00;
		NormalDistribution normalDistribution = new NormalDistribution(0.2, 0.1);
		for(int j=0;j<2;j++){
			thisSimulationResult=(1+normalDistribution.sample())*thisSimulationResult;//end of year return
			thisSimulationResult=(1-0.01)*thisSimulationResult;
		}
		localEndingValue.put(i, thisSimulationResult);
	}
	localEndingValue.forEach((k,v)->System.out.println("item "+ k + " value " + v));
}

public void testGetMedian() throws Exception {
	Percentile percentile = new Percentile();
	double[] doubles = {1.9, 2.9, 3.4, 3.5};
	percentile.setData(doubles);
	System.out.println(percentile.evaluate(50));
	System.out.println(percentile.evaluate(90));
	System.out.println(percentile.evaluate(10));
	
	}
}