package tk.newsoulmate.web.common.sevice;

import tk.newsoulmate.domain.dao.ShelterDao;
import tk.newsoulmate.domain.vo.City;
import tk.newsoulmate.domain.vo.Shelter;
import tk.newsoulmate.domain.vo.Village;
import tk.newsoulmate.web.common.JDBCTemplet;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

public class ShelterService {

    public ArrayList<Shelter> selectList(){
        Connection conn = JDBCTemplet.getConnection();

        ArrayList<Shelter> list = new ShelterDao().selectList(conn);

        JDBCTemplet.close();

        return list;
    }

    public ArrayList<City> selectCity(){
        Connection conn = JDBCTemplet.getConnection();

        ArrayList<City> cList = new ShelterDao().selectCity(conn);

        JDBCTemplet.close();

        return cList;
    }
    public ArrayList<Village> selectVillage(){

        Connection conn = JDBCTemplet.getConnection();

        ArrayList<Village> vList = new ShelterDao().selectVillage(conn);

        JDBCTemplet.close();

        return vList;
    }

    public ArrayList<Village> selectCity2(int cityNo){
        Connection conn = JDBCTemplet.getConnection();

        ArrayList<Village> vList2 = new ShelterDao().selectCity2(cityNo,conn);

        JDBCTemplet.close();

        return vList2;
    }

    public ArrayList<Shelter> selectVillage2(int villageNo){
        Connection conn = JDBCTemplet.getConnection();

        ArrayList<Shelter> sList2 = new ShelterDao().selectVillage2(villageNo,conn);

        JDBCTemplet.close();

        return sList2;
    }
}
