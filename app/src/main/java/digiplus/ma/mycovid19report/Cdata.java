package digiplus.ma.mycovid19report;

public class Cdata {
    private String mRegion;
    private String mCases;
    private String mTimeInMilliseconds;

    public Cdata(String region, String cases, String timeInMilliseconds){
        mRegion = region;
        mCases = cases;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getmRegion() {
        return mRegion;
    }

    public String getmCases() {
        return mCases;
    }

    public String getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
