package tk.newsoulmate.domain.dao;

import tk.newsoulmate.domain.vo.City;
import tk.newsoulmate.domain.vo.Shelter;
import tk.newsoulmate.domain.vo.Village;
import tk.newsoulmate.web.common.JDBCTemplet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class ShelterDao {
    private static Properties prop=new Properties();

    public ShelterDao(){
        try {
            prop.loadFromXML(new FileInputStream(ShelterDao.class.getResource("/sql/shelter/shelter-mapper.xml").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Shelter> selectList(Connection conn){

        // select 문 resultSet
        ArrayList<Shelter> list = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectList");

        try {
            psmt = conn.prepareStatement(sql);

            rset = psmt.executeQuery();

            while(rset.next()){
                list.add(new Shelter(rset.getString("SHELTER_NAME"),
                                     rset.getString("SHELTER_ADDRESS"),
                                     rset.getString("SHELTER_LANDLINE")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return list;
    }

    public ArrayList<City> selectCity(Connection conn){
        ArrayList<City> cList = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectCity");

        try {
            psmt = conn.prepareStatement(sql);

            rset = psmt.executeQuery();

            while(rset.next()){
                cList.add(new City(rset.getLong("CITY_NO"),
                                   rset.getString("CITY_NAME")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return cList;
    }

    public ArrayList<Village> selectVillage(Connection conn){
        ArrayList<Village> vList = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectVillage");

        try {
            psmt = conn.prepareStatement(sql);

            rset = psmt.executeQuery();
            while(rset.next()){
                vList.add(new Village(rset.getLong("VILLAGE_NO"),
                        rset.getLong("CITY_NO"),
                        rset.getString("VILLAGE_NAME")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return vList;
    }

    public ArrayList<Village> selectCity2(int cityNo, Connection conn){
        ArrayList<Village> vList2 = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectCity2");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1,cityNo);

            rset = psmt.executeQuery();

            while(rset.next()){
                vList2.add(new Village(rset.getLong("CITY_NO"),
                                       rset.getLong("VILLAGE_NO"),
                                       rset.getString("VILLAGE_NAME")));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return vList2;
    }

    public ArrayList<Shelter> selectVillage2(int villageNo, Connection conn){
        ArrayList<Shelter> sList2 = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectVillage2");

        try {
            psmt = conn.prepareStatement(sql);

            psmt.setInt(1,villageNo);

            rset = psmt.executeQuery();

            while(rset.next()) {
                sList2.add(new Shelter(
                        rset.getString("SHELTER_NAME"),
                        rset.getString("SHELTER_ADDRESS"),
                        rset.getString("SHELTER_LANDLINE"),
                        rset.getLong("VILLAGE_NO"),
                        rset.getLong("SHELTER_NO")));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplet.close(rset);
            JDBCTemplet.close(psmt);
        }
        return sList2;
    }


}
