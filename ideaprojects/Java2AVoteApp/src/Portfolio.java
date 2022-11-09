public class Portfolio {
    private String portfolioName;
    private boolean isVotedFor;

    public String getPortfolioName() {
        return this.portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public boolean isVotedForPortfolio() {
        return this.isVotedFor;
    }

    public void setVoteState (boolean state) {
        this.isVotedFor = state;
    }

    Portfolio(String portfolioName) {
        setPortfolioName(portfolioName);
    }
}