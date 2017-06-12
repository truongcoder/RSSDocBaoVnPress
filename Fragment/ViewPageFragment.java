package a200390.pctruong.com.docbaodantri.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by PCTRUONG on 1/9/2017.
 */

public class ViewPageFragment extends FragmentPagerAdapter {
    public ViewPageFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0 : fragment=new Fragment_TrangChu();break;
            case 1 : fragment=new Fragment_PhapLuat(); break;
            case 2 : fragment=new Fragment_TheThao(); break;
            case 3 : fragment=new Fragment_GiaiTri(); break;
            case 4 : fragment=new Fragment_DuLich(); break;
            case 5 : fragment=new Fragment_TinhYeu(); break;
            case 6 : fragment=new Fragment_ChuyenLa(); break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0 : title="Trang Chủ";break;
            case 1 : title="Pháp Luật"; break;
            case 2 :title="Thể Thao"; break;
            case 3 : title="Giải Trí";break;
            case 4 : title="Du Lịch"; break;
            case 5 : title="Tình Yêu"; break;
            case 6 : title="Chuyện Lạ"; break;
        }
        return title;
    }
}
