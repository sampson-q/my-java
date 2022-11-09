public class PurchaseID {
    int totalNumberOfItems;
    double subTotalShirts, subTotalSkirts, totalPurchase, totalDiscount, subTotalScarfs;

    double totals (ItemsID itm, PricesID pri) {
        this.totalNumberOfItems = itm.getNumberOfShirt() + itm.getNumberOfSkirt() + itm.getNumberOfScarf();

        this.subTotalShirts = pri.getPriceShirt() * itm.getNumberOfShirt();
        this.subTotalSkirts = pri.getPriceSkirt() * itm.getNumberOfSkirt();
        this.subTotalScarfs = pri.getPriceScarf() * itm.getNumberOfScarf();

        this.totalPurchase = this.subTotalShirts + this.subTotalSkirts + this.subTotalScarfs;

        this.totalDiscount = 0.25 * totalPurchase;

        return 0.0;
    }

    public int getTotalNumberOfItems() {
        return totalNumberOfItems;
    }

    public void setTotalNumberOfItems(int totalNumberOfItems) {
        this.totalNumberOfItems = totalNumberOfItems;
    }

    public double getSubTotalShirts() {
        return subTotalShirts;
    }

    public void setSubTotalShirts(double subTotalShirts) {
        this.subTotalShirts = subTotalShirts;
    }

    public double getSubTotalSkirts() {
        return subTotalSkirts;
    }

    public void setSubTotalSkirts(double subTotalSkirts) {
        this.subTotalSkirts = subTotalSkirts;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getSubTotalScarfs() {
        return subTotalScarfs;
    }

    public void setSubTotalScarfs(double subTotalScarfs) {
        this.subTotalScarfs = subTotalScarfs;
    }
}
