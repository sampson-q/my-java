public class Portfolio {
    private String portfolioName;

    public String getPortfolioName() {
        return this.portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    Portfolio(String portfolioName) {
        setPortfolioName(portfolioName);
    }
}
