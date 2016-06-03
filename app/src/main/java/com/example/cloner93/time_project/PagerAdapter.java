package com.example.cloner93.time_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            case 3:
                TabFragment4 tab4 = new TabFragment4();
                return tab4;
            case 4:
                TabFragment5 tab5 = new TabFragment5();
                return tab5;
            case 5:
                TabFragment6 tab6 = new TabFragment6();
                return tab6;
            case 6:
                TabFragment7 tab7 = new TabFragment7();
                return tab7;
            case 7:
                TabFragment8 tab8 = new TabFragment8();
                return tab8;
            case 8:
                TabFragment9 tab9 = new TabFragment9();
                return tab9;
            case 9:
                TabFragment10 tab10 = new TabFragment10();
                return tab10;
           //case 10:
           //    TabFragment11 tab11 = new TabFragment11();
           //    return tab11;
           //case 11:
           //    TabFragment12 tab12 = new TabFragment12();
           //    return tab12;
           //case 12:
           //    TabFragment13 tab13 = new TabFragment13();
           //    return tab13;
           //case 13:
           //    TabFragment14 tab14 = new TabFragment14();
           //    return tab14;
           //case 14:
           //    TabFragment15 tab15 = new TabFragment15();
           //    return tab15;
           //case 15:
           //    TabFragment16 tab16 = new TabFragment16();
           //    return tab16;
           //case 16:
           //    TabFragment17 tab17 = new TabFragment17();
           //    return tab17;
           //case 17:
           //    TabFragment18 tab18 = new TabFragment18();
           //    return tab18;
           //case 18:
           //    TabFragment19 tab19 = new TabFragment19();
           //    return tab19;
           //case 19:
           //    TabFragment20 tab20 = new TabFragment20();
           //    return tab20;
           //case 20:
           //    TabFragment21 tab21 = new TabFragment21();
           //    return tab21;
           //case 21:
           //    TabFragment22 tab22 = new TabFragment22();
           //    return tab22;
           //case 22:
           //    TabFragment23 tab23 = new TabFragment23();
           //    return tab23;
           //case 23:
           //    TabFragment24 tab24 = new TabFragment24();
           //    return tab24;
           //case 24:
           //    TabFragment25 tab25 = new TabFragment25();
           //    return tab25;
           //case 25:
           //    TabFragment26 tab26 = new TabFragment26();
           //    return tab26;
           //case 26:
           //    TabFragment27 tab27 = new TabFragment27();
           //    return tab27;
           //case 27:
           //    TabFragment28 tab28 = new TabFragment28();
           //    return tab28;
           //case 28:
           //    TabFragment29 tab29 = new TabFragment29();
           //    return tab29;
           //case 29:
           //    TabFragment30 tab30 = new TabFragment30();
           //    return tab30;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}