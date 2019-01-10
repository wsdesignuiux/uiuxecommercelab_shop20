package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragement.Jeans;
import fragement.Pants;
import fragement.Sankers;
import fragement.Shorts;
import fragement.Tights;

public class Tab_adapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Tab_adapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Jeans tab1 = new Jeans();
                return tab1;
            case 1:
                Pants tab2 = new Pants();
                return tab2;
            case 2:
                Sankers tab3 = new Sankers();
                return tab3;
            case 3:
                Shorts tab4 = new Shorts();
                return tab4;
            case 4:
                Tights tab5 = new Tights();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
