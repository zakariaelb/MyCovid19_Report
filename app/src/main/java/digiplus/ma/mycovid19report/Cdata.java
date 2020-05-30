package digiplus.ma.mycovid19report;

public class Cdata {
    private String mRegion;
    private double mCases;
    //private String mTimeInMilliseconds;
    private long mTimeInMilliseconds;

    public Cdata(String region, double cases, long timeInMilliseconds){
        mRegion = region;
        mCases = cases;
        //mTimeInMilliseconds = timeInMilliseconds;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getmRegion() {
        return mRegion;
    }

    public double getmCases() {
        return mCases;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
