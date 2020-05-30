package digiplus.ma.mycovid19report;

public class Cdata {
    private String mRegion;
    private String mCases;
    //private String mTimeInMilliseconds;
    private long mTimeInMilliseconds;

    public Cdata(String region, String cases, long timeInMilliseconds){
        mRegion = region;
        mCases = cases;
        //mTimeInMilliseconds = timeInMilliseconds;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getmRegion() {
        return mRegion;
    }

    public String getmCases() {
        return mCases;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
