import org.apache.commons.math3.util.Precision;

public class Main {

public static void main(String[] args) throws Exception {
	//For Aggressive Portfolio
	//define portfolio
	Portfolio aggressive = new Portfolio("Aggressive", 0.094324,
			                                    0.15675, 100000.0,
			                                    20, 0.035);
	//set the initial investment and period - as these are varied, having a setter method
	MCSimulations aggressiveSimulations = new MCSimulations(aggressive,10000);
	aggressiveSimulations.setEndingValue();
	
	//For Very Conservative Portfolio
	//define portfolio
	Portfolio conservative = new Portfolio("Very Conservative", 0.06189,
			                                    0.06348, 100000.0,
			                                    20, 0.035);
	//set the initial investment and period - as these are varied, having a setter method
	MCSimulations conservativeSimulations = new MCSimulations(conservative,10000);
	conservativeSimulations.setEndingValue();
	
	
	System.out.println("PortfolioType:   "+"     Median 20th Year    "+"     10% Best Case       "+"     10% Worst Case       ");
	
	System.out.println(aggressive.getPortfolioType()+"              "
			                   + Precision.round(aggressiveSimulations.getMedian(50),2) +
			                   "                "+Precision.round(aggressiveSimulations.getMedian(90),2) +
	                           "                "+Precision.round(aggressiveSimulations.getMedian(10),2));
	
	System.out.println(conservative.getPortfolioType()+
			                   "       "+ Precision.round(conservativeSimulations.getMedian(50),2) +
			                   "                "+Precision.round(conservativeSimulations.getMedian(90),2) +
			                   "                "+Precision.round(conservativeSimulations.getMedian(10),2));
}



}
