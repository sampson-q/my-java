public class Portfolio {
    private boolean votedState;
    private String portfolioName;
    private String[] voterIDs = new String[15];

    public String[] getVoterIDs() {
        return voterIDs;
    }

    public boolean getVotedState() {
        return votedState;
    }

    public void setVotedState(boolean votedState) {
        this.votedState = votedState;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    Portfolio(String portfolioName) {
        setPortfolioName(portfolioName);
    }
}
