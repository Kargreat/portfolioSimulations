/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

import java.util.HashMap;

public class MCSimulations {
	private Portfolio portfolio;
	//setting up variables for results
	private Integer simulations;
	private HashMap<Integer, Double> endingValue;
	
	//set up a simulation:

// all results would be bound to a portfolio
public MCSimulations(Portfolio portfolio, Integer simulations) {
	this.portfolio = portfolio;
	this.simulations = simulations;
}



public HashMap<Integer, Double> run(){
	HashMap<Integer, Double> localEndingValue = new HashMap<>();
			NormalDistribution normalDistribution = new NormalDistribution(portfolio.getPortfolioReturn(), portfolio.getPortfolioRisk());
	//the simulation is run on the 20th year value, for 10k simulations
	for(int i=0;i<this.simulations;i++){    //calculating for 10k simulations
		Double thisSimulationResult = portfolio.getInitalInvestment();//this is a reference variable that calculates the return at the end of a simulation
		for(int j=0;j<portfolio.getInvestmentPeriod();j++){     //simulate over the investment period
			thisSimulationResult=(1+normalDistribution.sample())*thisSimulationResult;//end of year return
			thisSimulationResult=(1-portfolio.getInflation())*thisSimulationResult;//adjust for inflation for next term
		}
		localEndingValue.put(i, thisSimulationResult);
	}
	return localEndingValue;
}

public HashMap<Integer, Double> setEndingValue(){
	this.endingValue = this.run();
	return this.endingValue;
}

public double getMedian(double perc) {
	Percentile percentile = new Percentile();
	
	//convert the map to a doubles array as the math3 percentile takes a doubles as an array
	double[] doubles = new double[this.endingValue.size()];
	for(int i =0; i<this.endingValue.size();i++){
		doubles[i] = this.endingValue.get(i);
	}
	
	percentile.setData(doubles);
	return percentile.evaluate(perc);
}

public void printSimulationResult()
{
	setEndingValue();
	this.endingValue.forEach((k,v)->System.out.println("item "+ k + " value " + v));
}

}
