public class Portfolio {
    private String portfolioName;

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    Portfolio(String portfolioName) {
        setPortfolioName(portfolioName);
    }
}
