public class Portfolio {
	private String portfolioType;
	private Double portfolioReturn;
	private Double portfolioRisk;
	private Double initalInvestment;
	private Integer investmentPeriod;
	private Double inflation;

public Portfolio(String portfolioType, Double portfolioReturn, Double portfolioRisk, Double initalInvestment, Integer investmentPeriod, Double inflation) {
	this.portfolioType = portfolioType;
	this.portfolioReturn = portfolioReturn;
	this.portfolioRisk = portfolioRisk;
	this.initalInvestment = initalInvestment;
	this.investmentPeriod = investmentPeriod;
	this.inflation = inflation;
}

public String getPortfolioType() {
	return portfolioType;
}

public Double getInflation() {
	return inflation;
}

public void setPortfolioType(String portfolioType) {
	this.portfolioType = portfolioType;
}

public Double getPortfolioReturn() {
	return portfolioReturn;
}

public void setPortfolioReturn(Double portfolioReturn) {
	this.portfolioReturn = portfolioReturn;
}

public Double getPortfolioRisk() {
	return portfolioRisk;
}

public void setPortfolioRisk(Double portfolioRisk) {
	this.portfolioRisk = portfolioRisk;
}

public Double getInitalInvestment() {
	return initalInvestment;
}

public void setInitalInvestment(Double initalInvestment) {
	this.initalInvestment = initalInvestment;
}

public Integer getInvestmentPeriod() {
	return investmentPeriod;
}

public void setInvestmentPeriod(Integer investmentPeriod) {
	this.investmentPeriod = investmentPeriod;
}



}
